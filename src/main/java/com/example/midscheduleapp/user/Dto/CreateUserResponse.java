package com.example.midscheduleapp.user.Dto;

import com.example.BaseEntity;
import lombok.Getter;

@Getter
public class CreateUserResponse extends BaseEntity {

    private final Long userId;
    private final String username;
    private final String email;

    public CreateUserResponse(Long userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }
}
