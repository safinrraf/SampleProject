package com.adex.demo.domain.api;

import com.adex.demo.domain.models.DomainCustomerRequest;

public interface CustomerRepository {

    /**
     * Gets user's status.
     * 1 - active
     * 0 - disabled.
     *
     * @param customerRequest сustomerRequest.
     * @return User's status.
     * @throws {@code AdexUserNotFound} if user not found.
     */
    Integer getCustomerStatus(DomainCustomerRequest customerRequest);
}
