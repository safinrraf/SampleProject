package com.adex.demo.domain.api;

import com.adex.demo.domain.models.DomainCustomerRequest;

/** API for saving customer's requests. */
public interface RequestRepositoryService {

  /**
   * Saves a valid request.
   *
   * @param request instance of {@code DomainCustomerRequest}
   */
  void saveValidRequest(DomainCustomerRequest request);

  /**
   * Saves an information about the invalid request
   *
   * @param invalidRequest a instance of {@code DomainInvalidRequest}
   */
  void saveInvalidRequest(DomainCustomerRequest invalidRequest);
}
