package com.spring.boot.consumer.service;

import java.util.List;

import com.spring.boot.consumer.model.Weather;
import com.spring.boot.consumer.model.WeatherAlert;

public interface AlertService {
	
	public List<WeatherAlert> getAllAlerts();
	public Boolean addAlerts(Weather weather);
	Boolean addAlerts(WeatherAlert weatherAlert);
	Boolean addAlerts(List<WeatherAlert> weatherAlert);
}
