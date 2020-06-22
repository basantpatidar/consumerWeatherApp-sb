package com.spring.boot.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.consumer.model.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, String>{

}
