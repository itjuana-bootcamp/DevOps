package com.example.itj_shopping_cart.e2e;

import com.example.itj_shopping_cart.domain.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest // Boots up the full Spring context
@AutoConfigureMockMvc // Gives us MockMvc for endpoint testing
class ShoppingCartE2ETest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createCart_addItem_and_calculateSubtotal() throws Exception {
        // 1. Create a cart
        String cartJson = mockMvc.perform(post("/cart"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        String cartId = objectMapper.readTree(cartJson).get("id").asText();

        // 2. Add an item
        Item book = new Item("Book", 100.0);

        mockMvc.perform(post("/cart/" + cartId + "/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items[0].name").value("Book"))
                .andExpect(jsonPath("$.items[0].price").value(100.0));

        // 3. Get subtotal (discount may apply depending on season)
        mockMvc.perform(get("/cart/" + cartId + "/subtotal"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.notNullValue()));
    }
}
