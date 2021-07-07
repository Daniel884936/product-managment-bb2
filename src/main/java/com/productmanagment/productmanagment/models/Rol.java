package com.productmanagment.productmanagment.models;

public enum Rol {
    ADMIN(0,"Admin"),
    USER(1,"User");

    private String valueAsString;
    private Integer valueAsInt;

    Rol(int i, String strValue) {
        this.valueAsInt = i;
        this.valueAsString = strValue;
    }

   /* public String getValueAsString() {
        return valueAsString;
    }

    public Integer getValueAsInt() {
        return valueAsInt;
    }*/
}
