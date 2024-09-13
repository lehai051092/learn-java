package com.example.blogappmaven.controller;

import com.example.blogappmaven.model.Category;
import com.example.blogappmaven.model.Post;
import com.example.blogappmaven.shared.interfaces.ICategoryService;
import com.example.blogappmaven.shared.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("posts")
public class PostController {
    private final IPostService postService;
    private final ICategoryService categoryService;

    @Autowired
    public PostController(IPostService postService, ICategoryService categoryService) {
        this.postService = postService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("categories")
    public Iterable<Category> listCategories() {
        return categoryService.findAll();
    }

    @GetMapping
    public ModelAndView getPosts(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "category_name", required = false) String categoryName
    ) {
        Pageable pageable = PageRequest.of(page, 2);
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");

        Page<Post> posts = postService.findAll(pageable, sort, search, categoryName);

        posts.forEach(post -> {
            System.out.println("Post Title: " + post.getTitle());
            System.out.println("Category: " + (post.getCategory() != null ? post.getCategory().getName() : "No Category"));
        });

        ModelAndView modelAndView = new ModelAndView("pages/index");
        modelAndView.addObject("posts", posts);
        modelAndView.addObject("search", search);
        modelAndView.addObject("category_name", categoryName);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView getCreateForm() {
        ModelAndView modelAndView = new ModelAndView("pages/post/create-post");
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
        ModelAndView modelAndView = new ModelAndView("pages/post/edit-post");
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
        ModelAndView modelAndView = new ModelAndView("pages/post/remove-post");
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
        ModelAndView modelAndView = new ModelAndView("pages/post/view-post");
        Post post = postService.findById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }
}
