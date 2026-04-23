package com.example.midscheduleapp.comment.Dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetCommentResponse {

    private final Long id;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public GetCommentResponse(Long id, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
