package org.rgs.demo.ignite.springdata.dao;

import java.util.List;
import javax.cache.Cache;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.Query;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.rgs.demo.ignite.springdata.model.City;
import org.rgs.demo.ignite.springdata.model.CityKey;
import org.springframework.stereotype.Repository;

@RepositoryConfig(cacheName = "City")
@Repository
public interface CityRepository extends IgniteRepository<City, CityKey> {

    public List<Cache.Entry<CityKey, City>> findAllByPopulationGreaterThanEqualOrderByPopulation(int population);

    @Query("SELECT city.name, MAX(city.population), country.name, country.GovernmentForm FROM country " +
            "JOIN city ON city.countrycode = country.code " +
            "GROUP BY city.name, country.name, country.GovernmentForm, city.population " +
            "ORDER BY city.population DESC LIMIT ?")
    public List<List<?>> findMostPopulatedCities(int limit);

    public Cache.Entry<CityKey, City> findById(int id);
}