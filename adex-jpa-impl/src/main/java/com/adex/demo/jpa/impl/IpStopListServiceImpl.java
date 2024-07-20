package com.adex.demo.jpa.impl;

import com.adex.demo.domain.api.IpStopListService;
import com.adex.demo.domain.utils.IpConverter;
import com.adex.demo.jpa.impl.repositories.IpStopListEntityRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class IpStopListServiceImpl implements IpStopListService {

  private final IpStopListEntityRepository repository;

  @Override
  @Cacheable(cacheNames = "IpStopList", key = "#p0", unless = "#result == null")
  public Optional<String> getIpFromStopList(String ip) {
    log.info("Call getIpFromStopList with {}", ip);
    final var ipAsLong = IpConverter.ipToLong(ip);
    final var optionalIpStopListEntity = repository.findById(ipAsLong);

    if (optionalIpStopListEntity.isPresent()) {
      log.warn("IP found in stop list: {}", ip);
      return Optional.of(ip);
    }

    return Optional.empty();
  }
}
