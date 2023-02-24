package com.microservice.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.rating.entities.Rating;
import com.microservice.rating.services.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	@Autowired
	private RatingService ratingService;
	
	//create Rating
	@PostMapping
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
		System.out.println("Created!!!");
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	
	////get All Rating
	@GetMapping
	public ResponseEntity<List<Rating>> fetchAllRating(){
		return ResponseEntity.ok(ratingService.getRating());
	}
	
	//get AllRating by userId
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> fetchAllRatingByUserId(@PathVariable String userId){
		return ResponseEntity.ok(ratingService.getRatingByUsertId(userId));
	}
	
	//get AllRating by hotelId
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> fetchAllRatingByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(ratingService.getRAtingByHotel(hotelId));
	}
	

}
