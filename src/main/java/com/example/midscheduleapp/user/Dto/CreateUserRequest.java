package com.example.midscheduleapp.user.Dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
public class CreateUserRequest {

    private String username;
    @Min(8)
    private String password;
    private String email;

}
