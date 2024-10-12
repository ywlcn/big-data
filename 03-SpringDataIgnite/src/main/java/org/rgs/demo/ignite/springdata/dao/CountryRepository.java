package org.rgs.demo.ignite.springdata.dao;

import java.util.List;
import javax.cache.Cache;
//import org.apache.ignite.springdata22.repository.IgniteRepository;
//import org.apache.ignite.springdata22.repository.config.RepositoryConfig;
import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.rgs.demo.ignite.springdata.model.Country;
import org.springframework.stereotype.Repository;

@RepositoryConfig(cacheName = "Country")
@Repository
public interface CountryRepository extends IgniteRepository<Country, String> {

    public List<Cache.Entry<String,Country>> findByPopulationGreaterThanEqualOrderByPopulationDesc(int population);
}