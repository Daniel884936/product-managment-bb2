package com.productmanagment.productmanagment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CountryDTO {

    private  Long countryId;

    @NotNull
    @Length(max = 60)
    private String name;

    @JsonIgnore
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

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public void setName(String name) {
        this.name = name;
    }

}
