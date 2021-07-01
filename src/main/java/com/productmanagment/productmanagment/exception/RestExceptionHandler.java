package com.productmanagment.productmanagment.exception;

import com.productmanagment.productmanagment.apierror.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


//TODO to throw exs

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

   /* @ExceptionHandler(Exception.class)
    public  ResponseEntity<ApiError>handleAllException(Exception ex, WebRequest webRequest){
        ApiError apiExceptionResponse = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex);
        return  new ResponseEntity<ApiError>(apiExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequestException(Exception ex, WebRequest webRequest) {
        ApiError apiExceptionResponse = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        return  new ResponseEntity<ApiError>(apiExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ApiError> handleConflictException(Exception ex, WebRequest webRequest) {
        ApiError apiExceptionResponse = new ApiError(HttpStatus.CONFLICT, ex.getMessage(), ex);
        return  new ResponseEntity<ApiError>(apiExceptionResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(Exception ex, WebRequest webRequest) {
        ApiError apiExceptionResponse = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        return  new ResponseEntity<ApiError>(apiExceptionResponse, HttpStatus.NOT_FOUND);
    }

    //TODO this way  is most declarative
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handleBusinessException(Exception ex, WebRequest webRequest) {
        ApiError apiExceptionResponse = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        return  new ResponseEntity<ApiError>(apiExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
