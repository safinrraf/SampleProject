package com.adex.demo.errorhandling;

import com.adex.demo.domain.exceptions.AdexException;
import com.adex.demo.domain.exceptions.CustomerDisabledException;
import com.adex.demo.domain.exceptions.CustomerNotFoundException;
import com.adex.demo.domain.exceptions.CustomerRequestValidationException;
import com.adex.demo.domain.exceptions.IpStopListException;
import com.adex.demo.rest.models.AdexErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
  @ExceptionHandler({CustomerNotFoundException.class})
  public ResponseEntity<AdexErrorResponse> handleCustomerNotFoundException(
      CustomerNotFoundException e) {
    final var errorResponse = new AdexErrorResponse();
    errorResponse.setCode(404);
    errorResponse.setMessage(e.getMessage());
    return handleErrorException(e, errorResponse);
  }

  @ExceptionHandler({CustomerDisabledException.class})
  public ResponseEntity<AdexErrorResponse> handleCustomerDisabledException(
      CustomerDisabledException e) {
    final var errorResponse = new AdexErrorResponse();
    errorResponse.setCode(401);
    errorResponse.setMessage(e.getMessage());
    return handleErrorException(e, errorResponse);
  }

  @ExceptionHandler({CustomerRequestValidationException.class})
  public ResponseEntity<AdexErrorResponse> handleCustomerRequestValidationException(
      CustomerRequestValidationException e) {
    final var errorResponse = new AdexErrorResponse();
    errorResponse.setCode(400);
    errorResponse.setMessage(e.getMessage());
    return handleErrorException(e, errorResponse);
  }

  @ExceptionHandler({IpStopListException.class})
  public ResponseEntity<AdexErrorResponse> handleIpStopListException(IpStopListException e) {
    final var errorResponse = new AdexErrorResponse();
    errorResponse.setCode(403);
    errorResponse.setMessage(e.getMessage());
    return handleErrorException(e, errorResponse);
  }

  private ResponseEntity<AdexErrorResponse> handleErrorException(
      AdexException ae, AdexErrorResponse errorResponse) {
    final var httpStatusCode =
        switch (errorResponse.getCode()) {
          case 400, 401 -> HttpStatus.BAD_REQUEST;
          case 403 -> HttpStatus.FORBIDDEN;
          case 404 -> HttpStatus.NOT_FOUND;
          default -> HttpStatus.INTERNAL_SERVER_ERROR;
        };

    return new ResponseEntity<>(errorResponse, httpStatusCode);
  }
}
