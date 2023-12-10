package com.example.api.responce;

public class RestApiException extends RuntimeException{
    public RestApiException(String message) {
        super(message);
    }
}
