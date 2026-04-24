package com.example.itj_shopping_cart.unit;

import com.example.itj_shopping_cart.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartCalculatorTests {
    /**
     * Discounts
     *
     * 10% off if subtotal > 200
     * 20% off if subtotal > 300
     * 30% off all orders in winter
     * 50% off orders > 500 in summer
     * Discounts can be combined (subtotal + seasonal)
     */
    @Test
    void createShoppingCart_whenCalculatingSubtotal_ReturnsZero() {

        // Arrange
        ShoppingCart shoppingCart = new ShoppingCart();

        FakeSeasonResolver seasonResolver = new FakeSeasonResolver();
        seasonResolver.setCurrentSeason(Seasons.OTHER);
        ShoppingCartCalculator shoppingCartCalculator = buildShoppingCartCalculator(shoppingCart, seasonResolver);

        // Act
        double subtotal = shoppingCartCalculator.getSubtotal();

        // Assert
        assertEquals(0, subtotal);
    }
    @Test
    public void getSubtotal_whenCreatingShoppingCart_ReturnsSubtotal() {
        // Arrange
        ShoppingCart shoppingCart = buildShoppingCart();

        FakeSeasonResolver seasonResolver = new FakeSeasonResolver();
        seasonResolver.setCurrentSeason(Seasons.OTHER);
        ShoppingCartCalculator shoppingCartCalculator = buildShoppingCartCalculator(shoppingCart, seasonResolver);

        // Act
        double subtotal = shoppingCartCalculator.getSubtotal();

        // Assert
        assertEquals(0, subtotal);
    }

    @Test
    public void getSubtotal_whenAddingTwoItems_ReturnsSubtotal() {
        // Arrange
        ShoppingCart shoppingCart = buildShoppingCart();
        Item item = new Item("Keyboard", 50);
        Item item2 = new Item("Mouse", 50);

        shoppingCart.addItem(item);
        shoppingCart.addItem(item2);

        FakeSeasonResolver seasonResolver = new FakeSeasonResolver();
        seasonResolver.setCurrentSeason(Seasons.OTHER);
        ShoppingCartCalculator shoppingCartCalculator = buildShoppingCartCalculator(shoppingCart, seasonResolver);

        // Act
        double subtotal = shoppingCartCalculator.getSubtotal();

        // Assert
        assertEquals(100, subtotal);
    }

    @Test
    void getSubtotal_whenGreaterThan200_ReturnSubtotalWith10PercentDiscount() {
        // Arrange
        ShoppingCart shoppingCart = buildShoppingCart();
        Item item = new Item("Keyboard", 100);
        Item item2 = new Item("Mouse", 150);

        shoppingCart.addItem(item);
        shoppingCart.addItem(item2);

        FakeSeasonResolver seasonResolver = new FakeSeasonResolver();
        seasonResolver.setCurrentSeason(Seasons.OTHER);
        ShoppingCartCalculator shoppingCartCalculator = buildShoppingCartCalculator(shoppingCart, seasonResolver);

        // Act
        double subtotal = shoppingCartCalculator.getSubtotal();

        // Assert
        assertEquals(225, subtotal);
    }

    @Test
    void getSubtotal_whenGreaterThan300_ReturnSubtotalWith20PercentDiscount() {
        // Arrange
        ShoppingCart shoppingCart = buildShoppingCart();
        Item item = new Item("Keyboard", 200);
        Item item2 = new Item("Mouse", 200);

        shoppingCart.addItem(item);
        shoppingCart.addItem(item2);

        FakeSeasonResolver seasonResolver = new FakeSeasonResolver();
        seasonResolver.setCurrentSeason(Seasons.OTHER);
        ShoppingCartCalculator shoppingCartCalculator = buildShoppingCartCalculator(shoppingCart, seasonResolver);

        // Act
        double subtotal = shoppingCartCalculator.getSubtotal();

        // Assert
        assertEquals(320, subtotal);
    }

    @Test
    void getSubtotal_whenWinter_ReturnSubtotalWith30PercentDiscount() {
        // Arrange
        ShoppingCart shoppingCart = buildShoppingCart();
        Item item = new Item("Keyboard", 200);
        Item item2 = new Item("Mouse", 200);

        shoppingCart.addItem(item);
        shoppingCart.addItem(item2);

        FakeSeasonResolver seasonResolver = new FakeSeasonResolver();
        seasonResolver.setCurrentSeason(Seasons.WINTER);
        ShoppingCartCalculator shoppingCartCalculator = buildShoppingCartCalculator(shoppingCart, seasonResolver);

        // Act
        double subtotal = shoppingCartCalculator.getSubtotal();

        // Assert
        assertEquals(320, subtotal);
    }

    @Test
    void getSubtotal_whenSummerAndGreaterThan500_ReturnSubtotalWith50PercentDiscount() {
        // Arrange
        ShoppingCart shoppingCart = buildShoppingCart();
        Item item = new Item("Keyboard", 300);
        Item item2 = new Item("Mouse", 300);

        shoppingCart.addItem(item);
        shoppingCart.addItem(item2);

        FakeSeasonResolver seasonResolver = new FakeSeasonResolver();
        seasonResolver.setCurrentSeason(Seasons.SUMMER);

        ShoppingCartCalculator shoppingCartCalculator = buildShoppingCartCalculator(shoppingCart, seasonResolver);

        // Act
        double subtotal = shoppingCartCalculator.getSubtotal();

        // Assert
        assertEquals(300, subtotal);
    }

    private ShoppingCart buildShoppingCart() {
        return new ShoppingCart();
    }

    private ShoppingCartCalculator buildShoppingCartCalculator(ShoppingCart shoppingCart, SeasonResolver seasonResolver) {
        return new ShoppingCartCalculator(shoppingCart ,new DefaultDiscountProvider(seasonResolver));
    }
}
