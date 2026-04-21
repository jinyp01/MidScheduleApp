package com.example.midscheduleapp.schedule.Dto;


import com.example.midscheduleapp.BaseEntity;
import lombok.Getter;

@Getter
public class CreateScheduleResponse extends BaseEntity {

    private final Long scheduleId;
    private final String title;
    private final String content;

    public CreateScheduleResponse(Long scheduleId, String title, String content) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
    }
}
