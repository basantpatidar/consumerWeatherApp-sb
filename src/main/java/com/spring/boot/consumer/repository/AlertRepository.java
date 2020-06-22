package com.spring.boot.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.consumer.model.WeatherAlert;

public interface AlertRepository extends JpaRepository<WeatherAlert, String> {

}
