package com.adex.demo.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
/**
 * CustomerRequest
 */
@AllArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Setter
@Getter
@ToString
@NoArgsConstructor
public final class CustomerRequest {

  @JsonProperty("customerID")
  private Long customerID;

  @JsonProperty("tagID")
  private Long tagID;

  @JsonProperty("userID")
  private String userID;

  @JsonProperty("remoteIP")
  private String remoteIP;

  @JsonProperty("timestamp")
  private Long timestamp;
}

