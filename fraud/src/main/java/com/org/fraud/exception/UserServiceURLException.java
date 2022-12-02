package com.org.fraud.exception;

public class UserServiceURLException  extends RuntimeException{
    private final String errorCode;

    public UserServiceURLException(String errorMessage,  String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }
}
