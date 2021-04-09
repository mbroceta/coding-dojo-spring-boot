package com.assignment.spring.service;

import com.assignment.spring.response.WeatherResponse;
import com.assignment.spring.converter.WeatherEntityToDTOConverter;
import com.assignment.spring.converter.WeatherResponseToEntityConverter;
import com.assignment.spring.dto.WeatherEntityDTO;
import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.assignment.spring.Constants;

@Service
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WeatherEntityToDTOConverter weatherEntityToDTOConverter;

    @Autowired
    WeatherResponseToEntityConverter weatherResponseToEntityConverter;



    @Override
    public WeatherEntityDTO findByCity(String city) {
        String url = Constants.WEATHER_API_URL.replace("{city}", city).replace("{appid}", Constants.APP_ID);
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
        WeatherEntity weatherEntity = weatherResponseToEntityConverter.convert(response.getBody());
        return weatherEntityToDTOConverter.convert(weatherRepository.save(weatherEntity));
    }

}
