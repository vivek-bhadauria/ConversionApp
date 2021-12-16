package com.convert.service;

import com.convert.model.FromType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeightConverterService implements ConverterService{

    Map<FromType, Double> multiplicationFactorMap = new HashMap<>();
    public WeightConverterService(){
        multiplicationFactorMap.put(FromType.KILOGRAMS, 2.20);
        multiplicationFactorMap.put(FromType.POUNDS, 1.0/2.20);
    }


    @Override
    public Map<FromType, Double> getMultiplicationFactor() {
        return multiplicationFactorMap;
    }
}
