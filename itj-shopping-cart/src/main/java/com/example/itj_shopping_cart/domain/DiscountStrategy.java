package com.example.itj_shopping_cart.domain;

public interface DiscountStrategy {
    double getDiscount(double subtotal);
}
