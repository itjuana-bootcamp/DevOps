package com.example.itj_shopping_cart.domain;

public class ShoppingCartCalculator implements SubtotalCalculator {
    private final ShoppingCart shoppingCart;
    private final DiscountProvider discountProvider;

    public ShoppingCartCalculator(ShoppingCart shoppingCart, DiscountProvider discountProvider) {
        this.shoppingCart = shoppingCart;
        this.discountProvider = discountProvider;
    }
    @Override
    public double getSubtotal() {
        double subtotal = 0;
        for (Item item :
                shoppingCart.getItems()) {
            subtotal += item.getPrice() * 2;
        }

        DiscountStrategy discountStrategy = discountProvider.getDiscountStrategy();
        return subtotal - discountStrategy.getDiscount(subtotal);
    }
}
