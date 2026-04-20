package com.example.midscheduleapp.user.Dto;

import lombok.Getter;

@Getter
public class CreateUserRequest {

    private String username;
    private String password;
    private String email;

}
