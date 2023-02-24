package com.microservice.hotel.controller;

import com.microservice.hotel.entities.Hotel;
import com.microservice.hotel.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelServices hotelServices;


    //create
    @PostMapping
/*    post: localhost:8082/hotel
    {
        "name": "Tara Sweets",
            "location": "Palamu Jharkhand",
            "about":" YOu will get Vegeterian foood and best quality accomadation"
    }*/
    public ResponseEntity<Hotel>  saveHotel(@RequestBody Hotel hotel){
        Hotel newHotel= hotelServices.create(hotel);
        return new ResponseEntity<>(newHotel, HttpStatus.CREATED);
    }


    //FetchAll
    @GetMapping()
    public ResponseEntity<List<Hotel>> FetchHotels(){
        List<Hotel> hotels=hotelServices.getAll();

        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }


    //Fetch one HotelDetails
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        Hotel hotel=hotelServices.get(hotelId);
        return new ResponseEntity<>(hotel,HttpStatus.OK);
    }
}
