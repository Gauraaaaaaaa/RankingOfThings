package com.gaura.ranking_of_things.mixin;

import com.gaura.ranking_of_things.CustomRarity;
import com.gaura.ranking_of_things.RankingOfThings;
import com.gaura.ranking_of_things.config.RarityTooltip;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mixin(ItemStack.class)
public class ItemStackMixin {

    @Unique
    private static final Map<Rarity, Integer> rarityLevelMap = new HashMap<>();

    static {
        rarityLevelMap.put(CustomRarity.ONE, 1);
        rarityLevelMap.put(CustomRarity.TWO, 2);
        rarityLevelMap.put(CustomRarity.THREE, 3);
        rarityLevelMap.put(CustomRarity.FOUR, 4);
        rarityLevelMap.put(CustomRarity.FIVE, 5);
        rarityLevelMap.put(CustomRarity.SIX, 6);
        rarityLevelMap.put(CustomRarity.SEVEN, 7);
        rarityLevelMap.put(CustomRarity.EIGHT, 8);
        rarityLevelMap.put(CustomRarity.NINE, 9);
        rarityLevelMap.put(CustomRarity.TEN, 10);
    }

    @Inject(method = "getTooltip", at = @At("RETURN"))
    private void addRarityNameToTooltip(CallbackInfoReturnable<List<Text>> cir) {

        if (RankingOfThings.CONFIG.show_rarity_tooltip) {

            ItemStack stack = (ItemStack) (Object) this;
            List<Text> tooltip = cir.getReturnValue();
            Rarity rarity = stack.getRarity();
            Text rarityText;

            if (RankingOfThings.CONFIG.choose_rarity_tooltip_display == RarityTooltip.STARS) {

                rarityText = Text.literal("⭐".repeat(rarityLevelMap.getOrDefault(rarity, 0))).formatted(rarity.formatting);
                tooltip.add(1, rarityText);
            }
            else if (RankingOfThings.CONFIG.choose_rarity_tooltip_display == RarityTooltip.NAME) {

                rarityText = Text.literal(rarity.toString()).formatted(rarity.formatting);
                tooltip.add(1, rarityText);
            }
        }
    }
}