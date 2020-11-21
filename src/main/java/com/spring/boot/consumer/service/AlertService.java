package com.spring.boot.consumer.service;

import java.util.List;

import com.spring.boot.consumer.model.Weather;
import com.spring.boot.consumer.model.WeatherAlert;

public interface AlertService {
	
	public Boolean addAlerts(List<Weather> weather);
	public List<WeatherAlert> getAllAlerts();
	public Boolean addAlerts(Weather weather);
}
