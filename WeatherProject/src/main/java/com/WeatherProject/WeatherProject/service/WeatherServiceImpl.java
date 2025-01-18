package com.WeatherProject.WeatherProject.service;

import com.WeatherProject.WeatherProject.config.PirateConfig;
import com.WeatherProject.WeatherProject.location.Coordinates;
import com.WeatherProject.WeatherProject.weather.WeatherReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
    private final PirateConfig pirateConfig;

    /**
     * Weather Service implementation. Used to build pirateConfig's Web Client and create a weather report object.
     *
     * @param pirateConfig The class that sets up the Web Client to be built for the Weather Report object.
     */
    @Autowired
    public WeatherServiceImpl(PirateConfig pirateConfig) {
        this.pirateConfig = pirateConfig;
    }

    public WeatherReport getWeatherReport(Coordinates coordinates) {
        if (coordinates == null)
            throw new RuntimeException("Invalid location.");
        return pirateConfig.webClientBuilder(coordinates).build().get().retrieve().bodyToMono(WeatherReport.class).block();
    }
}
