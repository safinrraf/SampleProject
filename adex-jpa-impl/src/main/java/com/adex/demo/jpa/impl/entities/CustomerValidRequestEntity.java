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
@Table(name = "CUSTOMER_VALID_REQUESTS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public final class CustomerValidRequestEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "request_id")
  private Long requestId;

  @Column(name = "customer_id")
  private Long customerId;

  @Column(name = "tag_id")
  private Integer tagId;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "remote_ip")
  private Long remoteIp;

  @Column(name = "timestamp")
  private Long timestamp;
}
