package com.assignment.spring.unit.repository;

import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;
import com.assignment.spring.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class WeatherRepositoryTest {

    @Autowired
    private WeatherRepository repository;

    @MockBean
    private WeatherService weatherService;

    @Test
    public void save_data_repository_test() throws Exception {

        WeatherEntity entity = new WeatherEntity();
        entity.setCity("Belgrade");
        entity.setCountry("RS");
        entity.setTemperature(900.50);

        repository.save(entity);
    }

}

