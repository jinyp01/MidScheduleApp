package com.example.midscheduleapp.schedule.Dto;

import com.example.BaseEntity;
import lombok.Getter;

@Getter
public class UpdateScheduleResponse extends BaseEntity {

    private final Long scheduleId;
    private final String title;
    private final String content;

    public UpdateScheduleResponse(Long scheduleId, String title, String content) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
    }
}
