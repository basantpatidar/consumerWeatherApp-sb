package com.spring.boot.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.boot.consumer.model.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, String>{
	
	@Query(value="UPDATE weather_reading w SET temperature = 10 WHERE timestamp = '2020-06-16 08:23:59.500000'", nativeQuery=true)
    public void updateTemp(@Param("city") String username, @Param("temp") double temp);

}
