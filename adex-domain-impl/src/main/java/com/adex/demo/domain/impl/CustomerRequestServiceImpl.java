package com.adex.demo.domain.impl;

import com.adex.demo.domain.api.CustomerRequestProcessingContext;
import com.adex.demo.domain.api.CustomerRequestService;
import com.adex.demo.domain.models.DomainCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerRequestServiceImpl implements CustomerRequestService {

  private final CustomerRequestProcessingContext statsProcessingContext;

  @Override
  public void processCustomerRequest(DomainCustomerRequest request) {
    final var context = statsProcessingContext.getContext(request);
    final var statsManager = context.statsManager();

    if (context.adexException() == null) {
      statsManager.sendToQueue(request);
    } else {
      final var invalidRequest =
          DomainCustomerRequest.fromInvalidRequest(
              request.customerId(), request.toString(), context.adexException().toString());
      statsManager.sendToQueue(invalidRequest);
      throw context.adexException();
    }
  }
}
