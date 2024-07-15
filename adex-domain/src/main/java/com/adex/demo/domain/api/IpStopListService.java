package com.adex.demo.domain.api;

import com.adex.demo.domain.exceptions.IpStopListException;
import java.util.Optional;

public interface IpStopListService {
  /**
   * Checks if the IP is in the stop list.
   *
   * @param ip IP.
   * @return value
   * @throws IpStopListException if the IP is in the stop list.
   */
  Optional<String> getIpFromStopList(String ip) throws IpStopListException;
}
