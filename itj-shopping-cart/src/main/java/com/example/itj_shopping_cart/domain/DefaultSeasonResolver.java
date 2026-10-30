package com.example.itj_shopping_cart.domain;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;

public class DefaultSeasonResolver implements SeasonResolver {
    private final Clock clock;

    public DefaultSeasonResolver(Clock clock) {
        this.clock = clock;
    }

    @Override
    public Seasons resolveSeason() {
        LocalDate today = LocalDate.now(clock);
        Month month = today.getMonth();

        return switch (month) {
            case DECEMBER, JANUARY, FEBRUARY -> Seasons.WINTER;
            case JUNE, JULY, AUGUST -> Seasons.SUMMER;
            default -> Seasons.OTHER;
        };
    }
}
