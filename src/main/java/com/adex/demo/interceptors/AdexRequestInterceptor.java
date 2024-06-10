package com.adex.demo.interceptors;

import com.adex.demo.domain.api.IpStopListService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
@Slf4j
public class AdexRequestInterceptor implements HandlerInterceptor {

  private final IpStopListService stopListService;

  @Override
  public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object object) {
    log.info("Received a request from {}", request.getRemoteAddr());
    if (!stopListService.checkIpInStopList(request.getRemoteAddr())) {
      log.error("IP {} is in the stop list!", request.getRemoteAddr());
    }
    return true;
  }
}
