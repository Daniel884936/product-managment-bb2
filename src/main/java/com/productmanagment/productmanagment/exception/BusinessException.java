package com.productmanagment.productmanagment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//TODO this way  is most declarative
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
