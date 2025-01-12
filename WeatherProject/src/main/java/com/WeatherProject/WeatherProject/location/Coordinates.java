package com.WeatherProject.WeatherProject.location;

import org.springframework.stereotype.Component;

@Component
public class Coordinates {
    private double lat;
    private double lon;

    public Coordinates() {

    }

    public Coordinates(double latitude, double longitude) {
        this.lat = latitude;
        this.lon = longitude;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(long latitude) {
        this.lat = latitude;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(long longitude) {
        this.lon = longitude;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "latitude=" + lat +
                ", longitude=" + lon +
                '}';
    }
}

