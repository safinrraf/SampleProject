package com.adex.demo.jpa.impl.repositories;

import com.adex.demo.jpa.impl.entities.CustomerInvalidRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInvalidRequestEntityRepository
    extends JpaRepository<CustomerInvalidRequestEntity, Long> {}
