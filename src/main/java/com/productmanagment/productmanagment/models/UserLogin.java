package com.productmanagment.productmanagment.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Table(name = "user_login")
public class UserLogin {

    @Id
    @GeneratedValue
    @Column(name = "user_login_id")
    private  Long userLoginId;
    @NotNull
    private String passWord;
    @NotNull
    @Column(unique = true)
    private String userName;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
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

    public void setPassWord( String passWord) {
        this.passWord = passWord;
    }

    public void setUserName( String userName) {
        this.userName = userName;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserLoginId() {
        return userLoginId;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public User getUser() {
        return user;
    }
}
