package com.convert.util;

import com.convert.model.FromType;
import com.convert.model.MetricType;

import java.util.*;

import static com.convert.model.FromType.*;
import static com.convert.model.FromType.RADIAN;
import static com.convert.model.MetricType.*;

public class ConversionUtil {

    private static final Map<MetricType, Set<FromType>> typeMappings = new HashMap<>();
    static {
        typeMappings.put(TEMPERATURE, newHashSet(CELSIUS, FAHRENHEIT));
        typeMappings.put(WEIGHT, newHashSet(KILOGRAMS, POUNDS));
        typeMappings.put(LENGTH, newHashSet(KILOMETERS, MILES));
        typeMappings.put(VOLUME, newHashSet(LITRES, GALLONS));
        typeMappings.put(ANGLE, newHashSet(DEGREE, RADIAN));
    }
    public static final <T> Set<T> newHashSet(T... objs) {
        Set<T> set = new HashSet<>();
        Collections.addAll(set, objs);
        return set;
    }

    public static FromType complement(MetricType metricType,FromType inputType){
        Optional<FromType> result = typeMappings.get(metricType).stream().filter(type -> type!=inputType).findFirst();
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    public static Map<MetricType, Set<FromType>> getTypeMappings(){
        return typeMappings;
    }
}
