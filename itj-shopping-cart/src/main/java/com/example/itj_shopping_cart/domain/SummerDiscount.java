package com.example.itj_shopping_cart.domain;

public class SummerDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double subtotal) {
        double discount = 0;
        if (subtotal > 500) {
            discount = subtotal * 0.5;
        }
        return discount;
    }
}
