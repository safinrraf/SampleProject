package com.adex.demo.domain.models;

public record DomainCustomerRequest(
        Long customerID,
        Long tagID,
        String userID,
        String remoteIP,
        Long timestamp
) {
}
