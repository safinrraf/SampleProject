package com.adex.demo.jpa.impl;

import com.adex.demo.domain.api.UserAgentStopListService;
import com.adex.demo.domain.exceptions.UserAgentStopListException;
import com.adex.demo.jpa.impl.repositories.UserAgentStopListEntityRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserAgentStopListServiceImpl implements UserAgentStopListService {

  private final UserAgentStopListEntityRepository repository;

  @Override
  @Cacheable(cacheNames = "UserAgentStopList", key = "#p0", unless = "#result == null")
  public Optional<String> getUserAgentFromStopList(String userAgent)
      throws UserAgentStopListException {
    log.info("call getUserAgentFromStopList for {}", userAgent);
    final var optionalUserAgentStopListEntity = repository.findById(userAgent);

    if (optionalUserAgentStopListEntity.isPresent()) {
      log.warn("User agent found in stop list: {}", userAgent);
      return Optional.of(userAgent);
    }
    return Optional.empty();
  }
}
