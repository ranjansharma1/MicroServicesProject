package com.microservice.rating.services;

import java.util.List;

import com.microservice.rating.entities.Rating;

public interface RatingService {
	
	//create Rating
	
	Rating createRating(Rating rating);
	
	
	//Get All Rating
	
	List<Rating> getRating();
	
	
	//get All Rating by userId
	List<Rating> getRatingByUsertId(String userId);
	
	
	//get All Rating by Hotel
	List<Rating> getRAtingByHotel(String hotelId);

}
