package com.productmanagment.productmanagment.DTOs;

import com.sun.istack.NotNull;
import java.util.Set;

public class SupplierDTO {

    private  Long supplierId;
    @NotNull
    private  String name;

    private Set<ProductDTO> productDTOS;
    @NotNull
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
