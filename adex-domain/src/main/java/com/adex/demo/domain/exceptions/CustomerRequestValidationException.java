package com.adex.demo.domain.exceptions;

public class CustomerRequestValidationException extends AdexException {

    public CustomerRequestValidationException(String errorMessage) {
        super(errorMessage);
    }
}
