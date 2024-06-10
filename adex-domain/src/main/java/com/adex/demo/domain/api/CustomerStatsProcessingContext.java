package com.adex.demo.domain.api;

import com.adex.demo.domain.models.CustomersContext;
import com.adex.demo.domain.models.DomainCustomerRequest;

public interface CustomerStatsProcessingContext {

  /**
   * Defines the context in which Customer's request will be processed.
   *
   * @param request instance of {@code DomainCustomerRequest}
   * @return Customer's processing context.
   */
  CustomersContext getCustomersContext(DomainCustomerRequest request);
}
