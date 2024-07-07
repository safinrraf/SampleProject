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
@Table(schema = "ADEX_DB", name = "CUSTOMER_VALID_REQUESTS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public final class CustomerValidRequestEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "REQUEST_ID")
  private Long requestId;

  @Column(name = "CUSTOMER_ID")
  private Long customerId;

  @Column(name = "TAG_ID")
  private Integer tagId;

  @Column(name = "USER_ID")
  private String userId;

  @Column(name = "REMOTE_IP")
  private Long remoteIp;

  @Column(name = "TIMESTAMP")
  private Long timestamp;
}
