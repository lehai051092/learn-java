package com.example.productmanagementthymeleaf.controller;

import com.example.productmanagementthymeleaf.model.Product;
import com.example.productmanagementthymeleaf.service.IProductService;
import com.example.productmanagementthymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("products")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public ModelAndView index(@RequestParam(value = "name", required = false) String name) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.getProducts(name));
        modelAndView.addObject("searchName", name);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("pages/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId(productService.getProducts(null).size() + 1);
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Product created successfully!");
        return "redirect:/products";
    }

    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("pages/edit");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("success", "Product updated successfully!");
        return "redirect:/products";
    }

    @GetMapping("{id}/delete")
    public ModelAndView delete(@PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("pages/delete");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("remove")
    public String remove(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success", "Product deleted successfully!");
        return "redirect:/products";
    }

    @GetMapping("{id}/view")
    public ModelAndView view(@PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("pages/view");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }
}
