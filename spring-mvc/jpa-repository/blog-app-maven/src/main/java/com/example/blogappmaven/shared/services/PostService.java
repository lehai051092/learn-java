package com.example.blogappmaven.shared.services;

import com.example.blogappmaven.model.Category;
import com.example.blogappmaven.model.Post;
import com.example.blogappmaven.repository.ICategoryRepository;
import com.example.blogappmaven.repository.IPostRepository;
import com.example.blogappmaven.shared.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final ICategoryRepository categoryRepository;

    @Autowired
    public PostService(IPostRepository postRepository, ICategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Post> findAll(Pageable pageable, Sort sort, String search, String categoryName) {
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

        if (search != null && !search.isEmpty() && categoryName != null && !categoryName.isEmpty()) {
            Category category = categoryRepository.findByName(categoryName)
                    .orElseThrow(() -> new IllegalArgumentException("Category not found"));
            return postRepository.findByTitleContainingAndCategory(search, category, sortedPageable);
        } else if (search != null && !search.isEmpty()) {
            return postRepository.findByTitleContaining(search, sortedPageable);
        } else if (categoryName != null && !categoryName.isEmpty()) {
            Category category = categoryRepository.findByName(categoryName)
                    .orElseThrow(() -> new IllegalArgumentException("Category not found"));
            return postRepository.findByCategory(category, sortedPageable);
        } else {
            return postRepository.findAllWithCategory(sortedPageable);
        }
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }

    @Override
    public void save(Post post) {
        Category category = categoryRepository.findById(post.getCategory().getId()).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        post.setCategory(category);
        postRepository.save(post);
    }

    @Override
    public void update(Long id, Post post) {
        findById(id);
        Category category = categoryRepository.findById(post.getCategory().getId()).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        post.setCategory(category);
        postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        postRepository.deleteById(id);
    }
}
