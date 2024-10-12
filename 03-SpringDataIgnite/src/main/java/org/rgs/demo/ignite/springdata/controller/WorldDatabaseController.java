package org.rgs.demo.ignite.springdata.controller;


import org.rgs.demo.ignite.springdata.model.CityDTO;
import org.rgs.demo.ignite.springdata.model.CountryDTO;
import org.rgs.demo.ignite.springdata.service.WorldDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorldDatabaseController {
    @Autowired
    WorldDatabaseService service;

    @GetMapping("/api/countries")
    public List<CountryDTO> getCountriesByPopulation(@RequestParam(value = "population", required = true) int population) {
        return service.getCountriesByPopulation(population);
    }

    @GetMapping("/api/cities")
    public List<CityDTO> getCitiesByPopulation(@RequestParam(value = "population", required = true) int population) {
        return service.getCitiesByPopulation(population);
    }

    @GetMapping("/api/cities/mostPopulated")
    public List<List<?>> getMostPopulatedCities(@RequestParam(value = "limit", required = false) Integer limit) {
        return service.getMostPopulatedCities(limit);
    }

    @PutMapping("/api/cities/{id}")
    public CityDTO updateCityPopulation(@PathVariable Integer id, @RequestBody CityDTO cityDTO) {
        return service.updateCityPopulation(id, cityDTO.getPopulation());
    }

}