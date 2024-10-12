package org.rgs.demo.ignite.springdata.service.impl;

import org.rgs.demo.ignite.springdata.dao.CityRepository;
import org.rgs.demo.ignite.springdata.dao.CountryRepository;
import org.rgs.demo.ignite.springdata.model.*;
import org.rgs.demo.ignite.springdata.service.WorldDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.cache.Cache;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorldDatabaseServiceImpl implements WorldDatabaseService {
    @Autowired
    CountryRepository countryDao;

    @Autowired
    CityRepository cityDao;

    public List<CountryDTO> getCountriesByPopulation(int population) {
        List<CountryDTO> countries = new ArrayList<>();

        for (Cache.Entry<String, Country> entry : countryDao.findByPopulationGreaterThanEqualOrderByPopulationDesc(population))
            countries.add(new CountryDTO(entry.getKey(), entry.getValue()));

        return countries;
    }

    public List<CityDTO> getCitiesByPopulation(int population) {
        List<CityDTO> cities = new ArrayList<>();

        for (Cache.Entry<CityKey, City> entry : cityDao.findAllByPopulationGreaterThanEqualOrderByPopulation(population))
            cities.add(new CityDTO(entry.getKey(), entry.getValue()));

        return cities;
    }

    public List<List<?>> getMostPopulatedCities(Integer limit) {
        return cityDao.findMostPopulatedCities(limit == null ? 5 : limit);
    }

    public CityDTO updateCityPopulation(int cityId, int population) {
        Cache.Entry<CityKey, City> entry = cityDao.findById(cityId);

        entry.getValue().setPopulation(population);

        cityDao.save(entry.getKey(), entry.getValue());

        return new CityDTO(entry.getKey(), entry.getValue());
    }
}