package com.adex.demo.config;

import com.adex.demo.domain.api.IpStopListService;
import com.adex.demo.domain.api.UserAgentStopListService;
import com.adex.demo.interceptors.AdexRequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

  private final IpStopListService stopListService;
  private final UserAgentStopListService userAgentStopListService;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new AdexRequestInterceptor(stopListService, userAgentStopListService));
  }
}
