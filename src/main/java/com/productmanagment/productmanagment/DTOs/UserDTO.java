package com.productmanagment.productmanagment.DTOs;
import com.sun.istack.NotNull;
import java.util.Set;

public class UserDTO {

    private  Long userId;
    @NotNull
    private String name;
    @NotNull
    private  String surnames;

    private Set<ProductDTO> productDTOS;

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
