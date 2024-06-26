package com.gaura.ranking_of_things.mixin;

import com.gaura.ranking_of_things.CustomRarity;
import com.gaura.ranking_of_things.RankingOfThings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "getRarity", at = @At("RETURN"), cancellable = true)
    public void changeRarity(ItemStack stack, CallbackInfoReturnable<Rarity> cir) {

        if (isItemInList(stack, RankingOfThings.CONFIG.uncommon_list)) {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.RARE : CustomRarity.UNCOMMON);
        }
        else if (isItemInList(stack, RankingOfThings.CONFIG.rare_list)) {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.EPIC : CustomRarity.RARE);
        }
        else if (isItemInList(stack, RankingOfThings.CONFIG.epic_list)) {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.LEGENDARY : CustomRarity.EPIC);
        }
        else if (isItemInList(stack, RankingOfThings.CONFIG.legendary_list)) {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.MYTHIC : CustomRarity.LEGENDARY);
        }
        else if (isItemInList(stack, RankingOfThings.CONFIG.mythic_list)) {

            cir.setReturnValue(CustomRarity.MYTHIC);
        }
        else {

            cir.setReturnValue((stack.hasEnchantments() && RankingOfThings.CONFIG.enchantment_rarity) ? CustomRarity.UNCOMMON : CustomRarity.COMMON);
        }
    }

    private boolean isItemInList(ItemStack stack, String[] list) {

        for (String string : list) {

            if (!string.isEmpty()) {

                if (stack.getItem() == Registries.ITEM.get(new Identifier(string))) {

                    return true;
                }
            }
        }

        return false;
    }
}