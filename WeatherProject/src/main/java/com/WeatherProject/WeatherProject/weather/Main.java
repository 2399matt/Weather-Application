package com.WeatherProject.WeatherProject.weather;

import org.springframework.stereotype.Component;

@Component
public class Main {
    private String temp;
    private String humidity;

    public Main() {

    }

    /**
     * Main class used to retrieve information from the JSON that is sent by the weather-API.
     *
     * @param temp     Temperature of the user's location.
     * @param humidity Humidity of the user's location.
     */
    public Main(String temp, String humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp='" + temp + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }
}
