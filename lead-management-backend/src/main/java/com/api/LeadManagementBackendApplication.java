package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.api.entity")
public class LeadManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadManagementBackendApplication.class, args);
	}

}
