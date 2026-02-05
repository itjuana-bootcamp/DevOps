package com.example.itj_shopping_cart.unit;

import org.junit.jupiter.api.Test;
import com.example.itj_shopping_cart.domain.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Cart Management
 *
 * A new cart starts empty
 * Add products with name and price
 * Remove products from the cart
 * Empty the cart
 * Return number of items and subtotal
 */
public class ShoppingCartTests {

    //  * A new cart starts empty
    @Test
    public void whenCreatingAShoppingCart_ThenReturnEmptyItems() {
        // Arrange
        ShoppingCart shoppingCart = buildShoppingCart();

        // Act
        int itemCount = shoppingCart.getItemCount();

        // Assert
        assertEquals(0, itemCount);
    }


    // * Add products with name and price
    @Test
    public void whenAddingItemsToShopping_ThenReturnNumberOfItems() {
        // Arrange
        ShoppingCart shoppingCart = buildShoppingCart();
        Item item = new Item("Keyboard", 200);

        // Act
        shoppingCart.addItem(item);
        int itemCount = shoppingCart.getItemCount();

        // Assert
        assertEquals(1, itemCount);
    }

     // * Remove products from the cart
    @Test
    public void whenRemovingAnItem_thenTheItemCountIsDown() {
        // Arrange
        ShoppingCart shoppingCart = buildShoppingCart();
        Item item = new Item("Keyboard", 200);
        Item item2 = new Item("Mouse", 200);

        shoppingCart.addItem(item);
        shoppingCart.addItem(item2);

        // Act
        shoppingCart.removeItem(item);
        int itemCount = shoppingCart.getItemCount();

        // Assert
        assertEquals(1, itemCount);
    }

    // * Empty the cart
    @Test
    public void whenClearingShoppingCart_ThenShoppingCartReturnsEmpty() {
        // Arrange
        ShoppingCart shoppingCart = buildShoppingCart();
        Item item = new Item("Keyboard", 200);
        Item item2 = new Item("Mouse", 200);

        shoppingCart.addItem(item);
        shoppingCart.addItem(item2);

        // Act
        shoppingCart.clearItems();
        int itemCount = shoppingCart.getItemCount();

        // Assert
        assertEquals(0, itemCount);
    }

    //  * Return number of items and subtotal

    private ShoppingCart buildShoppingCart() {
        return new ShoppingCart();
    }
}

// YAGNI -> Youn aint gonna need it
// DRY -> Dont repeat yourself
// KISS -> Keep it simple stupid
