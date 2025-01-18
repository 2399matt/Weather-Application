package com.WeatherProject.WeatherProject.weather;

import org.springframework.stereotype.Component;

@Component
public class Weather {
    private String description;

    public Weather() {

    }

    /**
     * Weather class used to retrieve info from the JSON sent by the weather-API.
     *
     * @param description Short summary of the user's local weather.
     */
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
