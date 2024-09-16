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
@RequestMapping("cart")
public class CartController {
    private final IProductService productService;

    @Autowired
    public CartController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView index(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("pages/cart/index");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("increase/{id}")
    public String increaseQuantity(@PathVariable Long id, @SessionAttribute("cart") Cart cart) {
        Optional<Product> product = productService.findById(id);
        product.ifPresent(cart::addProduct);
        return "redirect:/cart";
    }

    @GetMapping("decrease/{id}")
    public String decreaseQuantity(@PathVariable Long id, @SessionAttribute("cart") Cart cart) {
        Optional<Product> product = productService.findById(id);
        product.ifPresent(cart::decreaseProduct);
        return "redirect:/cart";
    }

    @GetMapping("remove/{id}")
    public String removeItem(@PathVariable Long id, @SessionAttribute("cart") Cart cart) {
        Optional<Product> product = productService.findById(id);
        product.ifPresent(cart::removeProduct);
        return "redirect:/cart";
    }
}
