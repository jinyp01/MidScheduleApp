package com.example.midscheduleapp.comment.Repository;

import com.example.midscheduleapp.comment.Entity.Comment;
import com.example.midscheduleapp.schedule.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findBySchedule(Schedule schedule);
}
