package com.microservice.hotel.repositories;

import com.microservice.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepositories extends JpaRepository<Hotel, String> {
}
