package com.example.blogappmaven.shared.services;

import com.example.blogappmaven.model.Post;
import com.example.blogappmaven.repository.IPostRepository;
import com.example.blogappmaven.shared.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PostService implements IPostService {
    private final IPostRepository postRepository;

    @Autowired
    public PostService(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void update(Long id, Post post) {
        findById(id);
        postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
