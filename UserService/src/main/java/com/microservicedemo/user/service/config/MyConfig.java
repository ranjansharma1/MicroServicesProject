package com.microservicedemo.user.service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
	//This is for call another api from this service class
	//here we can create as many bean as want
	@Bean
	@LoadBalanced // load balanced used to make resttemplte port independent, means if we change port in any services, it will not effect our code
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	

}
