package com.example.springjwt.controller;

import com.example.springjwt.config.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("login")
    public Map<String, String> authenticateUser(@RequestBody Map<String, String> loginRequest) {
        logger.info("Attempting to authenticate user: {}", loginRequest.get("username"));

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.get("username"),
                            loginRequest.get("password")
                    )
            );

            String jwt = jwtUtils.generateToken(authentication.getName());
            logger.info("Generated JWT for user: {}", loginRequest.get("username"));

            Map<String, String> response = new HashMap<>();
            response.put("token", jwt);
            return response;

        } catch (Exception e) {
            logger.error("Authentication failed for user: {}", loginRequest.get("username"), e);
            throw e; // Re-throw to let Spring handle the exception
        }
    }
}
