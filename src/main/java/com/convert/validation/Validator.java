package com.convert.validation;

import com.convert.model.FromType;
import com.convert.model.MetricType;
import com.convert.util.ConversionUtil;
import org.springframework.stereotype.Component;

@Component
public class Validator {

  public boolean isValid(String metricType, String valueType) {

    try {
      if (metricType == null || valueType == null) {
        return false;
      }
      return ConversionUtil.getTypeMappings()
          .get(MetricType.valueOf(metricType.toUpperCase()))
          .contains(FromType.valueOf(valueType.toUpperCase()));
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

}
