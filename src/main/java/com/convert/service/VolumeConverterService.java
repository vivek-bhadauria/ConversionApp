package com.convert.service;

import com.convert.model.FromType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VolumeConverterService implements ConverterService{

    private Map<FromType, Double> multiplicationFactorMap = new HashMap<>();
    public VolumeConverterService(){
        multiplicationFactorMap.put(FromType.LITRES, 0.26);
        multiplicationFactorMap.put(FromType.GALLONS, 1.0/0.26);
    }


    @Override
    public Map<FromType, Double> getMultiplicationFactor() {
        return multiplicationFactorMap;
    }
}
