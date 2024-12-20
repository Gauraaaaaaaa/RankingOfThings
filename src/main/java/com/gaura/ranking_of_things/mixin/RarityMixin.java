package com.gaura.ranking_of_things.mixin;

import com.gaura.ranking_of_things.CustomRarity;
import com.gaura.ranking_of_things.RankingOfThings;
import com.gaura.ranking_of_things.config.RankingOfThingsConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.*;
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

        var one = newRarity(RankingOfThings.CONFIG.one_name, last.ordinal() + 1, RankingOfThings.CONFIG.one_color.getFormatting());
        var two = newRarity(RankingOfThings.CONFIG.two_name, last.ordinal() + 2, RankingOfThings.CONFIG.two_color.getFormatting());
        var three = newRarity(RankingOfThings.CONFIG.three_name, last.ordinal() + 3, RankingOfThings.CONFIG.three_color.getFormatting());
        var four = newRarity(RankingOfThings.CONFIG.four_name, last.ordinal() + 4, RankingOfThings.CONFIG.four_color.getFormatting());
        var five = newRarity(RankingOfThings.CONFIG.five_name, last.ordinal() + 5, RankingOfThings.CONFIG.five_color.getFormatting());
        var six = newRarity(RankingOfThings.CONFIG.six_name, last.ordinal() + 6, RankingOfThings.CONFIG.six_color.getFormatting());
        var seven = newRarity(RankingOfThings.CONFIG.seven_name, last.ordinal() + 7, RankingOfThings.CONFIG.seven_color.getFormatting());
        var eight = newRarity(RankingOfThings.CONFIG.eight_name, last.ordinal() + 8, RankingOfThings.CONFIG.eight_color.getFormatting());
        var nine = newRarity(RankingOfThings.CONFIG.nine_name, last.ordinal() + 9, RankingOfThings.CONFIG.nine_color.getFormatting());
        var ten = newRarity(RankingOfThings.CONFIG.ten_name, last.ordinal() + 10, RankingOfThings.CONFIG.ten_color.getFormatting());

        CustomRarity.ONE = one;
        CustomRarity.TWO = two;
        CustomRarity.THREE = three;
        CustomRarity.FOUR = four;
        CustomRarity.FIVE = five;
        CustomRarity.SIX = six;
        CustomRarity.SEVEN = seven;
        CustomRarity.EIGHT = eight;
        CustomRarity.NINE = nine;
        CustomRarity.TEN = ten;

        rarities.add(one);
        rarities.add(two);
        rarities.add(three);
        rarities.add(four);
        rarities.add(five);
        rarities.add(six);
        rarities.add(seven);
        rarities.add(eight);
        rarities.add(nine);
        rarities.add(ten);

        field_8905 = rarities.toArray(new Rarity[0]);
    }
}