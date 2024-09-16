package com.example.shoppingcart.model.interfaces;

import com.example.shoppingcart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    void create(Product product);
}
