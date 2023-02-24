package com.microservice.rating.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.rating.entities.Rating;
import com.microservice.rating.repositories.RatingRepository;
import com.microservice.rating.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingRepository ratingRepo;

	@Override
	public Rating createRating(Rating rating) {
		
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRating() {
		List<Rating> ratings = ratingRepo.findAll();
		return ratings;
	}

	@Override
	public List<Rating> getRatingByUsertId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating>  getRAtingByHotel(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
