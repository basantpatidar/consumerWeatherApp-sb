package com.spring.boot.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.spring.boot.consumer.aws.WeatherAlertsListenerSqs;

@SpringBootApplication
//@ComponentScan(basePackages = "com.spring.boot.consumer")
public class ConsumerWeatherAppApplication {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		ApplicationContext applicationContext = SpringApplication.run(ConsumerWeatherAppApplication.class, args);
		WeatherAlertsListenerSqs weatherAlertsListenerSqs = applicationContext.getBean(WeatherAlertsListenerSqs.class);
		weatherAlertsListenerSqs.startListeningToMessages();
	}

}
