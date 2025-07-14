package com.exception;

//Write appropriate annotation
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
    @ResponseStatus(HttpStatus.NOT_FOUND)

	public class AssetInvalidException extends Exception {
	    
	    public AssetInvalidException(String message) {
		super(message);
	}
}
