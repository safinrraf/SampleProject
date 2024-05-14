package com.adex.demo.domain.impl;

import com.adex.demo.domain.api.CustomerRepository;
import com.adex.demo.domain.api.CustomerStatsProcessingContext;
import com.adex.demo.domain.exceptions.CustomerDisabledException;
import com.adex.demo.domain.exceptions.CustomerRequestValidationException;
import com.adex.demo.domain.models.CustomersContext;
import com.adex.demo.domain.models.DomainCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class CustomerStatsProcessingContextImpl implements CustomerStatsProcessingContext {

    private final CustomerRepository repository;

    public static boolean isValidIPv4(String ip) {
        final var pattern = "^((25[0-5]|(2[0-4]|1\\d|[1-9])?[0-9])\\.){3}(25[0-5]|(2[0-4]|1\\d|[1-9])?[0-9])$";
        final var r = Pattern.compile(pattern);
        final var m = r.matcher(ip);
        return m.matches();
    }

    public static boolean isValidString(String str) {
        final var pattern = "^[a-z]{8}-[a-z]{4}-[a-z]{4}-[0-9]{4}-[0-9]{12}$";
        final var r = Pattern.compile(pattern);
        final var m = r.matcher(str);
        return m.matches();
    }

    @Override
    public CustomersContext getCustomersContext(DomainCustomerRequest request) {
        //TODO: re-think these ifs
        if (StringUtils.isBlank(request.remoteIP()) || !isValidIPv4(request.remoteIP())) {
            return new CustomersContext(
                    new InvalidCustomerRequestStrategyImpl(),
                    new CustomerRequestValidationException("remote IP is not valid"));
        }

        if (StringUtils.isBlank(request.userID()) || !isValidString(request.userID())) {
            return new CustomersContext(
                    new InvalidCustomerRequestStrategyImpl(),
                    new CustomerRequestValidationException("UserID is not valid"));
        }

        if (request.tagID() == null || request.timestamp() == null) {
            return new CustomersContext(
                    new InvalidCustomerRequestStrategyImpl(),
                    new CustomerRequestValidationException("Tag ID or Timestamp is not valid"));
        }

        final var customerStatus = repository.getCustomerStatus(request);
        if (customerStatus == 0) {
            return new CustomersContext(
                    new InvalidCustomerRequestStrategyImpl(),
                    new CustomerDisabledException("Customer is not active"));
        }

        return new CustomersContext(
                new ValidCustomerRequestStrategy(), null);
    }
}
