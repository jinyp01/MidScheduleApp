package com.example.midscheduleapp.comment.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateCommentRequest  {

    @NotBlank
    private String content;

}
