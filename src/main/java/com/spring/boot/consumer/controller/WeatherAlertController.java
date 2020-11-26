package com.spring.boot.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.consumer.model.Weather;
import com.spring.boot.consumer.model.WeatherAlert;
import com.spring.boot.consumer.service.AlertService;


@RestController
public class WeatherAlertController {
	
	@Autowired
	private AlertService alertService;

	@PostMapping("/addReading")
	public boolean AddReading(@RequestBody WeatherAlert weatherAlert) {
//		alertService.addAlerts(weatherAlert);
		return true;
	}
	
	
	@GetMapping(value = "/test")
	public String testEndPoint() {
		return "TEST";
	}
	
	
	//need to change it to list type
	@PostMapping("/badWeather")
	public boolean BadWeather(@RequestBody List<Weather> weather) {
		//alertService.addAlerts(weather);
		System.out.println(weather.toString());
		return true;
}
	@PostMapping("/badWeatherlist")
	public boolean BadWeather() {
		return true;
}
	
}
