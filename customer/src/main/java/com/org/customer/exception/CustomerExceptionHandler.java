package com.org.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomerExceptionHandler {
    @ExceptionHandler(CustomerNotValidException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage resourceNotFoundException(CustomerNotValidException customerNotValidException, WebRequest request) {
        ErrorMessage message = new ErrorMessage();
        message.setErrorMessage(customerNotValidException.getMessage());
        return message;
    }
}
