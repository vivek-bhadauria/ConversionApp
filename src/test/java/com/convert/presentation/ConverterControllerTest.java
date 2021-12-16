package com.convert.presentation;

import com.convert.service.ConverterService;
import com.convert.service.factory.ConverterServiceFactory;
import com.convert.validation.Validator;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class ConverterControllerTest {
    @InjectMocks
    private ConverterController converterController;

    @Mock
    private ConverterServiceFactory converterServiceFactory;

    @Mock
    private Validator validator;

    @Mock
    private ConverterService converterService;

    @Test
    public void testGetConversion_correctInputs_correctOutput(){
        when(validator.isValid(any(),any())).thenReturn(true);
        when(converterServiceFactory.getConverterService(any())).thenReturn(converterService);
        ResponseEntity result = converterController.getConversion("temperature","celsius",32.0);

        assertNotNull(result);
    }

    @Test
    public void testGetConversion_incorrectInputs_errorCodeInOutput(){
        when(validator.isValid(any(),any())).thenReturn(false);
        when(converterServiceFactory.getConverterService(any())).thenReturn(converterService);
        ResponseEntity result = converterController.getConversion("temperatur","fahrenheit",92.0);

        assertEquals("<404 NOT_FOUND Not Found,[]>", result.toString());

    }
}
