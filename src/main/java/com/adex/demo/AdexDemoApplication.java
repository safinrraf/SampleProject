package com.adex.demo;

import javax.cache.Caching;
import javax.cache.configuration.CompleteConfiguration;
import javax.cache.configuration.MutableConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories
@EnableScheduling
@Slf4j
public class AdexDemoApplication implements CommandLineRunner {

  @Value("${spring.application.name}")
  private String applicationName;

  public static void main(String[] args) {
    createCaches();
    SpringApplication.run(AdexDemoApplication.class, args);
  }

  @Override
  public void run(String... args) {
    log.info(applicationName + " up & running!");
  }

  private static void createCaches() {
    // Manually creating caches
    // Retrieve the CachingProvider which is automatically backed by
    // the chosen Hazelcast member or client provider.
    final var cachingProvider = Caching.getCachingProvider();

    // Create a CacheManager.
    final var cacheManager = cachingProvider.getCacheManager();

    // Create a simple but typesafe configuration for the cache.
    final CompleteConfiguration<String, String> config =
        new MutableConfiguration<String, String>().setTypes(String.class, String.class);

    // Create and get the cache.
    final var userAgentInStopListCache = cacheManager.createCache("UserAgentStopList", config);
    final var userIpInStopListCache = cacheManager.createCache("IpStopList", config);

    log.info("Cache created {}", userAgentInStopListCache.getName());
    log.info("Cache created {}", userIpInStopListCache.getName());
  }
}
