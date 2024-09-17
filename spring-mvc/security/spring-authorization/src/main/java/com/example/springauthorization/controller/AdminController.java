package com.example.springauthorization.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    // Trang dành cho admin
    @GetMapping("/admin")
    public String adminPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("message", "Welcome to the Admin Page!");
        model.addAttribute("username", userDetails.getUsername());
        return "admin_home"; // Trả về template admin.html
    }
}
