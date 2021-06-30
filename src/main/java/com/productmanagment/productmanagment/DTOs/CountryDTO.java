package com.productmanagment.productmanagment.DTOs;

import com.sun.istack.NotNull;

import javax.persistence.*;

public class CountryDTO {

    @Id
    private  Long countryId;
    @NotNull
    private String name;

    public Long getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public void setName(String name) {
        this.name = name;
    }

}
