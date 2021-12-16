package com.convert.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.convert.*")
public class ConversionApp {

  public static void main(String[] args) {
    SpringApplication.run(ConversionApp.class, args);
  }
}
