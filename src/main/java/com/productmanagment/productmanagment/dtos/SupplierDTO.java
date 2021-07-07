package com.productmanagment.productmanagment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class SupplierDTO {

    private  Long supplierId;

    @NotNull
    @Length(min = 2,max = 60)
    private  String name;

    @JsonIgnore
    private Set<ProductDTO> products;

    @NotNull
    @JsonProperty(value = "countryId")
    private Long countryId;

    public Long getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public Set<ProductDTO> getProducts() {
        return products;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setName( String name) {
        this.name = name;
    }

    public void setProducts(Set<ProductDTO> products) {
        this.products = products;
    }

    public void setCountryId(Long country) {
        this.countryId = country;
    }

    public  void addProduct(ProductDTO productDTO){
        if(products == null){
            products = new HashSet<ProductDTO>();
        }
        productDTO.addSupplier(this);
        products.add(productDTO);
    }

    @Override
    public String toString() {
        return "SupplierDTO{" +
                "supplierId=" + supplierId +
                ", name='" + name + '\'' +
                ", products=" + products +
                ", countryId=" + countryId +
                '}';
    }
}
