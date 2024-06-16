package com.adex.demo.domain.models;

public record DomainCustomerRequest(
    Long customerId,
    Long tagId,
    String userId,
    String remoteIp,
    Long timestamp,
    String requestAsString,
    String errorMessage) {

  public static DomainCustomerRequest fromInvalidRequest(
      Long customerId, String requestAsString, String errorMessage) {
    return new DomainCustomerRequest(
        customerId, null, null, null, null, requestAsString, errorMessage);
  }
  ;
}
