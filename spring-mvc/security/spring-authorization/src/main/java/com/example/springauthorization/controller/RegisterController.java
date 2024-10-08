package com.example.springauthorization.controller;

import com.example.springauthorization.api.IUserService;
import com.example.springauthorization.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    private final IUserService userService;

    @Autowired
    public RegisterController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Trả về template register.html
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.registerNewUser(user);
        return "redirect:/login"; // Chuyển hướng đến trang login sau khi đăng ký thành công
    }
}
