package com.WeatherProject.WeatherProject.service;

import com.WeatherProject.WeatherProject.location.Coordinates;
import com.WeatherProject.WeatherProject.weather.WeatherReport;

public interface WeatherService {
    public WeatherReport getWeatherReport(Coordinates coordinates);
}
