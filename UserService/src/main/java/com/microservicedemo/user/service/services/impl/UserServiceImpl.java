package com.microservicedemo.user.service.services.impl;

import com.microservicedemo.user.service.entities.Hotel;
import com.microservicedemo.user.service.entities.Rating;
import com.microservicedemo.user.service.entities.User;
import com.microservicedemo.user.service.exceptions.ResourceNotFoundException;
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
        return users;
    }

    @Override
    public User getUserById(String id) {
    	//get user from database with the help of user repository
        User user=userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User with given Id is not found on server... " +id));
               
        //fetch rating of the above user from Rating Service
        String url="http://RATING-SERVICE/rating/user/"+user.getUserId();

//        ArrayList<Rating> ratingForUser= restTemplate.getForObject(url, ArrayList.class);
        Rating[] ratingForUser= restTemplate.getForObject(url, Rating[].class);
//        System.out.println("Object is:- "+ forObject);
        logger.info("{}", ratingForUser);
        
        //converting array to arraylist
        List<Rating> ratings=Arrays.stream(ratingForUser).toList();      
            
        //iterating each list and calling hotel service and adding in each user rating
        List<Rating> ratingList=ratings.stream().map(rating->{        	
	    	//Hotel API call from rating 
	    	String hotelUrl="http://HOTEL-SERVICE/hotels/"+rating.getHotelId();
	    	ResponseEntity<Hotel> hotelForUser=restTemplate.getForEntity(hotelUrl, Hotel.class);
	    	Hotel hotel=hotelForUser.getBody();
	    	logger.info("response status code: {}"+hotelForUser.getStatusCodeValue());
        	
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
