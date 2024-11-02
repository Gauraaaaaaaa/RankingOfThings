package com.gaura.ranking_of_things.mixin;

import com.gaura.ranking_of_things.CustomRarity;
import com.gaura.ranking_of_things.RankingOfThings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "getRarity", at = @At("RETURN"), cancellable = true)
    public void changeRarity(ItemStack stack, CallbackInfoReturnable<Rarity> cir) {

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

                    if (stack.getItem() == Registries.ITEM.get(new Identifier(string))) {

                        return true;
                    }
                }
            }
        }

        return false;
    }
}