package com.adex.demo.domain.impl;

import com.adex.demo.domain.api.CustomersRequestManager;
import com.adex.demo.domain.models.CustomerRequestsQueue;
import com.adex.demo.domain.models.DomainCustomerRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvalidCustomerRequestStrategyImpl implements CustomersRequestManager {

  @Override
  public void sendToQueue(DomainCustomerRequest request) {
    CustomerRequestsQueue.putInvalidRequest(request);
  }
}
