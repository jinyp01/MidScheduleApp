package com.example.midscheduleapp.schedule.Dto;


import com.example.BaseEntity;
import lombok.Getter;

@Getter
public class CreateSchesuleRequest extends BaseEntity {

    private String title;
    private String content;

}
