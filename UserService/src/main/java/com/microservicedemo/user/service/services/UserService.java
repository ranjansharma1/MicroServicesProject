package com.microservicedemo.user.service.services;

import com.microservicedemo.user.service.entities.User;

import java.util.List;

public interface UserService {

    //USer Operation

    //Create
    User saveUser(User user);

    //fetch
    List<User> getAllUser();
    User getUserById(String id);

    //Delete
    String deleteUser(String id);

    //Update
    User updateUser(User user);
}
