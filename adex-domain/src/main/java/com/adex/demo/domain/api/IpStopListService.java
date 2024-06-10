package com.adex.demo.domain.api;

import com.adex.demo.domain.exceptions.IpStopListException;

public interface IpStopListService {
  /**
   * Checks if the IP is in the stop list.
   *
   * @param ip IP.
   * @throws IpStopListException if the IP is in the stop list.
   */
  Boolean checkIpInStopList(String ip) throws IpStopListException;
}
