package com.example.springsaveusername.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.springsaveusername.model.User;

@Controller
@SessionAttributes("user")
public class LoginController {

    // Add user in model attribute
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("login")
    public String index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        // Add the cookie's value to the model if it exists
        model.addAttribute("cookieValue", setUser);
        return "login";
    }

    @PostMapping("doLogin")
    public String doLogin(
            @ModelAttribute("user") User user,
            Model model,
            HttpServletResponse response
    ) {
        // Implement business logic
        if ("admin@gmail.com".equals(user.getEmail()) && "123456".equals(user.getPassword())) {
            // If login is successful, set the user email in a cookie
            String setUser = user.getEmail();
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60); // 1 day
            response.addCookie(cookie);

            // Add the email to the model for displaying in the form
            model.addAttribute("cookieValue", setUser);
            model.addAttribute("message", "Login success. Welcome!");
        } else {
            // Login failed
            user.setEmail(""); // Clear the email field
            model.addAttribute("cookieValue", ""); // Clear the cookieValue in the model
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "login";
    }
}
