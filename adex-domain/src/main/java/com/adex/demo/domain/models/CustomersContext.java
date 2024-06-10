package com.adex.demo.domain.models;

import com.adex.demo.domain.api.CustomerStatsManager;
import com.adex.demo.domain.exceptions.AdexException;

public record CustomersContext(CustomerStatsManager statsManager, AdexException adexException) {}
