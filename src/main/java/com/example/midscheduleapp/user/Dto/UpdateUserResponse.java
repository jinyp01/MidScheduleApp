package com.example.midscheduleapp.user.Dto;

import com.example.midscheduleapp.BaseEntity;
import lombok.Getter;

@Getter
public class UpdateUserResponse extends BaseEntity {

    private final Long userId;
    private final String username;
    private final String email;

    public UpdateUserResponse(Long userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

}
