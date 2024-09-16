package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.model.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("products")
@SessionAttributes("cart")
public class ProductController {
    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping
    public ModelAndView getProducts() {
        ModelAndView modelAndView = new ModelAndView("pages/product/index");
        Iterable<Product> products = productService.findAll();
        modelAndView.addObject("page_title", "Product List");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView viewCreate() {
        ModelAndView modelAndView = new ModelAndView("pages/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("create")
    public String handleCreate(Product product) {
        productService.create(product);
        return "redirect:/products";
    }

    @GetMapping("{id}/view")
    public ModelAndView viewProduct(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("pages/product/view");
        Optional<Product> product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("{id}/add-to-cart")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") Cart cart) {
        Optional<Product> product = productService.findById(id);
        if (product.isEmpty()) {
            return "pages/common/error";
        }

        cart.addProduct(product.get());

        return "redirect:/cart";
    }
}
