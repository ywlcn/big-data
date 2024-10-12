package org.rgs.demo.ignite.springdata.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Country {
    private String name;

    private String continent;

    private String region;

    private int population;

    private BigDecimal surfaceArea;

    private short indepYear;

    private BigDecimal lifeExpectancy;

    private BigDecimal gnp;

    private BigDecimal gnpOld;

    private String localName;

    private String governmentForm;

    private String headOfState;

    private int capital;

    private String code2;
}
