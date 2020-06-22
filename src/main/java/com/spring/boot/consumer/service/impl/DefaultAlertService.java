package com.spring.boot.consumer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.consumer.model.WeatherAlert;
import com.spring.boot.consumer.service.AlertService;

@Service
public class DefaultAlertService implements AlertService {
	
//	private WeatherRepository weatherRepository;

	@Override
	public Boolean addAlerts(WeatherAlert weatherAlert) {
//		weatherRepository.save(weatherAlert);
		System.out.println(weatherAlert);
		return true;
	}

	@Override
	public List<WeatherAlert> getAllAlerts() {
		// TODO Auto-generated method stub
		return null;
	}

}
