package com.microservice.hotel.services;

import com.microservice.hotel.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelServices {
    //create
    Hotel create(Hotel hotel);

    //getAll
    List<Hotel> getAll();

    //get1Hotel
    Hotel get(String id);
}
