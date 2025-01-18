package com.WeatherProject.WeatherProject.weather;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class WeatherReport {
    private String timezone;
    private List<Weather> weather;
    private Main main;

    public WeatherReport() {

    }

    /**
     * WeatherReport class is used to bundle all the weather information into one object.
     *
     * @param timezone User's timezone information.
     * @param weather  Weather object used to retrieve the summary of the weather.
     * @param main     Main object used to retrieve the temp/humidity of the weather.
     */
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
