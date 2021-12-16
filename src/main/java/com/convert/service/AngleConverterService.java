package com.convert.service;

import com.convert.model.FromType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class AngleConverterService implements ConverterService{

    private Map<FromType, Double> multiplicationFactorMap = new HashMap<>();
    public AngleConverterService(){
        multiplicationFactorMap.put(FromType.DEGREE, 0.01745);
        multiplicationFactorMap.put(FromType.RADIAN, 1.0/0.01745);
    }


    @Override
    public Map<FromType, Double> getMultiplicationFactor() {
        return multiplicationFactorMap;
    }
}
