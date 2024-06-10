package com.adex.demo.domain.exceptions;

public final class CustomerNotFoundException extends AdexException {

  public CustomerNotFoundException(String message) {
    super(message);
  }
}
