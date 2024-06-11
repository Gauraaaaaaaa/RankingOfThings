package com.gaura.ranking_of_things.mixin;

import com.gaura.ranking_of_things.CustomRarity;
import com.gaura.ranking_of_things.RankingOfThings;
import com.gaura.ranking_of_things.config.RankingOfThingsConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(Rarity.class)
public abstract class RarityMixin {

    private static void registerConfig() {

        AutoConfig.register(RankingOfThingsConfig.class, JanksonConfigSerializer::new);
        RankingOfThings.CONFIG = AutoConfig.getConfigHolder(RankingOfThingsConfig.class).getConfig();
    }

    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static Rarity newRarity(String internalName, int internalId, Formatting formatting) {

        throw new AssertionError();
    }

    @SuppressWarnings("ShadowTarget")
    @Shadow
    @Final
    @Mutable
    private static Rarity[] field_8905;

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC, target = "Lnet/minecraft/util/Rarity;field_8905:[Lnet/minecraft/util/Rarity;", shift = At.Shift.AFTER))
    private static void addCustomRarity(CallbackInfo ci) {

        registerConfig();

        var rarities = new ArrayList<>(Arrays.asList(field_8905));
        var last = rarities.get(rarities.size() - 1);

        var common = newRarity("COMMON", last.ordinal() + 1, RankingOfThings.CONFIG.common_color.getFormatting());
        var uncommon = newRarity("UNCOMMON", last.ordinal() + 2, RankingOfThings.CONFIG.uncommon_color.getFormatting());
        var rare = newRarity("RARE", last.ordinal() + 3, RankingOfThings.CONFIG.rare_color.getFormatting());
        var epic = newRarity("EPIC", last.ordinal() + 4, RankingOfThings.CONFIG.epic_color.getFormatting());
        var legendary = newRarity("LEGENDARY", last.ordinal() + 5, RankingOfThings.CONFIG.legendary_color.getFormatting());
        var mythic = newRarity("MYTHIC", last.ordinal() + 6, RankingOfThings.CONFIG.mythic_color.getFormatting());

        CustomRarity.COMMON = common;
        CustomRarity.UNCOMMON = uncommon;
        CustomRarity.RARE = rare;
        CustomRarity.EPIC = epic;
        CustomRarity.LEGENDARY = legendary;
        CustomRarity.MYTHIC = mythic;

        rarities.add(common);
        rarities.add(uncommon);
        rarities.add(rare);
        rarities.add(epic);
        rarities.add(legendary);
        rarities.add(mythic);

        field_8905 = rarities.toArray(new Rarity[0]);
    }
}