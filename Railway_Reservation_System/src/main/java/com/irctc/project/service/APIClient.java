package com.irctc.project.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url = "http://localhost:9999" ,value="Bank-service")
public interface APIClient {
	
	@GetMapping("/obs/data/getId/{email}")
    public String gettheId(@PathVariable String email);
	
}
