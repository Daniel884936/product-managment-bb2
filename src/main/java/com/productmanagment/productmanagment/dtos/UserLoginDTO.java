package com.productmanagment.productmanagment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.productmanagment.productmanagment.models.Rol;
import com.sun.istack.NotNull;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserLoginDTO {

    @JsonProperty(value = "id")
    private  Long userLoginId;
    @NotNull
    private String password;
    @NotNull
    private String userName;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public Long getUserLoginId() {
        return userLoginId;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    @JsonIgnore
    public void setUserLoginId(Long userLoginId) {
        this.userLoginId = userLoginId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
