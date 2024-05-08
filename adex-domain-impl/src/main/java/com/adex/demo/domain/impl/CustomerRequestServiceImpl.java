package com.adex.demo.domain.impl;

import com.adex.demo.domain.api.CustomerRequestService;
import com.adex.demo.domain.api.CustomerRequestValidationService;
import com.adex.demo.domain.models.DomainCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerRequestServiceImpl implements CustomerRequestService {

    private final CustomerRequestValidationService validationService;

    @Override
    public void processCustomerRequest(DomainCustomerRequest request) {
        validationService.validateRequest(request);
    }
}
