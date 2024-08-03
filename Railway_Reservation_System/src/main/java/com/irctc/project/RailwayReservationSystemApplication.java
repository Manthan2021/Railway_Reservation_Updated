package com.irctc.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication

public class RailwayReservationSystemApplication {
	
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder().defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(RailwayReservationSystemApplication.class, args);
	}

}
