package com.example.Internship.Controller;

import com.example.Internship.Entity.City;
import com.example.Internship.Entity.Neighborhood;
import com.example.Internship.Entity.Town;
import com.example.Internship.Service.CityService;
import com.example.Internship.Service.NeighborhoodService;
import com.example.Internship.Service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    private CityService cityService;

    @Autowired
    private TownService townService;

    @Autowired
    private NeighborhoodService neighborhoodService;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/towns/{cityId}")
    public List<Town> getTownsByCity(@PathVariable Long cityId) {
        return townService.getTownsByCity(cityId);
    }

    @GetMapping("/neighborhoods/{townId}")
    public List<Neighborhood> getNeighborhoodsByTown(@PathVariable Long townId) {
        return neighborhoodService.getNeighborhoodsByTown(townId);
    }

//    @GetMapping("/lands/")
}