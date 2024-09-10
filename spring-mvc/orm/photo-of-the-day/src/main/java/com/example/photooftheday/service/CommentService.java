package com.example.photooftheday.service;

import com.example.photooftheday.model.Comment;
import com.example.photooftheday.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class CommentService implements ICommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComments() {
        // Lấy ngày hiện tại
        // LocalDate today = LocalDate.now();

        // Lọc danh sách comment chỉ lấy những comment được tạo vào ngày hôm nay
        // return commentRepository.findAll().stream()
        //        .filter(comment -> comment.getCreatedAt().toLocalDate().equals(today))
        //        .collect(Collectors.toList());

        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().atTime(LocalTime.MAX);

        return commentRepository.findByCreatedAtBetween(startOfDay, endOfDay);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid comment ID: " + id));
    }
}
