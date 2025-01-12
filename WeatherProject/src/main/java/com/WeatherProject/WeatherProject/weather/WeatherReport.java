package com.WeatherProject.WeatherProject.weather;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class WeatherReport {
    private String timezone;
    private List<Weather> weather;
    private Main main;

    public WeatherReport() {

    }

    @Autowired
    public WeatherReport(String timezone, List<Weather> weather, Main main) {
        this.timezone = timezone;
        this.weather = weather;
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }


    @Override
    public String toString() {
        return "WeatherReport{" +
                "timezone='" + timezone + '\'' +
                ", weather=" + weather +
                ", main=" + main +
                '}';
    }
}
