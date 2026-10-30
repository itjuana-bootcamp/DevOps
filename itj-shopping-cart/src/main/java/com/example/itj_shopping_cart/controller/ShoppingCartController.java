package com.example.itj_shopping_cart.controller;

import com.example.itj_shopping_cart.domain.Item;
import com.example.itj_shopping_cart.domain.ShoppingCart;
import com.example.itj_shopping_cart.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private final ShoppingCartService service;

    public ShoppingCartController(ShoppingCartService service) {
        this.service = service;
    }

    // Create a new cart
    @PostMapping
    public ShoppingCart createCart() {
        return service.createCart();
    }

    // Add an item to an existing cart
    @PostMapping("/{cartId}/items")
    public ShoppingCart addItem(@PathVariable UUID cartId, @RequestBody Item item) {
        return service.addItem(cartId, item);
    }

    // Get subtotal of a cart
    @GetMapping("/{cartId}/subtotal")
    public double getSubtotal(@PathVariable UUID cartId) {
        return service.calculateSubtotal(cartId);
    }
}
