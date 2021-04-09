package com.assignment.spring.service.impl;

import com.assignment.spring.config.Constants;
import com.assignment.spring.converter.WeatherResponseToEntityConverter;
import com.assignment.spring.dto.WeatherResponse;
import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;
import com.assignment.spring.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    final WeatherRepository weatherRepository;

    final RestTemplate restTemplate;

    final WeatherResponseToEntityConverter weatherResponseToEntityConverter;

    public WeatherEntity findByCity(String city) {
        String url = Constants.WEATHER_API_URL.replace("{city}", city).replace("{appid}", Constants.APP_ID);
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
        WeatherEntity weatherEntity = weatherResponseToEntityConverter.convert(response.getBody());
        return weatherRepository.save(weatherEntity);
    }
}
