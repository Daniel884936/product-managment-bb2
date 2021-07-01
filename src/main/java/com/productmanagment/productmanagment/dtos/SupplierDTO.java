package com.productmanagment.productmanagment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import java.util.Set;

public class SupplierDTO {

    @JsonProperty(value = "id")
    private  Long supplierId;

    @NotNull
    private  String name;

    private Set<ProductDTO> products;

    @NotNull
    @JsonProperty(value = "country")
    private CountryDTO country;

    public Long getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public Set<ProductDTO> getProducts() {
        return products;
    }

    public CountryDTO getCountry() {
        return country;
    }

    @JsonIgnore
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setName( String name) {
        this.name = name;
    }

    public void setProducts(Set<ProductDTO> products) {
        this.products = products;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }
}
