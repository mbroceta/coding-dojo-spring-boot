package com.assignment.spring.service;


import com.assignment.spring.dto.WeatherEntityDTO;
import com.assignment.spring.entity.WeatherEntity;


public interface WeatherService {

    WeatherEntityDTO findByCity(String city);

}
