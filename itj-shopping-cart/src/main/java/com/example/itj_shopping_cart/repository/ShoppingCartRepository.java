package com.example.itj_shopping_cart.repository;

import com.example.itj_shopping_cart.domain.ShoppingCart;

import java.util.Optional;
import java.util.UUID;

public interface ShoppingCartRepository {
    ShoppingCart save(ShoppingCart cart);
    Optional<ShoppingCart> findById(UUID id);
    void deleteById(UUID id);
}
