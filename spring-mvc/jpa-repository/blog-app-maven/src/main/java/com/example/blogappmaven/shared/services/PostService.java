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
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void update(Long id, Post post) {
        postRepository.findById(id).map(object -> {
            object.setTitle(post.getTitle());
            object.setSummary(post.getSummary());
            object.setContent(post.getContent());
            object.setUpdatedAt(LocalDateTime.now());
            return postRepository.save(object);
        }).orElseGet(() -> {
            post.setId(id);
            return postRepository.save(post);
        });
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
