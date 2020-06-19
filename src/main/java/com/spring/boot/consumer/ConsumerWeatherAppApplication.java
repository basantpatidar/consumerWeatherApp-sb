package com.spring.boot.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ConsumerWeatherAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerWeatherAppApplication.class, args);
		System.out.println("in config class");
	}

}
