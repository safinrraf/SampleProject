package com.adex.demo.domain.api;

import com.adex.demo.domain.models.DomainCustomerRequest;

public interface CustomerRequestService {

  void processCustomerRequest(DomainCustomerRequest request);
}
