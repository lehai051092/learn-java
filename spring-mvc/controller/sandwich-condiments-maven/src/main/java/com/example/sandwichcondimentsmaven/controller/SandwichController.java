package com.example.sandwichcondimentsmaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class SandwichController {
    List<String> allCondiments = Arrays.asList("Lettuce", "Tomato", "Mustard", "Sprouts");

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("allCondiments", allCondiments);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestParam(value = "condiment", required = false) String[] condiments) {
        if (condiments == null || condiments.length == 0) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("allCondiments", allCondiments);
        modelAndView.addObject("selectedCondiments", Arrays.asList(condiments));

        return modelAndView;
    }
}
