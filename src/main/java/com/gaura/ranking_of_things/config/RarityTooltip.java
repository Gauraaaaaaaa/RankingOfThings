package com.gaura.ranking_of_things.config;

public enum RarityTooltip {

    NAME("Name"),
    STARS("⭐");

    private final String displayName;

    RarityTooltip(String displayName) {

        this.displayName = displayName;
    }

    @Override
    public String toString() {

        return displayName;
    }
}