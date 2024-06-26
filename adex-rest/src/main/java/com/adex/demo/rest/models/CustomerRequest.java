package com.adex.demo.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.annotation.processing.Generated;

/** CustomerRequest */
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    comments =
        "Generator version: 7.5.0, using custom templates: /src/main/resources/openapitemplates")
public final class CustomerRequest {

  @JsonProperty("customerID")
  @Schema(name = "customerID", description = "Customer ID")
  private Long customerID;

  @JsonProperty("tagID")
  @Schema(name = "tagID", description = "TagID")
  private Long tagID;

  @JsonProperty("userID")
  @Schema(name = "userID", description = "User ID")
  private String userID;

  @JsonProperty("remoteIP")
  @Schema(name = "remoteIP", description = "Remote IP")
  private String remoteIP;

  @JsonProperty("timestamp")
  @Schema(name = "timestamp", description = "Timestamp")
  private Long timestamp;
}
