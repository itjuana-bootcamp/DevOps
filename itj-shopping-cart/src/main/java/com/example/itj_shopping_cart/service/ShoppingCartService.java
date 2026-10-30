package com.example.itj_shopping_cart.service;

import com.example.itj_shopping_cart.domain.*;
import com.example.itj_shopping_cart.repository.InMemoryShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.UUID;

@Service
public class ShoppingCartService {
    private final InMemoryShoppingCartRepository repository;
    private final DiscountProvider discountProvider;

    public ShoppingCartService(InMemoryShoppingCartRepository repository,
                               DiscountProvider discountProvider) {
        this.repository = repository;
        this.discountProvider = discountProvider;
    }

    public ShoppingCart createCart() {
        ShoppingCart cart = new ShoppingCart();
        return repository.save(cart);
    }

    public ShoppingCart addItem(UUID cartId, Item item) {
        ShoppingCart cart = repository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found"));
        cart.addItem(item);
        return repository.save(cart);
    }

    public double calculateSubtotal(UUID cartId) {
        ShoppingCart cart = repository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found"));
        ShoppingCartCalculator shoppingCartCalculator = new ShoppingCartCalculator(cart, discountProvider);
        return shoppingCartCalculator.getSubtotal();
    }
}
