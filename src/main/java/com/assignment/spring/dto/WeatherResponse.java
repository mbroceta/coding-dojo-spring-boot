
package com.assignment.spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "weather",
    "base",
    "main",
    "visibility",
    "dt",
    "sys",
    "id",
    "name",
    "cod"
})
public class WeatherResponse {

    private List<Weather> weather = null;
    private String base;
    private Main main;
    private Integer visibility;
    private Integer dt;
    private Sys sys;
    private Integer id;
    private String name;
    private Integer cod;


}
