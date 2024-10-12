package org.rgs.demo.ignite.springdata.model;

import lombok.Data;

@Data
public class CountryDTO {
    private String code;

    private String name;

    private String continent;

    private String region;

    private int population;

    public CountryDTO() {
    }

    public CountryDTO(String key, Country value) {
        this.code = key;
        this.name = value.getName();
        this.continent = value.getContinent();
        this.region = value.getRegion();
        this.population = value.getPopulation();
    }

}
