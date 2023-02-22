package com.microservicedemo.user.service.repositories;

import com.microservicedemo.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    //Custom method or query
}
