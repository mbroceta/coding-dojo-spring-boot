Spring Boot Coding Dojo
---

Welcome to the Spring Boot Coding Dojo! This is a simple application that requests its data from [OpenWeather](https://openweathermap.org/) and stores the result in a database. 

## Table of contents
* [General Info](#general-info)
* [Technologies](#technologies)
* [Installation](#installation)

### General Info
This is a simple application that offers the possibility of fetching weather forecasts for a specific city. It requests data from [OpenWeather](https://openweathermap.org/) and stores the result in a database.

### Technologies
Project is created using:
* Java version: 11.0.10
* Java Spring Boot version: 2.1.6.RELEASE
* PostgreSQL version: 10
* Maven version: 3.8.1
* Tomcat version: 9.0
* Jenkins 

### Installation
To run this project, follow these steps:

```
$ cd ../coding-dojo-sping-boot
$ mvn install
$ ls target/*.*
$ java -jar target/coding-dojo-spring-boot.jar
```
OR

From local environment: http://localhost:8090/coding-dojo-spring-boot/weather?city=

Type a city name to get the city weather forecast.




