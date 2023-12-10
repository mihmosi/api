package com.example.api.responce;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResApiExceptionHandler {
    @ExceptionHandler(value = {RestApiException.class})
    public ResponseEntity<Object> handleException(Exception e){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(e.getMessage(), status);
    }
}
