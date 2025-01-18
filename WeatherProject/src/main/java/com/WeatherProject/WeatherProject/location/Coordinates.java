package com.WeatherProject.WeatherProject.location;

import org.springframework.stereotype.Component;

@Component
public class Coordinates {
    private double lat;
    private double lon;

    public Coordinates() {

    }

    /**
     * Coordinates class used to allow Jackson to take in the latitude and longitude from the JSON file sent by the
     * geolocation API.
     *
     * @param latitude  latitude of the user's location.
     * @param longitude longitude of the user's location.
     */
    public Coordinates(double latitude, double longitude) {
        this.lat = latitude;
        this.lon = longitude;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double latitude) {
        this.lat = latitude;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double longitude) {
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

