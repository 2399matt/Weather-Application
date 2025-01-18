package com.WeatherProject.WeatherProject.config;

import com.WeatherProject.WeatherProject.location.Coordinates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class PirateConfig {
    /**
     * Values configured inside the properties file for the API call.
     */
    @Value("${pirateURL}")
    private String pirateURL;
    @Value("${openweatherkey}")
    private String key;

    public PirateConfig() {
    }

    /**
     * WebClient Builder used to build the URL for the weather-API call using the coordinates from the geolocation API.
     *
     * @param coordinates The coordinates retrieved from the geo API using the user's location.
     * @return The ready-to-build Web Client used to retrieve the local weather information.
     */
    public WebClient.Builder webClientBuilder(Coordinates coordinates) {
        System.out.println(pirateURL + coordinates.getLat() + "&lon=" + coordinates.getLon() + "&units=imperial&appid=" + key);
        return WebClient.builder().baseUrl(pirateURL + coordinates.getLat() + "&lon=" + coordinates.getLon() + "&units=imperial&appid=" + key);

    }
}
