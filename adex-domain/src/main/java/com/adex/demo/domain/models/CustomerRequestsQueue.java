package com.adex.demo.domain.models;

import com.adex.demo.domain.exceptions.CustomerRequestsQueueException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class CustomerRequestsQueue {
  // TODO: what if there will be N queues?
  private static final BlockingQueue<DomainCustomerRequest> QUEUE_FOR_VALID_REQUESTS =
      new LinkedBlockingQueue<>();

  private static final BlockingQueue<DomainCustomerRequest> QUEUE_FOR_INVALID_REQUESTS =
      new LinkedBlockingQueue<>();

  private static final String LOG_STR = "A new message in the BlockingQueue {}";
  private static final String LOG_STR_PUT_ERROR =
      "Can not put a message to BlockingQueue, for the request {}";
  private static final String LOG_STR_GET_ERROR = "Can not get a message from the BlockingQueue";

  private CustomerRequestsQueue() {
    throw new UnsupportedOperationException("This class cannot be instantiated");
  }

  public static void put(DomainCustomerRequest request) {
    try {
      QUEUE_FOR_VALID_REQUESTS.put(request);
      log.info(LOG_STR, request);
    } catch (InterruptedException e) {
      log.error(LOG_STR_PUT_ERROR, request);
      Thread.currentThread().interrupt();
      throw new CustomerRequestsQueueException(e.getMessage(), e);
    }
  }

  public static void putInvalidRequest(DomainCustomerRequest request) {
    try {
      QUEUE_FOR_INVALID_REQUESTS.put(request);
      log.info(LOG_STR, request);
    } catch (InterruptedException e) {
      log.error(LOG_STR_PUT_ERROR, request);
      Thread.currentThread().interrupt();
      throw new CustomerRequestsQueueException(e.getMessage(), e);
    }
  }

  public static DomainCustomerRequest get() {
    try {
      return QUEUE_FOR_VALID_REQUESTS.take();
    } catch (InterruptedException e) {
      log.error(LOG_STR_GET_ERROR);
      Thread.currentThread().interrupt();
      throw new CustomerRequestsQueueException(e.getMessage(), e);
    }
  }

  public static DomainCustomerRequest getInvalidRequest() {
    try {
      return QUEUE_FOR_INVALID_REQUESTS.take();
    } catch (InterruptedException e) {
      log.error(LOG_STR_GET_ERROR);
      Thread.currentThread().interrupt();
      throw new CustomerRequestsQueueException(e.getMessage(), e);
    }
  }
}
