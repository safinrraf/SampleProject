package com.adex.demo.domain.exceptions;

public class CustomerNotFoundException extends AdexException {

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
