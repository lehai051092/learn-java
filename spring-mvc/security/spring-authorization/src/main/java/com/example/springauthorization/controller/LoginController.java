package com.example.springauthorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    // Trang đăng nhập
    @GetMapping("/login")
    public String login() {
        return "login"; // Trả về template login.html
    }
}
