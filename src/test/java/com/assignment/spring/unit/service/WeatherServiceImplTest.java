package com.assignment.spring.unit.service;

import com.assignment.spring.config.Constants;
import com.assignment.spring.converter.WeatherResponseToEntityConverter;
import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;
import com.assignment.spring.dto.WeatherResponse;

import com.assignment.spring.service.impl.WeatherServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class WeatherServiceImplTest {


    @Mock
    RestTemplate restTemplate;

    @Mock
    ResponseEntity<WeatherResponse> response;

    @Mock
    WeatherResponse weatherResponse;

    @Mock
    WeatherEntity weatherEntity;

    @Mock
    WeatherRepository repository;

    @Mock
    WeatherResponseToEntityConverter converter;

    @Mock
    Constants constants;

    private MockRestServiceServer mockServer;

    @Value("${weather.api.url}")
    String apiUrl;

    @Value("${weather.api.key}")
    String apiKey;

    @InjectMocks
    private WeatherServiceImpl weatherService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
         mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testFindByCity(){
        String url = apiUrl.replace("{city}", "Novi Sad").replace("{appid}", apiKey);
        when(restTemplate.getForEntity(url, WeatherResponse.class)).thenReturn(response);

        when(response.getBody()).thenReturn(weatherResponse);
        when(converter.convert(weatherResponse)).thenReturn(weatherEntity);
        when(repository.save(weatherEntity)).thenReturn(weatherEntity);

        WeatherEntity we = weatherService.findByCity("Novi Sad");

        assertEquals(we, weatherEntity);
    }
}
