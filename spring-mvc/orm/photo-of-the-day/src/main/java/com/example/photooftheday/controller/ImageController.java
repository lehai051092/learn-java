package com.example.photooftheday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {
    @GetMapping
    public String index() {
        return "index";
    }
}
