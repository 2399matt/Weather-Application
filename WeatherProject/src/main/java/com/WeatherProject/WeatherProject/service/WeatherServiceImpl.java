package com.WeatherProject.WeatherProject.service;

import com.WeatherProject.WeatherProject.config.PirateConfig;
import com.WeatherProject.WeatherProject.location.Coordinates;
import com.WeatherProject.WeatherProject.weather.WeatherReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements  WeatherService{
    private final PirateConfig pirateConfig;

    @Autowired
    public WeatherServiceImpl(PirateConfig pirateConfig) {
        this.pirateConfig = pirateConfig;
    }

    public WeatherReport getWeatherReport(Coordinates coordinates) {
        return pirateConfig.webClientBuilder(coordinates).build().get().retrieve().bodyToMono(WeatherReport.class).block();
    }
}
