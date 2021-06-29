package com.productmanagment.productmanagment.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Set;

@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue
    @Column(name = "supplier_id")
    private  Long supplierId;
    @NonNull
    private  String name;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "supplier_product",
            joinColumns = { @JoinColumn(name = "supplier_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    private Set<Product> products;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setName(String name) {
        this.name = name;
    }

}
