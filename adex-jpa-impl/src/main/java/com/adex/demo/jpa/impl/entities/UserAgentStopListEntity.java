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
@Table(schema = "ADEX_DB", name = "USER_AGENT_STOP_LIST")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class UserAgentStopListEntity {
  @Id
  @Column(name = "USER_AGENT")
  private String userAgent;
}
