package com.productmanagment.productmanagment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.productmanagment.productmanagment.models.Rol;
import org.hibernate.validator.constraints.Length;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserLoginDTO   {

    @JsonIgnore
    private  Long userLoginId;

    @Length(min = 2,max = 60)
    @NotNull
    private String password;

    @Length(min = 2,max = 60)
    @NotNull
    private String username;


    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @JsonIgnore
    private UserDTO user;

    public Long getUserLoginId() {
        return userLoginId;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUserLoginId(Long userLoginId) {
        this.userLoginId = userLoginId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public Rol getRol() {
        return rol;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "userLoginId=" + userLoginId +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", rol=" + rol +
                ", user=" + user +
                '}';
    }
}
