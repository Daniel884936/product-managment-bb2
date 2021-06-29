package com.productmanagment.productmanagment.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Table(name = "user_login")
public class UserLogin {

    @Id
    @GeneratedValue
    @Column(name = "user_login_id")
    private  Long userLoginId;
    @NonNull
    private String passWord;
    @NonNull
    @Column(unique = true)
    private String userName;
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private  User user;

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
