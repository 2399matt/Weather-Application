package com.WeatherProject.WeatherProject.weather;

import org.springframework.stereotype.Component;

@Component
public class Weather {
    private String description;

    public Weather() {

    }

    public Weather(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather{" +
                ", description='" + description + '\'' +
                '}';
    }
}
