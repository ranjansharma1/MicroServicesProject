package com.microservicedemo.user.service.services.impl;

import com.microservicedemo.user.service.entities.User;
import com.microservicedemo.user.service.exceptions.ResourceNotFoundException;
import com.microservicedemo.user.service.repositories.UserRepository;
import com.microservicedemo.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

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
        User user=userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User with given Id is not found on server... " +id));
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
