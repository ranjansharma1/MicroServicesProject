package com.microservice.rating.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.rating.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating, String>{

	//custom finder method
	
	public List<Rating> findByUserId(String id);
	public List<Rating> findByHotelId(String id);
	
}
