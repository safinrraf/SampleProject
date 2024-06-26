package com.adex.demo.jpa.impl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CUSTOMER_WRONG_REQUESTS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerInvalidRequestEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "request_id")
  private Long requestId;

  @Column(name = "customer_id")
  private Long customerId;

  @Column(name = "request_text", length = 30000)
  private String request;

  @Column(name = "error_message_text", length = 30000)
  private String errorMessage;
}
