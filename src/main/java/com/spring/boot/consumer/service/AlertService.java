package com.spring.boot.consumer.service;

import java.util.List;

import com.spring.boot.consumer.model.WeatherAlert;

public interface AlertService {
	
	public Boolean addAlerts(WeatherAlert weatherAlert);
	public List<WeatherAlert> getAllAlerts();
}