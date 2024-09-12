package com.example.photooftheday.controller;

import com.example.photooftheday.model.Comment;
import com.example.photooftheday.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CommentController {
    private final ICommentService commentService;

    @Autowired
    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("pages/index");
        List<Comment> comments = commentService.getComments();
        modelAndView.addObject("comments", comments);
        return modelAndView;
    }

    @GetMapping("review")
    public ModelAndView review() {
        ModelAndView modelAndView = new ModelAndView("pages/review");
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }

    @PostMapping("comment")
    public String comment(@ModelAttribute Comment comment, RedirectAttributes redirectAttributes) {
        commentService.save(comment);
        redirectAttributes.addFlashAttribute("success", "Comment created successfully!");
        return "redirect:/";
    }

    @GetMapping("/comment/{id}/like")
    public String likeComment(@PathVariable Long id) {
        Comment comment = commentService.findById(id);
        comment.incrementLikes();
        commentService.save(comment);
        return "redirect:/";
    }
}
