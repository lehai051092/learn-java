package com.example.photooftheday.service;

import com.example.photooftheday.model.Comment;

import java.util.List;

public interface ICommentService {
    void save(Comment comment);

    List<Comment> getComments();

    Comment findById(Long id);
}
