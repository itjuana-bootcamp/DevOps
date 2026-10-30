package com.example.itj_shopping_cart.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCart {
    private final UUID id;
    private final List<Item> items = new ArrayList<>();

    public ShoppingCart() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void clearItems() {
        items.clear();
    }

    public int getItemCount() {
       return items.size();
    }

    public List<Item> getItems() {
        return List.copyOf(items);
    }
}
