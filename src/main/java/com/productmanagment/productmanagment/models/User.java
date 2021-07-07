package com.productmanagment.productmanagment.models;

import com.productmanagment.productmanagment.dtos.ProductDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "user")
public class User implements Serializable {

    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private  Long userId;

    @NotNull
    private String name;

    @NotNull
    private  String surnames;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Product> products;

    /*@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)*/
    @OneToOne(mappedBy = "user", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private UserLogin userLogin;

    public void setUserLogin(UserLogin userLogin) {
        userLogin.setUser(this);
        this.userLogin = userLogin;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        if(products == null){
            products= new HashSet<>();
        }
        product.setCreator(this);
        products.add(product);
    }
}
