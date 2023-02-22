package com.microservicedemo.user.service.exceptions;


import com.microservicedemo.user.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//It handles the global exception
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        String massage=ex.getMessage();
        ApiResponse response=ApiResponse.builder().massage(massage).success(true).build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
