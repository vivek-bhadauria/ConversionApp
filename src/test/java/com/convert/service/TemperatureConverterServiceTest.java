package com.convert.service;

import com.convert.model.FromType;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class TemperatureConverterServiceTest {

  @InjectMocks
  private TemperatureConverterService converterServiceMock = new TemperatureConverterService();

  @Mock private Map<FromType, Double> multiplicationFactorMapMock;

  @Test
  public void convert_inputInCelsius_outputInFahrenheit() {
    // when
    when(multiplicationFactorMapMock.get(FromType.CELSIUS)).thenReturn(9.0 / 5.0);
    when(multiplicationFactorMapMock.get(FromType.CELSIUS)).thenReturn(32.0);

    // then
    double result = converterServiceMock.convert(FromType.CELSIUS, 32.0);

    assertEquals(89.6, result, 0.0);
  }

  @Test
  public void convert_inputInFahrenheit_outputInCelsius() {
    // when
    when(multiplicationFactorMapMock.get(FromType.FAHRENHEIT)).thenReturn(5.0 / 9.0);
    when(multiplicationFactorMapMock.get(FromType.FAHRENHEIT)).thenReturn(-1 * (5.0 / 9.0) * 32);

    // then
    double result = converterServiceMock.convert(FromType.FAHRENHEIT, 89.6);

    assertEquals(32.0, result, 0.0);
  }
}
