package com.HSSS.Spring.security.SpringSecurity.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> basicException(Exception ex){
        return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
    }
}
