package com.spring.boot.consumer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.consumer.model.Weather;
import com.spring.boot.consumer.model.WeatherAlert;
import com.spring.boot.consumer.repository.AlertRepository;
import com.spring.boot.consumer.repository.WeatherRepository;
import com.spring.boot.consumer.service.AlertService;

@Service
public class DefaultAlertService implements AlertService {
	
	@Autowired
	private AlertRepository  alertRepository;
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	public DefaultAlertService(AlertRepository alertRepository) {
		this.alertRepository = alertRepository;
	}

	@Override
	public Boolean addAlerts(WeatherAlert weatherAlert) {
		alertRepository.save(weatherAlert);
		System.out.println(weatherAlert);
		return true;
	}
	
//	@Override
//	public Boolean addAlerts(List<WeatherAlert> weatherAlert) {
//		alertRepository.saveAll(weatherAlert);
//		System.out.println(weatherAlert);
//		return true;
//	}

	@Override
	public List<WeatherAlert> getAllAlerts() {
		List<WeatherAlert> weatherAlertList = alertRepository.findAll();
		return weatherAlertList;
	}

	@Override
	public Boolean addAlerts(Weather weather) {
		weatherRepository.save(weather);
		return true;
	}

}
