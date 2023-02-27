package com.microservicedemo.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservicedemo.user.service.entities.Rating;
import com.microservicedemo.user.service.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {
	@Autowired
	RatingService ratingService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void createRating() {
		Rating rating=Rating.builder().rating(10).userId("").hotelId("").feedback("you ae too good bro!!!").build();
		Rating savedRating=ratingService.createRating(rating);
		System.out.println("Rating created: "+ savedRating);
	}

}
