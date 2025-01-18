package com.WeatherProject.WeatherProject.controller;

import com.WeatherProject.WeatherProject.location.Coordinates;
import com.WeatherProject.WeatherProject.location.Location;
import com.WeatherProject.WeatherProject.service.LocationService;
import com.WeatherProject.WeatherProject.service.WeatherService;
import com.WeatherProject.WeatherProject.weather.WeatherReport;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WeatherController {
    private final LocationService locationService;
    private final WeatherService weatherService;

    /**
     * Autowired constructor used to inject our service objects.
     *
     * @param locationService Object used to build the location object needed for coordinates.
     * @param weatherService  Object used to build the weather-report for the user.
     */
    @Autowired
    public WeatherController(LocationService locationService, WeatherService weatherService) {
        this.locationService = locationService;
        this.weatherService = weatherService;
    }

    /**
     * Method to display the location form to the user when a request hits the /locationForm endpoint.
     *
     * @param model model used by the controller to send an empty location object to the webpage.
     * @return the location form to retrieve the user's location data.
     */
    @GetMapping("/LocationForm")
    public String showLocationForm(Model model) {
        model.addAttribute("location", new Location());
        return "location-form";
    }

    /**
     * Method to build the coordinates and weather report to display info to the user on /showWeather
     *
     * @param location The location of the user, build with the locationService class.
     * @param BR       BindingResult used to check the validation on the user's input. (Need ZIP/COUNTRYCODE)
     * @param model    Model used to add the weather information to the webpage.
     * @return the weather report page to display the user's local weather information.
     */
    @PostMapping("/showWeather")
    public String showWeather(@Valid @ModelAttribute("location") Location location, BindingResult BR, Model model) {
        if (BR.hasErrors()) {
            return "location-form";
        } else {
            Coordinates coords = locationService.getCoordinates(location);
            WeatherReport weatherReport = weatherService.getWeatherReport(coords);
            model.addAttribute("temperature", weatherReport.getMain().getTemp());
            model.addAttribute("humidity", weatherReport.getMain().getHumidity());
            model.addAttribute("summary", weatherReport.getWeather().get(0).getDescription());
            return "weather";
        }
    }
}
