package com.adex.demo.domain.utils;

import java.net.InetAddress;

public final class IpConverter {

  private IpConverter() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  public static long ipToLong(String ipAddress) {
    try {
      final byte[] bytes = InetAddress.getByName(ipAddress).getAddress();
      long result = 0;
      for (byte b : bytes) {
        result = result << 8 | (b & 0xFF);
      }
      return result;
    } catch (Exception ignore) {
      return -1;
    }
  }
}
