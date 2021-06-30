package com.productmanagment.productmanagment.exception;

import com.productmanagment.productmanagment.apierror.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


//TODO to throw exs

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleHttpMessageNotReadable(ex, headers, status, request);
    }


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequestException(BadRequestException ex) {
        return getResponseEntity(ex,"");
    }

    private ResponseEntity<ApiError> getResponseEntity(RuntimeException ex, String detail){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if(ex.getClass().isAnnotationPresent(ResponseStatus.class)){
            status = ex.getClass().getAnnotation(ResponseStatus.class).value();
        }
        ApiError apiError = new ApiError(
                status,
                ex.getMessage(),
                ex.getCause()
        );
        return new ResponseEntity<>(apiError,status);
    }

}
