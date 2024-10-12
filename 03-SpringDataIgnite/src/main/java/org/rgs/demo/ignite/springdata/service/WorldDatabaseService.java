package org.rgs.demo.ignite.springdata.service;

import org.rgs.demo.ignite.springdata.model.CityDTO;
import org.rgs.demo.ignite.springdata.model.CountryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WorldDatabaseService {

    public List<CountryDTO> getCountriesByPopulation(int population);

    public List<CityDTO> getCitiesByPopulation(int population);

    public List<List<?>> getMostPopulatedCities(Integer limit);

    public CityDTO updateCityPopulation(int cityId, int population);

}