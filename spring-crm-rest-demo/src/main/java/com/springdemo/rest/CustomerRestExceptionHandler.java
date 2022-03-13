package com.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

//add @ExceptionHandler for customer not found exception
@ExceptionHandler
        public ResponseEntity<CustomerErrorResponse>handleException(CustomerNotFoundException exception) {

    CustomerErrorResponse error = new CustomerErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            exception.getMessage(),
            System.currentTimeMillis()
    );
//    return response entity
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}
//    add another @ExceptionHandler to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse>handleException(Exception exception) {
    CustomerErrorResponse error = new CustomerErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            "Invalid entry(-ies) for customers Id",
            System.currentTimeMillis()
    );
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
