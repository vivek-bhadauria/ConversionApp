package com.convert.service;

import com.convert.model.FromType;
import com.sun.el.stream.Optional;

import java.util.Map;
import java.util.function.Function;


public interface ConverterService {
    default double convert(FromType fromType, double value){
        double multipliedValue = getMultiplicationFactor().get(fromType)*value;
        double additionValue = getAdditionFactor() != null ? getAdditionFactor().get(fromType) : 0;
        return multipliedValue + additionValue;
    }
    Map<FromType, Double> getMultiplicationFactor();
    default Map<FromType, Double> getAdditionFactor(){
        return null;
    }
}
