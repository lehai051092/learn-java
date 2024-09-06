package com.example.currencyconverter.controller;

import com.example.currencyconverter.model.ConversionResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyConverter {
    @GetMapping("/")
    public ModelAndView showCurrencyConverter() {
        return new ModelAndView("index");
    }

    @PostMapping("/convert")
    public ModelAndView convert(@RequestParam("rate") double rate, @RequestParam("usd") double usd) {
        double vnd = rate * usd;

        ConversionResult result = new ConversionResult(usd, vnd, rate);

        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("conversionResult", result);

        return modelAndView;
    }
}
