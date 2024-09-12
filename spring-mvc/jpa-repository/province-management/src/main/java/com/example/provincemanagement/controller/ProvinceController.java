package com.example.provincemanagement.controller;

import com.example.provincemanagement.model.Customer;
import com.example.provincemanagement.model.Province;
import com.example.provincemanagement.service.interfaces.ICustomerService;
import com.example.provincemanagement.service.interfaces.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("provinces")
public class ProvinceController {
    private final IProvinceService provinceService;
    private final ICustomerService customerService;

    @Autowired
    public ProvinceController(IProvinceService provinceService, ICustomerService customerService) {
        this.provinceService = provinceService;
        this.customerService = customerService;
    }

    @GetMapping
    public ModelAndView getProvinces() {
        ModelAndView modelAndView = new ModelAndView("province/list");
        Iterable<Province> provinces = provinceService.findAll();
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView createProvinceForm() {
        ModelAndView modelAndView = new ModelAndView("province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("create")
    public String createProvince(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes) {
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Create new province successfully");
        return "redirect:/provinces";
    }

    @GetMapping("update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("province/update");
            modelAndView.addObject("province", province.get());
            return modelAndView;
        } else {
            return new ModelAndView("error_404");
        }
    }

    @PostMapping("update/{id}")
    public String update(@ModelAttribute("province") Province province, RedirectAttributes redirect) {
        provinceService.save(province);
        redirect.addFlashAttribute("message", "Update province successfully");
        return "redirect:/provinces";
    }

    @GetMapping("view-province/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Province> provinceOptional = provinceService.findById(id);
        if(provinceOptional.isEmpty()){
            return new ModelAndView("/error_404");
        }

        Iterable<Customer> customers = customerService.findAllByProvince(provinceOptional.get());

        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
