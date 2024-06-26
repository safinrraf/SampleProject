package com.adex.demo.domain.api;

import com.adex.demo.domain.models.DomainCustomerRequest;

/**
 * Each implementation of that class defines specific behaviour (strategy) to manage customer's
 * statistics.
 */
public interface CustomersRequestManager {

  /**
   * Sends requests to the queue.
   *
   * @param request instance of {@code DomainCustomerRequest}
   */
  void sendToQueue(DomainCustomerRequest request);
}
