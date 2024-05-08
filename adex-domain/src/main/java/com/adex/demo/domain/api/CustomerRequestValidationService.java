package com.adex.demo.domain.api;

import com.adex.demo.domain.models.DomainCustomerRequest;

public interface CustomerRequestValidationService {

    /**
     * Validates customers request.
     * Throws an exception.
     *
     * @param request instance of {@code DomainCustomerRequest}
     */
    void validateRequest(DomainCustomerRequest request);

}
