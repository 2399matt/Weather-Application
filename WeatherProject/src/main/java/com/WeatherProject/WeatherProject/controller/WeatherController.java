package com.WeatherProject.WeatherProject.controller;

import com.WeatherProject.WeatherProject.location.Coordinates;
import com.WeatherProject.WeatherProject.location.Location;
import com.WeatherProject.WeatherProject.service.LocationServiceImpl;
import com.WeatherProject.WeatherProject.service.WeatherServiceImpl;
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
    private final LocationServiceImpl locationService;
    private final WeatherServiceImpl weatherService;

    @Autowired
    public WeatherController(LocationServiceImpl locationService, WeatherServiceImpl weatherService) {
        this.locationService = locationService;
        this.weatherService = weatherService;
    }

    @GetMapping("/LocationForm")
    public String showLocationForm(Model model) {
        model.addAttribute("location", new Location());
        return "location-form";
    }

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
