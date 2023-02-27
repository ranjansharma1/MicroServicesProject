package com.microservicedemo.user.service.services.impl;

import com.microservicedemo.user.service.entities.Hotel;
import com.microservicedemo.user.service.entities.Rating;
import com.microservicedemo.user.service.entities.User;
import com.microservicedemo.user.service.exceptions.ResourceNotFoundException;
import com.microservicedemo.user.service.external.services.HotelService;
import com.microservicedemo.user.service.external.services.RatingService;
import com.microservicedemo.user.service.repositories.UserRepository;
import com.microservicedemo.user.service.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private HotelService hotelService;
    
    @Autowired
    private RatingService ratingService;
    
    
    //It will trackthe log in console
    private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId= UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        User newUser=userRepo.save(user);
        return newUser;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users=userRepo.findAll();
        
        List<User> usersWithRating=users.stream().map(user->{
        	return getUserById(user.getUserId());
        }).collect(Collectors.toList());
        
        
        return users;
    }

    @Override
    public User getUserById(String id) {
    	//get user from database with the help of user repository
        User user=userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User with given Id is not found on server... " +id));
        
        //Fetching rating details from feign client
        List<Rating> ratings=ratingService.getRating(user.getUserId());
            
        //iterating each list and calling hotel service and adding in each user rating
        List<Rating> ratingList=ratings.stream().map(rating->{        	
	    	//Hotel API call from rating 
        	Hotel hotel=hotelService.getHotel(rating.getHotelId());
        	
        	//set the hotel to rating
        	rating.setHotel(hotel);
        	
        	//return rating with hotel details
        	return rating;
        }).collect(Collectors.toList());
        
        user.setRatings(ratingList);
        
        return user;
    }

    @Override
    public String deleteUser(String id) {
        User user=userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User with given Id is not found on server... " +id));
        userRepo.delete(user);
        return "Deleted Successfully!";
    }

    @Override
    public User updateUser(User user) {
        User newUser=userRepo.findById(user.getUserId()).orElseThrow(()->new ResourceNotFoundException("User with given Id is not found on server... " +user.getUserId()));
        newUser.setName(user.getName());
        newUser.setAbout(user.getAbout());
        newUser.setEmail(user.getEmail());
        userRepo.save(newUser);
        return newUser;
    }
}
