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
public class VolumeConverterServiceTest {

    @InjectMocks private VolumeConverterService converterServiceMock = new VolumeConverterService();

    @Mock private Map<FromType, Double> multiplicationFactorMapMock;

    @Test
    public void convert_inputInLtrs_outputInGallons() {
        // when
        when(multiplicationFactorMapMock.get(FromType.LITRES)).thenReturn(0.26);

        // then
        double result = converterServiceMock.convert(FromType.LITRES, 10);

        assertEquals(2.60, result, 0.0);
    }

    @Test
    public void convert_inputInGallons_outputInLtrs() {
        // when
        when(multiplicationFactorMapMock.get(FromType.GALLONS)).thenReturn(1.0 / 0.26);

        // then
        double result = converterServiceMock.convert(FromType.GALLONS, 2.60);

        assertEquals(10, result, 0.000001);
    }
}
