package com.example.managementcustomers.controller;

import com.example.managementcustomers.model.Customer;
import com.example.managementcustomers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ModelAndView showCustomerList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.getAllCustomers();
        modelAndView.addObject("customerList", customers);
        return modelAndView;
    }

    @GetMapping("customers/{id}")
    public ModelAndView viewCustomer(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("customers/form");
        Customer customer = customerService.getCustomerById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("customers/{id}")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:/";
    }
}
