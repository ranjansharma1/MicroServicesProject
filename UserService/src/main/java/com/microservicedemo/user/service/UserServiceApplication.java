package com.microservicedemo.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	//we can make bean method here to call service to this service, but prefer to create a new class andd implement ther (myConfig.java)
	
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}


}
