package com.adex.demo.domain.impl;

import com.adex.demo.domain.api.CustomerRepository;
import com.adex.demo.domain.models.CustomerRequestsQueue;
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

  private final CustomerRepository repository;

  @Scheduled(fixedDelay = 10)
  public void processCustomerRequest() {
    final var request = CustomerRequestsQueue.get();
    log.info("Processing a new message from the BlockingQueue {}", request);
    repository.saveCustomerRequest(request);
  }
}
