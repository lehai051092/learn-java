package com.example.provincemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ProvinceManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvinceManagementApplication.class, args);
    }

}
