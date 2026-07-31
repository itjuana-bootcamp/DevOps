package com.example.itj_shopping_cart.domain;

public class DefaultDiscount implements DiscountStrategy {

    @Override
    public double getDiscount(double subtotal) {
        double discount = 0;
        if (subtotal > 300) {
            discount = subtotal * 0.5;
        } else if (subtotal > 200) {
            discount = subtotal * 0.1;
        }
        return discount;
    }
}
