package com.gaura.ranking_of_things.config;

import net.minecraft.util.Formatting;

public enum FormattingColorName {

    BLACK(Formatting.BLACK, "§0BLACK"),
    DARK_BLUE(Formatting.DARK_BLUE, "§1DARK_BLUE"),
    DARK_GREEN(Formatting.DARK_GREEN, "§2DARK_GREEN"),
    DARK_AQUA(Formatting.DARK_AQUA, "§3DARK_AQUA"),
    DARK_RED(Formatting.DARK_RED, "§4DARK_RED"),
    DARK_PURPLE(Formatting.DARK_PURPLE, "§5DARK_PURPLE"),
    GOLD(Formatting.GOLD, "§6GOLD"),
    GRAY(Formatting.GRAY, "§7GRAY"),
    DARK_GRAY(Formatting.DARK_GRAY, "§8DARK_GRAY"),
    BLUE(Formatting.BLUE, "§9BLUE"),
    GREEN(Formatting.GREEN, "§aGREEN"),
    AQUA(Formatting.AQUA, "§bAQUA"),
    RED(Formatting.RED, "§cRED"),
    LIGHT_PURPLE(Formatting.LIGHT_PURPLE, "§dLIGHT_PURPLE"),
    YELLOW(Formatting.YELLOW, "§eYELLOW"),
    WHITE(Formatting.WHITE, "§fWHITE");

    private final Formatting formatting;
    private final String displayName;

    FormattingColorName(Formatting formatting, String displayName) {

        this.formatting = formatting;
        this.displayName = displayName;
    }

    public Formatting getFormatting() {

        return formatting;
    }

    @Override
    public String toString() {

        return displayName;
    }
}
