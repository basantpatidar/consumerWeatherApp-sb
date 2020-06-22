package com.spring.boot.consumer.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class WeatherAlert {

	@Id @GeneratedValue
	private int id;
//
//	@Id
//	private String id;
	private String alert;
	@OneToOne(cascade = CascadeType.ALL)
	private Weather weather;
	
	public WeatherAlert() {
		
	}

	public WeatherAlert(String alert, Weather weather) {
		super();
//		System.out.println("Weather Alert =>  "+id);
//		this.id = UUID.randomUUID().toString();
		this.alert = alert;
		this.weather = weather;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		return "WeatherAlert [alert=" + alert + ", weather=" + weather + "]";
	}

}
