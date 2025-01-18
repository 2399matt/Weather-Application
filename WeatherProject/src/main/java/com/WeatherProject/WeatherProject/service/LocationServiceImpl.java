package com.WeatherProject.WeatherProject.service;

import com.WeatherProject.WeatherProject.config.OpenConfig;
import com.WeatherProject.WeatherProject.location.Coordinates;
import com.WeatherProject.WeatherProject.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    private final OpenConfig openConfig;

    /**
     * Location Service implementation. Used to build the openConfig's Web Client and retrieve a coordinates object.
     *
     * @param openConfig The class that sets up the Web Client Builder for our call here.
     */
    @Autowired
    public LocationServiceImpl(OpenConfig openConfig) {
        this.openConfig = openConfig;
    }

    public Coordinates getCoordinates(Location location) {
        if (location == null)
            throw new RuntimeException("Invalid location.");
        return openConfig.webClientBuilder(location).build().get().retrieve().bodyToMono(Coordinates.class).block();
    }
}
