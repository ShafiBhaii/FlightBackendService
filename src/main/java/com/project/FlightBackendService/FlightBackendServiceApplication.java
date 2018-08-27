package com.project.FlightBackendService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableDiscoveryClient*/
@SpringBootApplication
public class FlightBackendServiceApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(FlightBackendServiceApplication.class, args);
	}
}
