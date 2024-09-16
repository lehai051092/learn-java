package com.example.customermanageaspect.controller;

import com.example.customermanageaspect.model.Customer;
import com.example.customermanageaspect.model.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("pages/index");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("pageTitle", "Customer List");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("pages/create");
        modelAndView.addObject("pageTitle", "Customer Create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("create")
    public String handleCreate(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.create(customer);
        redirectAttributes.addFlashAttribute("message", "Customer created successfully!");
        return "redirect:/customers";
    }

    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("pages/edit");
        modelAndView.addObject("pageTitle", "Customer Edit");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("update")
    public String handleUpdate(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.update(customer.getId(), customer);
        redirectAttributes.addFlashAttribute("message", "Customer updated successfully!");
        return "redirect:/customers";
    }

    @GetMapping("{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("pages/delete");
        modelAndView.addObject("pageTitle", "Customer Delete");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("delete")
    public String handleDelete(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message", "Customer deleted successfully!");
        return "redirect:/customers";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView showException() {
        return new ModelAndView("pages/exception");
    }
}
