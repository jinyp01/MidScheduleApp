package com.example.midscheduleapp.comment.Controller;

import com.example.midscheduleapp.BaseEntity;
import com.example.midscheduleapp.comment.Dto.CreateCommentRequest;
import com.example.midscheduleapp.comment.Dto.CreateCommentResponse;
import com.example.midscheduleapp.comment.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/users/{userId}/schedules/{scheduleId}/comments")
    ResponseEntity<CreateCommentResponse> createComment(
            @PathVariable Long userId,
            @PathVariable Long scheduleId,
            @RequestBody CreateCommentRequest request
            ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                commentService.create(userId, scheduleId, request));
    }




}
