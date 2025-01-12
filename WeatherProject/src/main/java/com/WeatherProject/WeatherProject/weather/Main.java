package com.WeatherProject.WeatherProject.weather;

import org.springframework.stereotype.Component;

@Component
public class Main {
    private String temp;
    private String humidity;

    public Main() {

    }

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
