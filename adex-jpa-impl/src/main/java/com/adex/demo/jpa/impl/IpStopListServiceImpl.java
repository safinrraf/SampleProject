package com.adex.demo.jpa.impl;

import com.adex.demo.domain.api.IpStopListService;
import com.adex.demo.domain.exceptions.IpStopListException;
import com.adex.demo.domain.utils.IpConverter;
import com.adex.demo.jpa.impl.repositories.IpStopListEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class IpStopListServiceImpl implements IpStopListService {

  private final IpStopListEntityRepository repository;

  @Override
  public Boolean checkIpInStopList(String ip) {
    if (repository.findById(IpConverter.ipToLong(ip)).isPresent()) {
      throw new IpStopListException("Sorry, IP " + ip + " is in a stop list!");
    }
    return true;
  }
}
