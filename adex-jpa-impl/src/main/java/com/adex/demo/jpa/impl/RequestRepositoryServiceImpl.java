package com.adex.demo.jpa.impl;

import com.adex.demo.domain.api.RequestRepositoryService;
import com.adex.demo.domain.models.DomainCustomerRequest;
import com.adex.demo.jpa.impl.mappers.CustomerRequestsEntityMapper;
import com.adex.demo.jpa.impl.repositories.CustomerInvalidRequestEntityRepository;
import com.adex.demo.jpa.impl.repositories.CustomerValidRequestEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class RequestRepositoryServiceImpl implements RequestRepositoryService {

  private static final String LOG_MESSAGE = "Saved entity {}";

  private final CustomerRequestsEntityMapper mapper;
  private final CustomerValidRequestEntityRepository repository;
  private final CustomerInvalidRequestEntityRepository invalidRequestEntityRepository;

  @Override
  public void saveValidRequest(DomainCustomerRequest request) {
    try {
      final var customerValidRequest = mapper.mapValidRequestToEntity(request);
      final var savedEntity = repository.saveAndFlush(customerValidRequest);
      log.info(LOG_MESSAGE, savedEntity);
    } catch (Exception e) {
      log.error("Error saving an invalid request {}", e.getMessage());
    }
  }

  @Override
  public void saveInvalidRequest(DomainCustomerRequest request) {
    try {
      final var entity = mapper.mapInvalidRequestToEntity(request);
      final var savedEntity = invalidRequestEntityRepository.saveAndFlush(entity);
      log.info(LOG_MESSAGE, savedEntity);
    } catch (Exception e) {
      log.error("Error saving an invalid request {}", e.getMessage());
    }
  }
}
