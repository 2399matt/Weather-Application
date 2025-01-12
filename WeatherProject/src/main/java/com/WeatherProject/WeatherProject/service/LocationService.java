package com.WeatherProject.WeatherProject.service;

import com.WeatherProject.WeatherProject.location.Coordinates;
import com.WeatherProject.WeatherProject.location.Location;

public interface LocationService {
    public Coordinates getCoordinates(Location location);
}
