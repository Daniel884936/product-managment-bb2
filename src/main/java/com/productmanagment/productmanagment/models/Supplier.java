package com.productmanagment.productmanagment.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "supplier")
public class Supplier implements Serializable {

    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private  Long supplierId;
    @NotNull
    private  String name;

    @ManyToMany(mappedBy = "suppliers",fetch = FetchType.EAGER)
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

    public void addProduct(Product product){
        if(products == null){
            products = new HashSet<>();
        }
        if(product.getSuppliers() == null){
            product.setSuppliers(new ArrayList<>());
        }
        product.getSuppliers().add(this);
        products.add(product);
    }
}
