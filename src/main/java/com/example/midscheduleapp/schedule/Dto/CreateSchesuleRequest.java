package com.example.midscheduleapp.schedule.Dto;


import com.example.midscheduleapp.BaseEntity;
import lombok.Getter;

@Getter
public class CreateSchesuleRequest extends BaseEntity {

    private Long userId;
    private String title;
    private String content;

}
