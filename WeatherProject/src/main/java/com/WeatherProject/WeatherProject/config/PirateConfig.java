package com.WeatherProject.WeatherProject.config;

import com.WeatherProject.WeatherProject.location.Coordinates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class PirateConfig {
    @Value("${pirateURL}")
    private String pirateURL;
    @Value("${openweatherkey}")
    private String key;

    public PirateConfig() {
    }


    public WebClient.Builder webClientBuilder(Coordinates coordinates) {
        System.out.println(pirateURL + coordinates.getLat() + "&lon=" + coordinates.getLon() + "&units=imperial&appid=" + key);
        return WebClient.builder().baseUrl(pirateURL + coordinates.getLat() + "&lon=" + coordinates.getLon() + "&units=imperial&appid=" + key);

    }
}
