package com.assignment.spring.service;

import com.assignment.spring.api.WeatherResponse;
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

    @Value("${weather.api.url}")
    String apiUrl;

    @Value("${weather.api.key}")
    String apiKey;

    @Override
    public WeatherEntityDTO findByCity(String city) {
        String url = apiUrl.replace("{city}", city).replace("{appid}", apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
        WeatherEntity weatherEntity = weatherResponseToEntityConverter.convert(response.getBody());
        return weatherEntityToDTOConverter.convert(weatherRepository.save(weatherEntity));
    }

}
