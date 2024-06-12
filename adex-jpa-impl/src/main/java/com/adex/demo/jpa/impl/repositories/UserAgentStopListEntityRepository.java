package com.adex.demo.jpa.impl.repositories;

import com.adex.demo.jpa.impl.entities.UserAgentStopListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAgentStopListEntityRepository
    extends JpaRepository<UserAgentStopListEntity, String> {}
