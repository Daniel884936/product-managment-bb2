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
    private String passWord;
    @NotNull
    private String userName;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public Long getUserLoginId() {
        return userLoginId;
    }

    @JsonIgnore
    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    @JsonIgnore
    public void setUserLoginId(Long userLoginId) {
        this.userLoginId = userLoginId;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
