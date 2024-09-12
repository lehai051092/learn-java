package com.example.blogappmaven.controller;

import com.example.blogappmaven.model.Post;
import com.example.blogappmaven.shared.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("posts")
public class PostController {
    private final IPostService postService;

    @Autowired
    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ModelAndView getPosts() {
        ModelAndView modelAndView = new ModelAndView("pages/index");
        Iterable<Post> posts = postService.findAll();
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }
}
