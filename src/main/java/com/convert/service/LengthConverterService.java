package com.convert.service;

import com.convert.model.FromType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LengthConverterService implements ConverterService{

    private Map<FromType, Double> multiplicationFactorMap = new HashMap<>();
    public LengthConverterService(){
        multiplicationFactorMap.put(FromType.KILOMETERS, 0.62);
        multiplicationFactorMap.put(FromType.MILES, 1.0/0.62);
    }


    @Override
    public Map<FromType, Double> getMultiplicationFactor() {
        return multiplicationFactorMap;
    }
}
