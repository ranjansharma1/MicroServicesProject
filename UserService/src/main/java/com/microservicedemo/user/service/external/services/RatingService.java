package com.microservicedemo.user.service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.microservicedemo.user.service.entities.Rating;


@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	@GetMapping("/rating/user/{userId}")
	public List<Rating> getRating(@PathVariable("userId") String Id);
	
	// we can use these when we need, as of now we don't need in this project
	
	@PostMapping("/rating")
	public Rating createRating(Rating values);
	
	@PutMapping("/rating/{ratingId}")
	public Rating updateRating(@PathVariable String ratingId, Rating rating);
	
	
	@DeleteMapping("/rating/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);
	

}
