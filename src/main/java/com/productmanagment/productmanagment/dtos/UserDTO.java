package com.productmanagment.productmanagment.dtos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import java.util.Set;

public class UserDTO {

    @JsonProperty(value = "id")
    private  Long userId;
    @NotNull
    private String name;
    @NotNull
    private  String surnames;

    @JsonProperty(value = "products")
    private Set<ProductDTO> productDTOS;

    @JsonProperty(value = "userLogin")
    private Set<UserLoginDTO> userLoginDTOS;

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public Set<ProductDTO> getProductDTOS() {
        return productDTOS;
    }

    public Set<UserLoginDTO> getUserLoginDTOS() {
        return userLoginDTOS;
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

    public void setProductDTOS(Set<ProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }

    public void setUserLoginDTOS(Set<UserLoginDTO> userLoginDTOS) {
        this.userLoginDTOS = userLoginDTOS;
    }
}
