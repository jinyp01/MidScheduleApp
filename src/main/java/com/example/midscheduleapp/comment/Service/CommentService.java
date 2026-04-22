package com.example.midscheduleapp.comment.Service;

import com.example.midscheduleapp.comment.Dto.CreateCommentRequest;
import com.example.midscheduleapp.comment.Dto.CreateCommentResponse;
import com.example.midscheduleapp.comment.Entity.Comment;
import com.example.midscheduleapp.comment.Repository.CommentRepository;
import com.example.midscheduleapp.schedule.Entity.Schedule;
import com.example.midscheduleapp.schedule.repository.ScheduleRepository;
import com.example.midscheduleapp.user.Entity.User;
import com.example.midscheduleapp.user.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    // 댓글 작성 메소드
    @Transactional
    public CreateCommentResponse create(Long userId, Long scheduleId, CreateCommentRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("해당하는 유저가 없습니다.")
        );
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("해당하는 일정이 없습니다.")
        );

        Comment comment = new Comment( request.getComtent(), user, schedule );

        return new CreateCommentResponse(
                comment.getId(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }
}
