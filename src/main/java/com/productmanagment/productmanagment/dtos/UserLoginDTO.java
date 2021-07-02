package com.productmanagment.productmanagment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.productmanagment.productmanagment.models.Rol;
import org.hibernate.validator.constraints.Length;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

public class UserLoginDTO {

    private  Long userLoginId;

    @Length(min = 2,max = 60)
    @NotNull
    private String password;

    @Length(min = 2,max = 60)
    @NotNull
    private String userName;

    @NotNull
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
