package com.microservice.hotel.services.impl;

import com.microservice.hotel.entities.Hotel;
import com.microservice.hotel.exceptions.ResourseNotFoundException;
import com.microservice.hotel.repositories.HotelRepositories;
import com.microservice.hotel.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelServices {
    @Autowired
    private HotelRepositories hotelRepo;


    @Override
    public Hotel create(Hotel hotel) {
        String randomHotelId= UUID.randomUUID().toString();
        hotel.setId(randomHotelId);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel get(String id) {
        Hotel hotel=hotelRepo.findById(id).orElseThrow(()-> new ResourseNotFoundException("Hotel Not Found !!! "));
        return hotel;
    }
}
