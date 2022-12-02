package com.org.fraud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(CustomerVerificationException.class)
    public ResponseEntity<Object> handleConflict(CustomerVerificationException customerNotValidException) {
        Map<String, String> errorInfo = new LinkedHashMap<>();
        errorInfo.put("timestamp", LocalDateTime.now().toString());
        errorInfo.put("message", customerNotValidException.getMessage());
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }
}
