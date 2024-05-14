package com.adex.demo.domain.api;

import com.adex.demo.domain.models.DomainCustomerRequest;

/**
 * Each implementation of that class defines specific behaviour (strategy)
 * to manage customer's statistics.
 */
public interface CustomerStatsManager {

    /**
     * Counts requests.
     * @param request instance of {@code DomainCustomerRequest}
     */
    void countCustomerRequest(DomainCustomerRequest request);
}
