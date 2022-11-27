package com.backendbudgettracker.backendbudgettracker.dto;

import lombok.Data;

@Data // Lombok - instead of Getters and Setters
public class LoginReturnDTO {

    private String token;

    private String userType;

    private Long userId;

}