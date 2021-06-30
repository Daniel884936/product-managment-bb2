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

    private Set<ProductDTO> productDTOS;

    @NotNull
    @JsonProperty(value = "country")
    private CountryDTO  countryDTO;

    public Long getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public Set<ProductDTO> getProductDTOS() {
        return productDTOS;
    }

    public CountryDTO getCountryDTO() {
        return countryDTO;
    }

    @JsonIgnore
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setName( String name) {
        this.name = name;
    }

    public void setProductDTOS(Set<ProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }

    public void setCountryDTO( CountryDTO countryDTO) {
        this.countryDTO = countryDTO;
    }
}
