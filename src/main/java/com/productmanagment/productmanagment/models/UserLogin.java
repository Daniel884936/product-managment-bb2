package com.productmanagment.productmanagment.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "user_login")
public class UserLogin {

    @Id
    @GeneratedValue
    @Column(name = "user_login_id")
    private  Long userLoginId;

    @NotNull
    private String password;

    @NotNull
    @Column(unique = true)
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "user_id")
    private  User user;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Rol rol;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setUserLoginId(Long userLoginId) {
        this.userLoginId = userLoginId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserLoginId() {
        return userLoginId;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public User getUser() {
        return user;
    }
}
