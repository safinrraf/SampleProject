package com.adex.demo.domain.api;

import com.adex.demo.domain.exceptions.UserAgentStopListException;

public interface UserAgentStopListService {
  /**
   * Checks if the User Agent is in the stop list.
   *
   * @param userAgent User Agent.
   * @throws UserAgentStopListException if the User Agent is in the stop list.
   */
  Boolean checkUserAgentInStopList(String userAgent) throws UserAgentStopListException;
}
