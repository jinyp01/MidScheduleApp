package com.example.midscheduleapp.comment.Service;

import com.example.midscheduleapp.comment.Dto.CreateCommentRequest;
import com.example.midscheduleapp.comment.Dto.CreateCommentResponse;
import com.example.midscheduleapp.comment.Dto.GetCommentResponse;
import com.example.midscheduleapp.comment.Entity.Comment;
import com.example.midscheduleapp.comment.Repository.CommentRepository;
import com.example.midscheduleapp.schedule.Entity.Schedule;
import com.example.midscheduleapp.schedule.repository.ScheduleRepository;
import com.example.midscheduleapp.user.Entity.User;
import com.example.midscheduleapp.user.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

        Comment comment = commentRepository.save(new Comment( request.getContent(), user, schedule ));

        return new CreateCommentResponse(
                comment.getId(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }

    // 일정에 속한 모든 댓글 검색
    @Transactional(readOnly = true)
    public List<GetCommentResponse> getAll(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("해당하는 일정이 없습니다.")
        );

        // 해당 일정에 속한 모든 댓글들을 List로 만들어 반환
        List<GetCommentResponse> dtos =
                commentRepository.findBySchedule(schedule)
                        .stream()
                        .map(comment ->
                                new GetCommentResponse(
                                comment.getId(),
                                comment.getContent(),
                                comment.getCreatedAt(),
                                comment.getUpdatedAt()))
                        .toList();

        return dtos;

    }
}
