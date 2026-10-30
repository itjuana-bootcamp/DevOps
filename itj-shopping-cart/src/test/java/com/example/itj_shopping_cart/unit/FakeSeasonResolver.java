package com.example.itj_shopping_cart.unit;

import com.example.itj_shopping_cart.domain.*;

public class FakeSeasonResolver implements SeasonResolver {
    private Seasons currentSeason = Seasons.WINTER;
    @Override
    public Seasons resolveSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(Seasons currentSeason) {
        this.currentSeason = currentSeason;
    }
}
