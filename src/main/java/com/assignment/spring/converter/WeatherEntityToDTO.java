package com.assignment.spring.converter;

import com.assignment.spring.dto.WeatherEntityDTO;
import com.assignment.spring.entity.WeatherEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WeatherEntityToDTO implements Converter<WeatherEntity, WeatherEntityDTO> {

    @Override
    public WeatherEntityDTO convert(WeatherEntity weatherEntity) {
        WeatherEntityDTO weatherEntityDTO = new WeatherEntityDTO();
        weatherEntityDTO.setCity(weatherEntity.getCity());
        weatherEntityDTO.setCountry(weatherEntity.getCountry());
        weatherEntityDTO.setTemperature(weatherEntity.getTemperature());

        return weatherEntityDTO;
    }
}
