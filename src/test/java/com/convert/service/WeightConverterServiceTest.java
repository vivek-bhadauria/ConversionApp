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
public class WeightConverterServiceTest {

  @InjectMocks private WeightConverterService converterServiceMock = new WeightConverterService();

  @Mock private Map<FromType, Double> multiplicationFactorMapMock;

  @Test
  public void convert_inputInKgs_outputInPounds() {
    // when
    when(multiplicationFactorMapMock.get(FromType.KILOGRAMS)).thenReturn(2.20);

    // then
    double result = converterServiceMock.convert(FromType.KILOGRAMS, 1.0);

    assertEquals(2.20, result, 0.0);
  }

  @Test
  public void convert_inputInPounds_outputInKgs() {
    // when
    when(multiplicationFactorMapMock.get(FromType.POUNDS)).thenReturn(1.0 / 2.20);

    // then
    double result = converterServiceMock.convert(FromType.POUNDS, 2.20);

    assertEquals(1.0, result, 0.0);
  }
}
