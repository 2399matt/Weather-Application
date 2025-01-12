package com.WeatherProject.WeatherProject.config;

import com.WeatherProject.WeatherProject.location.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OpenConfig {
    @Value("${openweatherurl}")
    private String openweatherurl;
    @Value("${openweatherkey}")
    private String openweatherkey;

    public OpenConfig() {

    }


    public WebClient.Builder webClientBuilder(Location location) {
        return WebClient.builder().baseUrl(openweatherurl + location.getZipCode() + "," + location.getCountryCode() + "&appid=" + openweatherkey);
    }
}
