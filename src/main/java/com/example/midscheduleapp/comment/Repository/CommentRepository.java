package com.example.midscheduleapp.comment.Repository;

import com.example.midscheduleapp.comment.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
