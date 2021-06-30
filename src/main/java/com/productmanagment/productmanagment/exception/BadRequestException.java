package com.productmanagment.productmanagment.exception;

public class BadRequestException extends RuntimeException {
    private String details;

    public BadRequestException(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

}
