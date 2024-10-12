package org.rgs.demo.ignite.springdata.model;

import lombok.Data;

@Data
public class CityDTO {
    private int id;

    private String countryCode;

    private String name;

    private String district;

    private int population;

    public CityDTO() {
    }

    public CityDTO(CityKey key, City value) {
        this.id = key.getId();
        this.countryCode = key.getCountryCode();
        this.name = value.getName();
        this.district = value.getDistrict();
        this.population = value.getPopulation();
    }

}
