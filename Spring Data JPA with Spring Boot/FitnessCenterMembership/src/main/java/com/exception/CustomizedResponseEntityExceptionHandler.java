package com.exception;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            LocalDate.now(), 
            ex.getMessage(),
            request.getDescription(false), 
            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidMembershipException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(
            InvalidMembershipException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            LocalDate.now(), 
            ex.getMessage(),
            request.getDescription(false), 
            HttpStatus.NOT_FOUND.getReasonPhrase()
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers, 
            HttpStatusCode status, 
            WebRequest request) {
        
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }
        
        String errorMessage = String.join(", ", errors);
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            LocalDate.now(), 
            errorMessage,
            request.getDescription(false), 
            HttpStatus.BAD_REQUEST.getReasonPhrase()
        );
        
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}