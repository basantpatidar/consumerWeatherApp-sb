package com.spring.boot.consumer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wind {
	@Id @GeneratedValue
	private int id;

	private double speed;
	
	private double degree;
	
	public Wind() {
		
//		this.id = UUID.randomUUID().toString();
//		System.out.println("Weather Alert =>  "+id);
	}
	

	public Wind(double speed, double degree) {
		super();
		this.speed = speed;
		this.degree = degree;
	}
	
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getDegree() {
		return degree;
	}
	public void setDegree(double degree) {
		this.degree = degree;
	}
	


	@Override
	public String toString() {
		return "Wind [speed=" + speed + ", degree=" + degree + "]";
	}
}
