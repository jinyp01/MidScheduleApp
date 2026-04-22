package com.example.midscheduleapp.schedule.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateScheduleRequest {

    @Size(max = 20)
    private String title;

    @Size(max = 100)
    private String content;

}
