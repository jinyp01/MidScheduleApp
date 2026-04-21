package com.example.midscheduleapp.user.Dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetUserResponse {

    private final Long userId;
    private final String username;
    private final String email;
    private final LocalDateTime created_at;
    private final LocalDateTime updated_at;

    public GetUserResponse(Long userId, String username, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.created_at = createdAt;
        this.updated_at = updatedAt;
    }
}
