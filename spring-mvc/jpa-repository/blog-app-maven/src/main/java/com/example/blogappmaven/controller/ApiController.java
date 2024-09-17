package com.example.blogappmaven.controller;

import com.example.blogappmaven.model.Category;
import com.example.blogappmaven.model.Post;
import com.example.blogappmaven.model.PostDTO;
import com.example.blogappmaven.shared.interfaces.ICategoryService;
import com.example.blogappmaven.shared.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {
    private final ICategoryService categoryService;
    private final IPostService postService;

    @Autowired
    public ApiController(ICategoryService categoryService, IPostService postService) {
        this.categoryService = categoryService;
        this.postService = postService;
    }

    @GetMapping("categories")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("posts")
    public ResponseEntity<Page<PostDTO>> getPosts(
            Pageable pageable,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String categoryName,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Sort sort = Sort.by(sortBy).ascending();
        Page<Post> posts = postService.findAll(pageable, sort, search, categoryName);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Page<PostDTO> postsDTOPage = posts.map(postService::convertToPostDTO);
        return ResponseEntity.ok(postsDTOPage);
    }

    @GetMapping("posts/category/{id}")
    public ResponseEntity<Page<Post>> getPostByCategoryId(@PathVariable("id") Long id, @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Post> posts = postService.findPostsByCategory(id, pageable);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("posts/{id}")
    public ResponseEntity<Post> getPost(@PathVariable("id") Long id) {
        Post post = postService.findById(id);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
