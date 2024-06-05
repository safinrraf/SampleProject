/* (C) 2024 */
package com.adex.demo.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdexErrorResponse {

  @JsonProperty("code")
  private Integer code;

  @JsonProperty("message")
  private String message;
}
