package com.adex.demo.rest.api;

import com.adex.demo.rest.models.CustomerRequest;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
@Tag(name = "API", description = "Sample Request.")
public interface CustomerRequestApi {

    @PostMapping(path = "/api/v1/customer", produces = "application/json")
    ResponseEntity<Void> processCustomerRequest(
            @Parameter(name = "CustomerRequest", description = "Sample request.", required = true)
            @Valid
            @RequestBody
            CustomerRequest customerRequest);
}
