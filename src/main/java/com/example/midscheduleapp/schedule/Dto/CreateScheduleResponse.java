package com.example.midscheduleapp.schedule.Dto;


import com.example.midscheduleapp.BaseEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {

    private final Long scheduleId;
    private final String title;
    private final String content;
    private final LocalDateTime created_at;
    private final LocalDateTime updqted_at;

    public CreateScheduleResponse(Long scheduleId, String title, String content, LocalDateTime createdAt, LocalDateTime updqtedAt) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.created_at = createdAt;
        this.updqted_at = updqtedAt;
    }
}
