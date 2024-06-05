package com.adex.demo.domain.impl;

import com.adex.demo.domain.api.CustomerStatsManager;
import com.adex.demo.domain.models.DomainCustomerRequest;
import com.adex.demo.domain.models.CustomerRequestsQueue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ValidCustomerRequestStrategy implements CustomerStatsManager {

    @Override
    public void countCustomerRequest(DomainCustomerRequest request) {
        CustomerRequestsQueue.put(request);
    }
}
