package com.adex.demo.domain.models;

import com.adex.demo.domain.exceptions.CustomerRequestsQueueException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class CustomerRequestsQueue {

  private static final BlockingQueue<DomainCustomerRequest> blockingQueue =
      new LinkedBlockingQueue<>();

  private CustomerRequestsQueue() {
    throw new UnsupportedOperationException("This class cannot be instantiated");
  }

  public static void put(DomainCustomerRequest request) {
    try {
      blockingQueue.put(request);
      log.info("A new message in the BlockingQueue {}", request);
    } catch (InterruptedException e) {
      log.error("Can not put a message to BlockingQueue, for the request {}", request);
      Thread.currentThread().interrupt();
      throw new CustomerRequestsQueueException(e.getMessage(), e);
    }
  }

  public static DomainCustomerRequest get() {
    try {
      return blockingQueue.take();
    } catch (InterruptedException e) {
      log.error("Can not get a message from the BlockingQueue");
      Thread.currentThread().interrupt();
      throw new CustomerRequestsQueueException(e.getMessage(), e);
    }
  }
}
