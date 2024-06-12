package com.adex.demo.jpa.impl;

import com.adex.demo.domain.api.UserAgentStopListService;
import com.adex.demo.domain.exceptions.UserAgentStopListException;
import com.adex.demo.jpa.impl.repositories.UserAgentStopListEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAgentStopListServiceImpl implements UserAgentStopListService {

  private final UserAgentStopListEntityRepository repository;

  @Override
  public Boolean checkUserAgentInStopList(String userAgent) throws UserAgentStopListException {
    if (repository.findById(userAgent).isPresent()) {
      throw new UserAgentStopListException(
          "Sorry, User Agent " + userAgent + " is in the Stop List!");
    }
    return true;
  }
}
