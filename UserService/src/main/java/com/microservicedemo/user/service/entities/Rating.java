package com.microservicedemo.user.service.entities;

import lombok.Data;


//here we don't need to create table wo we will not use @Table annotation
@Data
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private String feedback;
    private int rating;
    
    private Hotel hotel;


}
