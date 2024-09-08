package com.example.productmanagementthymeleaf.service;

import com.example.productmanagementthymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts(String name);

    void save(Product product);

    void update(int id, Product product);

    void remove(int id);

    Product findById(int id);
}
