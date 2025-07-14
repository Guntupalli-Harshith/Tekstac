package com.exception;

public class InvalidMembershipException extends Exception {
    
    public InvalidMembershipException() {
        super();
    }
    
    public InvalidMembershipException(String message) {
        super(message);
    }
}