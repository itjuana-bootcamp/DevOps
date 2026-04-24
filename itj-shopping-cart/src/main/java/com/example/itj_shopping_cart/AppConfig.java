package com.example.itj_shopping_cart;

import com.example.itj_shopping_cart.domain.DefaultDiscountProvider;
import com.example.itj_shopping_cart.domain.DefaultSeasonResolver;
import com.example.itj_shopping_cart.domain.DiscountProvider;
import com.example.itj_shopping_cart.domain.SeasonResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class AppConfig {

    @Bean
    public Clock clock() {
        // Provides current system time by default
        return Clock.systemDefaultZone();
    }

    @Bean
    public SeasonResolver seasonResolver(Clock clock) {
        return new DefaultSeasonResolver(clock);
    }

    @Bean
    public DiscountProvider discountProvider(SeasonResolver seasonResolver) {
        return new DefaultDiscountProvider(seasonResolver);
    }
}
