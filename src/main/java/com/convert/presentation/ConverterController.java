package com.convert.presentation;

import com.convert.model.FromType;
import com.convert.model.MetricType;
import com.convert.service.factory.ConverterServiceFactory;
import com.convert.util.ConversionUtil;
import com.convert.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/convert")
public class ConverterController {

  @Autowired private ConverterServiceFactory converterServiceFactory;

  @Autowired private Validator validator;

  public ConverterController(ConverterServiceFactory converterServiceFactory, Validator validator){
    this.converterServiceFactory = converterServiceFactory;
    this.validator = validator;
  }

  @RequestMapping(
      value = "/{metricType}/{valueType}/{value}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> getConversion(
      @PathVariable String metricType, @PathVariable String valueType, @PathVariable double value) {

    if (!validator.isValid(metricType, valueType)) {
      return ResponseEntity.notFound().build();
    }

    MetricType metricVal = MetricType.valueOf(metricType.toUpperCase());
    FromType valueTypeVal = FromType.valueOf(valueType.toUpperCase());
    double result =
        converterServiceFactory.getConverterService(metricVal).convert(valueTypeVal, value);

    return ResponseEntity.ok()
        .body(
            "Value "
                + value
                + " in "
                + valueTypeVal
                + " converted to "
                + result
                + " in "
                + ConversionUtil.complement(metricVal, valueTypeVal));
  }
}
