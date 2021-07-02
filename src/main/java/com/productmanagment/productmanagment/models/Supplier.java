package com.productmanagment.productmanagment.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "supplier")
public class Supplier {

    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private  Long supplierId;
    @NotNull
    private  String name;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "supplier_product",
            joinColumns = { @JoinColumn(name = "supplier_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    private Set<Product> products;

    @NotNull
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
