package com.productmanagment.productmanagment.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "country_id")
    private  Long countryId;
    @NonNull
    private String name;
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Supplier> suppliers;

    public Long getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
