package com.WeatherProject.WeatherProject.location;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class Location {

    @NotNull(message = "is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 digits/characters.")
    private String zipCode;

    @NotNull(message = "is required")
    @Size(min = 2, message = "Country code must be two characters. (e.g. US)")
    @Size(max = 2, message = "Country code must be two characters. (e.g. US)")
    private String countryCode;

    public Location() {

    }

    public Location(String zipCode, String countryCode) {
        this.zipCode = zipCode;
        this.countryCode = countryCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Location{" +
                "zipCode='" + zipCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
