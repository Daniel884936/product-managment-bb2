package com.productmanagment.productmanagment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.productmanagment.productmanagment.models.Supplier;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

public class CountryDTO {

    @JsonProperty(value = "id")
    private  Long countryId;
    @NotNull
    private String name;

    private List<SupplierDTO> suppliers;

    public List<SupplierDTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierDTO> suppliers) {
        this.suppliers = suppliers;
    }

    public Long getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public void setName(String name) {
        this.name = name;
    }

}
