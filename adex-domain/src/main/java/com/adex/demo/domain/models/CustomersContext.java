package com.adex.demo.domain.models;

import com.adex.demo.domain.api.CustomersRequestManager;
import com.adex.demo.domain.exceptions.AdexException;

public record CustomersContext(CustomersRequestManager statsManager, AdexException adexException) {}
