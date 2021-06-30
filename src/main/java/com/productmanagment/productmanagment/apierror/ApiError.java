package com.productmanagment.productmanagment.apierror;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;


public class ApiError {

    private HttpStatus httpStatus;
    private String debugMessage;
    private String message;
    private LocalDateTime timestamp;
    private List<String> details;

    private ApiError() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus httpStatus){
        this();
        httpStatus = httpStatus;
    }

    public  ApiError(HttpStatus httpStatus, Throwable ex){
        this();
        this.httpStatus = httpStatus;
        this.message  = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

     public ApiError(HttpStatus httpStatus, String message,Throwable debugMessage){
        this();
        this.httpStatus = httpStatus;
        this.message  = message;
        this.debugMessage = debugMessage.getLocalizedMessage();
    }


}
