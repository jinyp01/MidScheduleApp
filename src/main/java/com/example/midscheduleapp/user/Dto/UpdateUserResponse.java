package com.example.midscheduleapp.user.Dto;

import com.example.midscheduleapp.BaseEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateUserResponse {

    private final Long userId;
    private final String username;
    private final String email;
    private final LocalDateTime created_at;
    private final LocalDateTime updated_at;

    public UpdateUserResponse(Long userId, String username, String email, LocalDateTime created_at, LocalDateTime updated_at) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

}
