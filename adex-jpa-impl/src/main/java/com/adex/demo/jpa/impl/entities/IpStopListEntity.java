package com.adex.demo.jpa.impl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "IP_STOP_LIST")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class IpStopListEntity {
  @Id
  @Column(name = "ip")
  private Long ip;
}
