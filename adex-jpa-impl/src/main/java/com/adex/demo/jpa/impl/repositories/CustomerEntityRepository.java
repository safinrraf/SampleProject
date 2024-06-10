package com.adex.demo.jpa.impl.repositories;

import com.adex.demo.jpa.impl.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Long> {}
