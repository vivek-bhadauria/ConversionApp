package com.convert.service.factory;

import com.convert.model.MetricType;
import com.convert.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterServiceFactory {

    @Autowired
    private TemperatureConverterService temperatureConverterService;

    @Autowired
    private WeightConverterService weightConverterService;

    @Autowired
    private LengthConverterService lengthConverterService;

    @Autowired
    private VolumeConverterService volumeConverterService;

    @Autowired
    private AngleConverterService angleConverterService;

    public ConverterService getConverterService(MetricType metricType){

        switch (metricType)  {
            case TEMPERATURE: return temperatureConverterService;
            case WEIGHT: return weightConverterService;
            case LENGTH: return lengthConverterService;
            case VOLUME: return volumeConverterService;
            case ANGLE: return angleConverterService;
        }
        return null;
    }
}
