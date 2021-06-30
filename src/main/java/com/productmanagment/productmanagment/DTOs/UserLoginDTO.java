package com.productmanagment.productmanagment.DTOs;

import com.productmanagment.productmanagment.models.Rol;
import com.sun.istack.NotNull;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserLoginDTO {

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

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

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
