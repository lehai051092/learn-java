package com.example.photooftheday.repository;

import com.example.photooftheday.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByCreatedAtBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
}
