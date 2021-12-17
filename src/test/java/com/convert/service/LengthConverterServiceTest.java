package com.convert.service;

import com.convert.model.FromType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LengthConverterServiceTest {

  @InjectMocks private LengthConverterService converterServiceMock = new LengthConverterService();

  @Mock private Map<FromType, Double> multiplicationFactorMapMock;

  @Test
  public void convert_inputInKms_outputInMiles() {
    // when
    when(multiplicationFactorMapMock.get(FromType.KILOMETERS)).thenReturn(0.62);

    // then
    double result = converterServiceMock.convert(FromType.KILOMETERS, 10);

    assertEquals(6.20, result, 0.0);
  }

  @Test
  public void convert_inputInMiles_outputInKms() {
    // when
    when(multiplicationFactorMapMock.get(FromType.MILES)).thenReturn(1.0 / 0.62);

    // then
    double result = converterServiceMock.convert(FromType.MILES, 6.20);

    assertEquals(10, result, 0.0001);
  }
}
