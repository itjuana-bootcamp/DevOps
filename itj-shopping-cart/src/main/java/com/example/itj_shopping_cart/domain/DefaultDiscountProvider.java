package com.example.itj_shopping_cart.domain;

public class DefaultDiscountProvider implements DiscountProvider {
    private final SeasonResolver seasonResolver;

    public DefaultDiscountProvider(SeasonResolver seasonResolver) {
        this.seasonResolver = seasonResolver;
    }

    @Override
    public DiscountStrategy getDiscountStrategy() {
        return switch (seasonResolver.resolveSeason()) {
            case WINTER -> new WinterDiscount();
            case SUMMER -> new SummerDiscount();
            case OTHER -> new DefaultDiscount();
        };
    }
}
