package com.assignment.spring.converter;

import com.assignment.spring.dto.WeatherResponse;
import com.assignment.spring.entity.WeatherEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WeatherResponseToEntityConverter implements Converter<WeatherResponse, WeatherEntity> {

    @Override
    public WeatherEntity convert(WeatherResponse weatherResponse) {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setCity(weatherResponse.getName());
        weatherEntity.setCountry(weatherResponse.getSys().getCountry());
        weatherEntity.setTemperature(weatherResponse.getMain().getTemp());

        return weatherEntity;
    }
}
