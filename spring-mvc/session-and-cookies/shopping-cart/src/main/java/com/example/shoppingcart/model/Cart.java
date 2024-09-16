package com.example.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public Cart() {}

    private CartItem findCartItem(Long productId) {
        for (CartItem item : items) {
            if (item.getProduct().getId().equals(productId)) {
                return item;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        CartItem cartItem = findCartItem(product.getId());
        if (cartItem != null) {
            cartItem.increaseQuantity();
        } else {
            items.add(new CartItem(product, 1));
        }
    }

    public void decreaseProduct(Product product) {
        CartItem cartItem = findCartItem(product.getId());
        if (cartItem != null) {
            cartItem.decreaseQuantity();
            if (cartItem.getQuantity() <= 0) {
                items.remove(cartItem);
            }
        }
    }

    public void removeProduct(Product product) {
        CartItem cartItem = findCartItem(product.getId());
        if (cartItem != null) {
            items.remove(cartItem);
        }
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}
