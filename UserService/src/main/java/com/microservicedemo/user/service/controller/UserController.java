package com.microservicedemo.user.service.controller;


import com.microservicedemo.user.service.entities.User;
import com.microservicedemo.user.service.services.UserService;
import com.microservicedemo.user.service.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class UserController {
    @Autowired
    UserService userService;

   /* POST:localhost:8081/service
   {
        "name":"Ranjan Sharma",
            "email":"ran@gmail.com",
            "about":"I am full stack developer"
    }*/
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }


    //    Get: localhost:8081/service
    @GetMapping()
    public  ResponseEntity<List<User>> fetchAllUser(){
        List<User> users=userService.getAllUser();
        return  ResponseEntity.status(HttpStatus.OK).body(users);
    }

//    Get: localhost:8081/service/93488a73-3d3b-4951-a892-685d96304f69
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserbyId(@PathVariable String userId){
        User user=userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
//        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    /*PUT: localhost:8081/service/update/93488a73-3d3b-4951-a892-685d96304f69
    {
        "name":"Rakesh Sharma",
            "email":"rakesh@gmail.com",
            "about":"He is full stack developer and intelligent"
    }*/
    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user){
        user.setUserId(userId);
        System.out.println(user);
        User updatedUser=userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }


//    Delete:localhost:8081/service/delete/edd5cebd-7bba-4c02-bccb-6cb3007a8
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") String id){
        String res=userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
