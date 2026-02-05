package com.example.itj_shopping_cart.integration;

import com.example.itj_shopping_cart.domain.Item;
import com.example.itj_shopping_cart.domain.SeasonResolver;
import com.example.itj_shopping_cart.domain.DefaultDiscountProvider;
import com.example.itj_shopping_cart.repository.InMemoryShoppingCartRepository;
import com.example.itj_shopping_cart.service.ShoppingCartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingCartServiceIntegrationTest {

    private ShoppingCartService service;

    @BeforeEach
    void setUp() {
        InMemoryShoppingCartRepository repository = new InMemoryShoppingCartRepository();
        SeasonResolver resolver = () -> com.example.itj_shopping_cart.domain.Seasons.WINTER;
        DefaultDiscountProvider discountProvider = new DefaultDiscountProvider(resolver);

        service = new ShoppingCartService(repository, discountProvider);
    }

    @Test
    void whenAddItem_thenSubtotalIncludesDiscount() {
        var cart = service.createCart();
        UUID cartId = cart.getId();

        service.addItem(cartId, new Item("Book", 100.0));

        double subtotal = service.calculateSubtotal(cartId);

        // In Winter, 20% discount should apply
        assertThat(subtotal).isEqualTo(80.0);
    }
}
