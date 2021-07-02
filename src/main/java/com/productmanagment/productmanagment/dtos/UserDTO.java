package com.productmanagment.productmanagment.dtos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class UserDTO {

    private  Long userId;

    @Length(min = 2,max = 60)
    @NotNull
    private String name;

    @NotNull
    @Length(min = 2,max = 60)
    private  String surnames;

    @JsonProperty(value = "products")
    private Set<ProductDTO> products;

    @JsonProperty(value = "userLogin")
    private Set<UserLoginDTO> userLogins;

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public Set<ProductDTO> getProducts() {
        return products;
    }

    public Set<UserLoginDTO> getUserLogins() {
        return userLogins;
    }

    @JsonIgnore
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurnames( String surnames) {
        this.surnames = surnames;
    }

    public void setProducts(Set<ProductDTO> products) {
        this.products = products;
    }

    public void setUserLogins(Set<UserLoginDTO> userLogins) {
        this.userLogins = userLogins;
    }
}
