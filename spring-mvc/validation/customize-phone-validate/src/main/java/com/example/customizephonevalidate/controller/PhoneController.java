package com.example.customizephonevalidate.controller;

import com.example.customizephonevalidate.model.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PhoneController {
    private final PhoneNumberValidator phoneNumberValidator;

    @Autowired
    public PhoneController(PhoneNumberValidator phoneNumberValidator) {
        this.phoneNumberValidator = phoneNumberValidator;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("phoneNumber", new PhoneNumberValidator());
        return "index";
    }

    @PostMapping("/")
    public String checkValidation(@ModelAttribute("phoneNumber") PhoneNumberValidator phoneNumber, BindingResult bindingResult, Model model) {
        phoneNumberValidator.validate(phoneNumber, bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            model.addAttribute("phoneNumber", phoneNumber);
            return "result";
        }
    }
}
