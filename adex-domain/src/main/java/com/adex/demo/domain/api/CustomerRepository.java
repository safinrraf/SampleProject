package com.adex.demo.domain.api;

import com.adex.demo.domain.exceptions.CustomerNotFoundException;
import com.adex.demo.domain.models.DomainCustomerRequest;

public interface CustomerRepository {

  /**
   * Gets user's status. 1 - active 0 - disabled.
   *
   * @param customerRequest сustomerRequest.
   * @return User's status.
   * @throws CustomerNotFoundException if user not found.
   */
  Integer getCustomerStatus(DomainCustomerRequest customerRequest) throws CustomerNotFoundException;

  /**
   * Saves a Customer's request.
   *
   * @param customerRequest request.
   */
  void saveCustomerRequest(DomainCustomerRequest customerRequest);
}
