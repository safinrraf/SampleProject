package com.adex.demo.interceptors;

import com.adex.demo.domain.api.IpStopListService;
import com.adex.demo.domain.api.UserAgentStopListService;
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
  private final UserAgentStopListService userAgentStopListService;

  @Override
  public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object object) {
    final var userAgent = request.getHeader("user-agent");
    log.info("Received a request from IP {}", request.getRemoteAddr());
    log.info("Received a request from User Agnt {}", userAgent);
    if (stopListService.getIpFromStopList(request.getRemoteAddr()).isPresent()) {
      log.error("IP {} is in the stop list!", request.getRemoteAddr());
    }
    if (userAgentStopListService.getUserAgentFromStopList(userAgent).isPresent()) {
      log.error("User Agent {} is in the stop list!", userAgent);
    }
    return true;
  }
}
