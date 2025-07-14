package com.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(
	        LocalDate.now(),
	        ex.getMessage(),
	        request.getDescription(false),
	        "Internal Server Error");
		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AssetInvalidException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
		    LocalDate.now(),
	        ex.getMessage(),
	        request.getDescription(false),
	        "Not Found");
	    return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
			    List<String>validationErrors = new ArrayList<>();
			    for (FieldError error: ex.getBindingResult().getFieldErrors())
			    {
			        validationErrors.add(error.getDefaultMessage());
			    }
			    String errorMessage = String.join(",",validationErrors);
			ExceptionResponse exceptionResponse = new ExceptionResponse(
		    LocalDate.now(),
	        errorMessage,
	        request.getDescription(false),
	        "Bad Request");

		// Fill the code here
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
}
