package com.ssf.spring.cloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class ReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportApplication.class, args);
	}
}