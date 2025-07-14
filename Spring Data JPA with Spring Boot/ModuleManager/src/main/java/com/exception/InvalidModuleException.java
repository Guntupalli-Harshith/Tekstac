package com.exception;

public class InvalidModuleException extends Exception {
    
    public InvalidModuleException() {
        super();
    }
    
    public InvalidModuleException(String message) {
        super(message);
    }
}