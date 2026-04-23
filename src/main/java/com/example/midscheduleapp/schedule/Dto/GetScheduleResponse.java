package com.example.midscheduleapp.schedule.Dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetScheduleResponse{

    private final Long scheduleId;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public GetScheduleResponse(Long scheduleId, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
