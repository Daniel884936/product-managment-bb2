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

    ApiError(HttpStatus httpStatus){
        this();
        httpStatus = httpStatus;
    }

    ApiError(HttpStatus httpStatus, Throwable ex){
        this();
        this.httpStatus = httpStatus;
        this.message  = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    ApiError(HttpStatus httpStatus, String message,Throwable ex){
        this();
        this.httpStatus = httpStatus;
        this.message  = message;
        this.debugMessage = ex.getLocalizedMessage();
    }


}
