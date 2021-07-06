package com.productmanagment.productmanagment.models;


public enum ProductState {
    DISCONTINUED(0,"Discontinued"),
    ACTIVE(1,"Active");

    private int valueAsInt;
    private String valueAsString;
    ProductState(int valueAsInt, String valueAsString) {
        this.valueAsInt = valueAsInt;
        this.valueAsString = valueAsString;
    }

    public int getValueAsInt() {
        return valueAsInt;
    }

    public String getValueAsString() {
        return valueAsString;
    }
}
