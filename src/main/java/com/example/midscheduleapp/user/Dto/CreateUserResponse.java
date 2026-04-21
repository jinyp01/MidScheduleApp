package com.example.midscheduleapp.user.Dto;

import com.example.midscheduleapp.BaseEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateUserResponse {

    private final Long userId;
    private final String username;
    private final String email;
    private final LocalDateTime created_at;
    private final LocalDateTime updated_at;

    public CreateUserResponse(Long userId, String username, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.created_at = createdAt;
        this.updated_at = updatedAt;
    }
}
