package com.productmanagment.productmanagment.utils;

import lombok.Data;

import java.util.Date;

@Data
public class ApiToken {
    private String userName;
    private String token;
    private Date expirationDate;
    private Date createdAt;

    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
