package com.example.springinternationalize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringInternationalizeApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringInternationalizeApplication.class, args);
    }

}
