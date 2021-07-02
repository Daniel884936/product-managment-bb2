package com.productmanagment.productmanagment.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "country")
public class Country {

    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private  Long countryId;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Supplier> suppliers;

    public Long getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
