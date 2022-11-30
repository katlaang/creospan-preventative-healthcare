package com.health.preventivehealth.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ServiceProviderNotFoundException extends RuntimeException{
    public ServiceProviderNotFoundException(String message){
        super(message);
    }
}
