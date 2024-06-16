package com.adex.demo.rest.api.impl;

import com.adex.demo.domain.api.CustomerRequestService;
import com.adex.demo.domain.models.DomainCustomerRequest;
import com.adex.demo.rest.api.CustomerRequestApi;
import com.adex.demo.rest.models.CustomerRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerRequestController implements CustomerRequestApi {

  private final CustomerRequestService service;

  @Override
  public org.springframework.http.ResponseEntity<Void> processCustomerRequest(
      CustomerRequest customerRequest) {
    // here should be a mapper by org.mapstruct
    service.processCustomerRequest(
        new DomainCustomerRequest(
            customerRequest.getCustomerID(),
            customerRequest.getTagID(),
            customerRequest.getUserID(),
            customerRequest.getRemoteIP(),
            customerRequest.getTimestamp(),
            customerRequest.toString(),
            null));
    return ResponseEntity.accepted().build();
  }
}
