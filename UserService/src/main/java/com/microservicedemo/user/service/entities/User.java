package com.microservicedemo.user.service.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "micro_users")
public class User {
    @Id
    private String userId;
    @Column(length = 20)
    private String name;
    private String email;
    private String about;
    //other user properties can be taken

    //if you dont want to save this in db
    @Transient
    private List<Rating> ratings=new ArrayList<>();

}
