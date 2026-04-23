package com.example.midscheduleapp.comment.Controller;

import com.example.midscheduleapp.BaseEntity;
import com.example.midscheduleapp.comment.Dto.CreateCommentRequest;
import com.example.midscheduleapp.comment.Dto.CreateCommentResponse;
import com.example.midscheduleapp.comment.Dto.GetCommentResponse;
import com.example.midscheduleapp.comment.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/users/{userId}/schedules/{scheduleId}/comments")
    ResponseEntity<CreateCommentResponse> createComment(
            @Validated
            @PathVariable Long userId,
            @PathVariable Long scheduleId,
            @RequestBody CreateCommentRequest request
            ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                commentService.create(userId, scheduleId, request));
    }

    @GetMapping("/users/{userId}/schedules/{scheduleId}/comments")
    ResponseEntity<List<GetCommentResponse>> getAllComment(
            @PathVariable Long scheduleId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getAll(scheduleId));
    }




}
