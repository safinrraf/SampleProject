package com.adex.demo;

import com.adex.demo.rest.models.CustomerRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(classes = AdexDemoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class CustomerRequestControllerTest {

  @BeforeEach
  void setUp() {}

  @AfterEach
  void tearDown() {}

  @Test
  void processCustomerRequestAccepted(@Autowired WebTestClient client) {
    final var customerRequest =
        new CustomerRequest(
            10001L, 2L, "aaaaaaaa-bbbb-cccc-1111-222222222222", "123.234.56.71", 1500000000L);
    final var result =
        client
            .post()
            .uri("/api/v1/customer")
            .body(Mono.just(customerRequest), CustomerRequest.class)
            .exchange()
            .expectStatus()
            .isAccepted()
            .expectBody()
            .isEmpty();
  }

  @Test
  void processCustomerRequestCustomerNotFound(@Autowired WebTestClient client) {
    final var customerRequest =
        new CustomerRequest(
            9999L, 2L, "aaaaaaaa-bbbb-cccc-1111-222222222222", "123.234.56.71", 1500000000L);
    final var result =
        client
            .post()
            .uri("/api/v1/customer")
            .body(Mono.just(customerRequest), CustomerRequest.class)
            .exchange()
            .expectStatus()
            .isNotFound()
            .expectBody()
            .json("{\"code\":404,\"message\":\"Customer with ID 9999 not found\"}");
  }

  @Test
  void processCustomerRequestCustomerNotActive(@Autowired WebTestClient client) {
    final var customerRequest =
        new CustomerRequest(
            10002L, 2L, "aaaaaaaa-bbbb-cccc-1111-222222222222", "123.234.56.71", 1500000000L);
    final var result =
        client
            .post()
            .uri("/api/v1/customer")
            .body(Mono.just(customerRequest), CustomerRequest.class)
            .exchange()
            .expectStatus()
            .isBadRequest()
            .expectBody()
            .json("{\"code\":401,\"message\":\"Customer is not active\"}");
  }
}
