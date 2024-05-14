package com.adex.demo.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.annotation.processing.Generated;

/** CustomersStatsResponse */
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    comments =
        "Generator version: 7.5.0, using custom templates: /src/main/resources/openapitemplates")
public final class CustomersStatsResponse {

  @JsonProperty("customerID")
  @Schema(name = "customerID", description = "Customer ID")
  private Long customerID;
}
