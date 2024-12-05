package com.gaura.ranking_of_things.mixin;

import com.gaura.ranking_of_things.CustomRarity;
import com.gaura.ranking_of_things.RankingOfThings;
import com.gaura.ranking_of_things.config.RarityTooltip;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
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

    @Inject(method = "getRarity", at = @At("RETURN"), cancellable = true)
    public void changeRarity(CallbackInfoReturnable<Rarity> cir) {

        ItemStack stack = (ItemStack) (Object) this;

        if (isItemInList(stack, RankingOfThings.CONFIG.two_list)) {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.THREE : CustomRarity.TWO);
        }
        else if (isItemInList(stack, RankingOfThings.CONFIG.three_list)) {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.FOUR : CustomRarity.THREE);
        }
        else if (isItemInList(stack, RankingOfThings.CONFIG.four_list)) {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.FIVE : CustomRarity.FOUR);
        }
        else if (isItemInList(stack, RankingOfThings.CONFIG.five_list)) {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.SIX : CustomRarity.FIVE);
        }
        else if (isItemInList(stack, RankingOfThings.CONFIG.six_list)) {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.SEVEN : CustomRarity.SIX);
        }
        else if (isItemInList(stack, RankingOfThings.CONFIG.seven_list)) {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.EIGHT : CustomRarity.SEVEN);
        }
        else if (isItemInList(stack, RankingOfThings.CONFIG.eight_list)) {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.NINE : CustomRarity.EIGHT);
        }
        else if (isItemInList(stack, RankingOfThings.CONFIG.nine_list)) {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.TEN : CustomRarity.NINE);
        }
        else if (isItemInList(stack, RankingOfThings.CONFIG.ten_list)) {

            cir.setReturnValue(CustomRarity.TEN);
        }
        else {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.TWO : CustomRarity.ONE);
        }
    }

    @Unique
    private boolean isItemInList(ItemStack stack, String[] list) {

        if (list != null) {

            for (String string : list) {

                if (!string.isEmpty()) {

                    if (stack.getItem() == Registries.ITEM.get(Identifier.of(string))) {

                        return true;
                    }
                }
            }
        }

        return false;
    }

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

                rarityText = Text.literal("⭐".repeat(rarityLevelMap.getOrDefault(rarity, 0))).formatted(rarity.getFormatting());
                tooltip.add(1, rarityText);
            }
            else if (RankingOfThings.CONFIG.choose_rarity_tooltip_display == RarityTooltip.NAME) {

                rarityText = Text.literal(rarity.toString()).formatted(rarity.getFormatting());
                tooltip.add(1, rarityText);
            }
        }
    }
}