package com.adex.demo.domain.impl;

import com.adex.demo.domain.api.RequestRepositoryService;
import com.adex.demo.domain.models.CustomerRequestsQueue;
import com.adex.demo.domain.models.DomainCustomerRequest;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Profile({"local", "prod"})
@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerRequestsProcessor {

  private final RequestRepositoryService repository;

  @Scheduled(fixedDelay = 10)
  public void processCustomerRequest() {
    processRequestWithAction(CustomerRequestsQueue::get, repository::saveValidRequest);
  }

  @Scheduled(fixedDelay = 10)
  public void processInvalidCustomerRequest() {
    processRequestWithAction(
        CustomerRequestsQueue::getInvalidRequest, repository::saveInvalidRequest);
  }

  private void processRequestWithAction(
      Supplier<DomainCustomerRequest> supplier, Consumer<DomainCustomerRequest> action) {
    try {
      final var requestFromQueue = supplier.get();
      log.info("Current Thread : {}", Thread.currentThread().getName());
      log.info("Processing a new message from the BlockingQueue {}", requestFromQueue);
      action.accept(requestFromQueue);
    } catch (Exception e) {
      log.error("Error saving a valid request {}", e.getMessage());
      throw e;
    }
  }
}
