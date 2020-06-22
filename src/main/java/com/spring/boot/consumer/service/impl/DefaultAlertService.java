package com.spring.boot.consumer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.consumer.model.WeatherAlert;
import com.spring.boot.consumer.repository.AlertRepository;
import com.spring.boot.consumer.service.AlertService;

@Service
public class DefaultAlertService implements AlertService {
	
	private AlertRepository  alertRepository;
	
	public DefaultAlertService(AlertRepository alertRepository) {
		this.alertRepository = alertRepository;
	}

	@Override
	public Boolean addAlerts(WeatherAlert weatherAlert) {
		alertRepository.save(weatherAlert);
		System.out.println(weatherAlert);
		return true;
	}

	@Override
	public List<WeatherAlert> getAllAlerts() {
		List<WeatherAlert> weatherAlertList = alertRepository.findAll();
		return weatherAlertList;
	}

}
