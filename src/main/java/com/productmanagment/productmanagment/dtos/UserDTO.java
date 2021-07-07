package com.productmanagment.productmanagment.dtos;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.productmanagment.productmanagment.models.Rol;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private  Long userId;

    @Length(min = 2,max = 40)
    @NotNull
    private String name;

    @NotNull
    @Length(min = 2,max = 40)
    private  String surnames;

    @NotNull
    @Length(min = 2,max = 30)
    private String username;

    @NotNull
    @Length(min = 2,max = 30)
    private String password;

    @NotNull
    private Rol userRole;

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Rol getUserRole() {
        return userRole;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserRole(Rol userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
