package com.microservicedemo.user.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
	//This is for call another api from this service class
	//here we cn create as many bean as want
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	

}
