package com.adex.demo.domain.exceptions;

public abstract class AdexException extends RuntimeException {

    protected AdexException(String message) {
        super(message);
    }
}
