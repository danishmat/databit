package com.org.customer.exception;

public class CustomerNotValidException
        extends RuntimeException{

    private final Integer errorCode;

    public CustomerNotValidException(String errorMessage,  Integer errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public CustomerNotValidException(Throwable cause, String errorMessage,  Integer errorCode) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
    }

}