package com.WeatherProject.WeatherProject.config;

import com.WeatherProject.WeatherProject.location.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OpenConfig {
    /**
     * Values configured inside the properties file for the API call.
     */
    @Value("${openweatherurl}")
    private String openweatherurl;
    @Value("${openweatherkey}")
    private String openweatherkey;

    public OpenConfig() {

    }

    /**
     * WebClient Builder used to build the URL for the geolocation API call using the location info from user.
     *
     * @param location The location of the user.
     * @return the ready-to-build webclient.
     */
    public WebClient.Builder webClientBuilder(Location location) {
        return WebClient.builder().baseUrl(openweatherurl + location.getZipCode() + "," + location.getCountryCode() + "&appid=" + openweatherkey);
    }
}
