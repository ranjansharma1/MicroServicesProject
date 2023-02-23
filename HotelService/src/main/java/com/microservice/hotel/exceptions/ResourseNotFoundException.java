package com.microservice.hotel.exceptions;

public class ResourseNotFoundException extends RuntimeException {

    public ResourseNotFoundException(){
        super("Resourse not found");
    }
    public ResourseNotFoundException(String s) {
        super(s);
    }
}
