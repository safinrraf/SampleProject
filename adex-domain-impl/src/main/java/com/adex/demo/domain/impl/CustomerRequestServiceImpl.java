package com.adex.demo.domain.impl;

import com.adex.demo.domain.api.CustomerRequestService;
import com.adex.demo.domain.api.CustomerStatsProcessingContext;
import com.adex.demo.domain.models.DomainCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerRequestServiceImpl implements CustomerRequestService {

    private final CustomerStatsProcessingContext statsProcessingContext;

    @Override
    public void processCustomerRequest(DomainCustomerRequest request) {
        final var context = statsProcessingContext.getCustomersContext(request);
        final var statsManager = context.statsManager();
        statsManager.countCustomerRequest(request);
        if(context.adexException() != null) {
            throw context.adexException();
        }
    }
}
