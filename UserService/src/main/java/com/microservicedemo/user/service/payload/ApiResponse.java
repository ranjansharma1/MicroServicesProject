package com.microservicedemo.user.service.payload;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@Builder
public class ApiResponse {

    private String massage;
    private boolean success;
    private HttpStatus status;
}
