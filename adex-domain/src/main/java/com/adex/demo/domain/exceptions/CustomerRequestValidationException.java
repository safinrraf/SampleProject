package com.adex.demo.domain.exceptions;

public final class CustomerRequestValidationException extends AdexException {

  public CustomerRequestValidationException(String errorMessage) {
    super(errorMessage);
  }
}
