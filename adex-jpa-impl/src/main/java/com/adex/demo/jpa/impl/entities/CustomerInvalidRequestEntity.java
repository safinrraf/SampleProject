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
@Table(schema = "ADEX_DB", name = "CUSTOMER_WRONG_REQUESTS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public final class CustomerInvalidRequestEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "REQUEST_ID")
  private Long requestId;

  @Column(name = "CUSTOMER_ID")
  private Long customerId;

  @Column(name = "REQUEST_TEXT", length = 30000)
  private String request;

  @Column(name = "ERROR_MESSAGE_TEXT", length = 30000)
  private String errorMessage;
}
