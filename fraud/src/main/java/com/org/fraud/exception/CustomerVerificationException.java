package com.org.fraud.exception;

public class CustomerVerificationException
        extends RuntimeException{

private final Integer errorCode;

public CustomerVerificationException(String errorMessage, Integer errorCode) {
    super(errorMessage);
    this.errorCode = errorCode;
}

public CustomerVerificationException(Throwable cause, String errorMessage, Integer errorCode) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
    }

}
