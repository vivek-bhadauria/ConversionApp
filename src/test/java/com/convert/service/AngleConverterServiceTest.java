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
public class AngleConverterServiceTest {

    @InjectMocks private AngleConverterService converterServiceMock = new AngleConverterService();

    @Mock private Map<FromType, Double> multiplicationFactorMapMock;

    @Test
    public void convert_inputInDegree_outputInRadian() {
        // when
        when(multiplicationFactorMapMock.get(FromType.DEGREE)).thenReturn(0.01745);

        // then
        double result = converterServiceMock.convert(FromType.DEGREE, 180.0);

        assertEquals(3.141, result, 0.0001);
    }

    @Test
    public void convert_inputInRadian_outputInDegree() {
        // when
        when(multiplicationFactorMapMock.get(FromType.RADIAN)).thenReturn(1.0 / 0.01745);

        // then
        double result = converterServiceMock.convert(FromType.RADIAN, 3.141);

        assertEquals(180, result, 0.0001);
    }
}
