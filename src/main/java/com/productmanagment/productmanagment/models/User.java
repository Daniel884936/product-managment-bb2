package com.productmanagment.productmanagment.models;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Set;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private  Long userId;

    @NotNull
    private String name;

    @NotNull
    private  String surnames;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Product> products;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<UserLogin> userLogins;

    public Set<UserLogin> getUserLogins() {
        return userLogins;
    }

    public void setUserLogins(Set<UserLogin> userLogins) {
        this.userLogins = userLogins;
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
}
