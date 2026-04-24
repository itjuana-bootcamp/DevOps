package com.example.itj_shopping_cart.repository;

import com.example.itj_shopping_cart.domain.ShoppingCart;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryShoppingCartRepository {

    private final Map<UUID, ShoppingCart> storage = new ConcurrentHashMap<>();

    public ShoppingCart save(ShoppingCart cart) {
        storage.put(cart.getId(), cart);
        return cart;
    }

    public Optional<ShoppingCart> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    public void deleteById(UUID id) {
        storage.remove(id);
    }
}
