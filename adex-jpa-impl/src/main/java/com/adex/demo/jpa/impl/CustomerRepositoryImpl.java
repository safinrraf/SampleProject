package com.adex.demo.jpa.impl;

import com.adex.demo.domain.api.CustomerRepository;
import com.adex.demo.domain.exceptions.CustomerNotFoundException;
import com.adex.demo.domain.models.DomainCustomerRequest;
import com.adex.demo.jpa.impl.repositories.CustomerEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerRepositoryImpl implements CustomerRepository {

  private final CustomerEntityRepository entityRepository;

  @Override
  public Integer getCustomerStatus(DomainCustomerRequest customerRequest) {
    log.info("DomainCustomerRequest {}", customerRequest.toString());
    final var entity =
        entityRepository
            .findById(customerRequest.customerId())
            .orElseThrow(
                () ->
                    new CustomerNotFoundException(
                        "Customer with ID " + customerRequest.customerId() + " not found"));
    return entity.getActive();
  }
}
