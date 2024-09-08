package com.example.productmanagementthymeleaf.service;

import com.example.productmanagementthymeleaf.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Product 1", 21.0));
        products.put(2, new Product(2, "Product 2", 20.0));
        products.put(3, new Product(3, "Product 3", 50.0));
        products.put(4, new Product(4, "Product 4", 99.0));
        products.put(5, new Product(5, "Product 5", 15.0));
    }

    @Override
    public List<Product> getProducts(String name) {
        List<Product> productList = new ArrayList<>(products.values());
        if (name == null || name.isEmpty()) {
            return productList;
        }

        return productList.stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase().trim()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }
}
