package com.health.preventivehealth.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProviderNotFoundException extends RuntimeException{
    public ProviderNotFoundException(String message){
        super(message);
    }
}
