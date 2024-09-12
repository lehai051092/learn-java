package com.example.blogappmaven.controller;

import com.example.blogappmaven.model.Post;
import com.example.blogappmaven.shared.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
        modelAndView.addObject("message", "");
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView getCreateForm() {
        ModelAndView modelAndView = new ModelAndView("pages/components/create-post");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("create")
    public String handleCreatePost(Post post, RedirectAttributes redirectAttributes) {
        postService.save(post);
        redirectAttributes.addFlashAttribute("message", "Post created successfully!");
        return "redirect:/posts";
    }

    @GetMapping("{id}/edit")
    public ModelAndView getEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("pages/components/edit-post");
        Post post = postService.findById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @PostMapping("update")
    public String handleUpdatePost(Post post, RedirectAttributes redirectAttributes) {
        postService.update(post.getId(), post);
        redirectAttributes.addFlashAttribute("message", "Post updated successfully!");
        return "redirect:/posts";
    }

    @GetMapping("{id}/delete")
    public ModelAndView getDeleteForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("pages/components/remove-post");
        Post post = postService.findById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @PostMapping("delete")
    public String handleDeletePost(Post post, RedirectAttributes redirectAttributes) {
        postService.delete(post.getId());
        redirectAttributes.addFlashAttribute("message", "Post deleted successfully!");
        return "redirect:/posts";
    }

    @GetMapping("{id}/view")
    public ModelAndView getViewForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("pages/components/view-post");
        Post post = postService.findById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }
}
