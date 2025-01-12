package com.WeatherProject.WeatherProject.service;

import com.WeatherProject.WeatherProject.config.OpenConfig;
import com.WeatherProject.WeatherProject.location.Coordinates;
import com.WeatherProject.WeatherProject.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    private final OpenConfig openConfig;

    @Autowired
    public LocationServiceImpl(OpenConfig openConfig) {
        this.openConfig = openConfig;
    }

    public Coordinates getCoordinates(Location location) {
        return openConfig.webClientBuilder(location).build().get().retrieve().bodyToMono(Coordinates.class).block();
    }
}
