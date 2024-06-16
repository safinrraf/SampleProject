package com.adex.demo.jpa.impl.repositories;

import com.adex.demo.jpa.impl.entities.CustomerValidRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerValidRequestEntityRepository
    extends JpaRepository<CustomerValidRequestEntity, Long> {}
