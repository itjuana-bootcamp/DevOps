package com.example.itj_shopping_cart.domain;

public class WinterDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double subtotal) {
        return subtotal * 0.20;
    }
}

