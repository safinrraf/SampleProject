package com.adex.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class AdexDemoApplication implements CommandLineRunner {

	@Value("${spring.application.name}")
	private String applicationName;

	public static void main(String[] args) {
		SpringApplication.run(AdexDemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info(applicationName + " up & running!");
	}

}
