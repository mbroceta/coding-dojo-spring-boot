package com.assignment.spring.api;

import com.assignment.spring.dto.WeatherEntityDTO;
import com.assignment.spring.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    WeatherServiceImpl weatherService;

    @RequestMapping(value = "/weather")
    public ResponseEntity<WeatherEntityDTO> weather(@RequestParam String city){
        return new ResponseEntity<>(weatherService.findByCity(city), HttpStatus.OK);
    }

}
