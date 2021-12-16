package com.convert.service;

import com.convert.model.FromType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class TemperatureConverterService implements ConverterService{
    private Map<FromType, Double> multiplicationFactorMap = new HashMap<>();
    private Map<FromType, Double> additionFactorMap = new HashMap<>();

    public TemperatureConverterService(){
        multiplicationFactorMap.put(FromType.CELSIUS, 9.0/5.0);
        multiplicationFactorMap.put(FromType.FAHRENHEIT, 5.0/9.0);
        additionFactorMap.put(FromType.CELSIUS, 32.0);
        additionFactorMap.put(FromType.FAHRENHEIT, -1*(5.0/9.0)*32);
    }

    @Override
    public Map<FromType, Double> getMultiplicationFactor() {
        return multiplicationFactorMap;
    }

    @Override
    public Map<FromType, Double> getAdditionFactor() {
        return additionFactorMap;
    }
}
