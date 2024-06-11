package com.gaura.ranking_of_things.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

import java.util.List;

@Config(name = "ranking_of_things")
@Config.Gui.Background("minecraft:textures/block/light_gray_wool.png")
public class RankingOfThingsConfig implements ConfigData {

    @ConfigEntry.Category("common")
    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public FormattingColorName common_color = FormattingColorName.WHITE;

    @ConfigEntry.Category("common")
    @Comment("If items with enchantments should have their rarity upgraded by one level.")
    public boolean enchantment_rarity = true;

    @ConfigEntry.Category("uncommon")
    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public FormattingColorName uncommon_color = FormattingColorName.GREEN;

    @ConfigEntry.Category("uncommon")
    public List<String> uncommon_list = List.of("minecraft:potion", "minecraft:splash_potion", "minecraft:lingering_potion",
            "minecraft:tipped_arrow", "minecraft:iron_ingot", "minecraft:raw_iron", "minecraft:iron_sword", "minecraft:iron_axe",
            "minecraft:iron_pickaxe", "minecraft:iron_shovel", "minecraft:iron_hoe", "minecraft:iron_nugget", "minecraft:iron_helmet",
            "minecraft:iron_chestplate", "minecraft:iron_leggings", "minecraft:iron_boots", "minecraft:iron_ore", "minecraft:deepslate_iron_ore",
            "minecraft:iron_block", "minecraft:raw_iron_block", "minecraft:iron_horse_armor", "minecraft:gold_ingot", "minecraft:raw_gold",
            "minecraft:golden_sword", "minecraft:golden_axe", "minecraft:golden_pickaxe", "minecraft:golden_shovel", "minecraft:golden_hoe",
            "minecraft:gold_nugget", "minecraft:golden_helmet", "minecraft:golden_chestplate", "minecraft:golden_leggings", "minecraft:golden_boots",
            "minecraft:gold_ore", "minecraft:deepslate_gold_ore", "minecraft:gold_block", "minecraft:raw_gold_block", "minecraft:golden_horse_armor",
            "minecraft:nether_gold_ore", "minecraft:chainmail_helmet", "minecraft:chainmail_chestplate", "minecraft:chainmail_leggings",
            "minecraft:chainmail_boots", "minecraft:bow", "minecraft:crossbow", "minecraft:shield", "minecraft:compass", "minecraft:clock",
            "minecraft:shears", "minecraft:name_tag", "minecraft:flint_and_steel", "minecraft:brush", "minecraft:fire_charge", "minecraft:honey_bottle",
            "minecraft:honeycomb", "minecraft:honey_block", "minecraft:honeycomb_block", "minecraft:lead", "minecraft:tnt", "minecraft:tnt_minecart",
            "minecraft:ender_pearl", "minecraft:blaze_rod", "minecraft:blaze_powder", "minecraft:magma_cream", "minecraft:slime_ball", "minecraft:slime_block",
            "minecraft:flower_banner_pattern", "minecraft:brewing_stand", "minecraft:fermented_spider_eye", "minecraft:lapis_block", "minecraft:lapis_lazuli",
            "minecraft:lapis_ore", "minecraft:deepslate_lapis_ore", "minecraft:poisonous_potato", "minecraft:rabbit_hide", "minecraft:turtle_egg",
            "minecraft:scute");


    @ConfigEntry.Category("rare")
    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public FormattingColorName rare_color = FormattingColorName.AQUA;

    @ConfigEntry.Category("rare")
    public List<String> rare_list = List.of("minecraft:spectral_arrow", "minecraft:diamond", "minecraft:diamond_sword", "minecraft:diamond_axe",
            "minecraft:diamond_pickaxe", "minecraft:diamond_shovel", "minecraft:diamond_hoe", "minecraft:diamond_helmet", "minecraft:diamond_chestplate",
            "minecraft:diamond_leggings", "minecraft:diamond_boots", "minecraft:diamond_ore", "minecraft:deepslate_diamond_ore", "minecraft:diamond_block",
            "minecraft:diamond_horse_armor", "minecraft:enchanted_book", "minecraft:enchanting_table", "minecraft:turtle_helmet", "minecraft:trident",
            "minecraft:spyglass", "minecraft:amethyst_shard", "minecraft:amethyst_block", "minecraft:amethyst_cluster", "minecraft:small_amethyst_bud",
            "minecraft:medium_amethyst_bud", "minecraft:large_amethyst_bud", "minecraft:budding_amethyst", "minecraft:goat_horn", "minecraft:bundle",
            "minecraft:recovery_compass", "minecraft:echo_shard", "minecraft:music_disc_blocks", "minecraft:nautilus_shell", "minecraft:golden_carrot",
            "minecraft:ender_eye", "minecraft:ghast_tear", "minecraft:golden_apple", "minecraft:glistering_melon_slice", "minecraft:jukebox",
            "minecraft:music_disc_13", "minecraft:music_disc_cat", "minecraft:music_disc_blocks", "minecraft:music_disc_chirp", "minecraft:music_disc_far",
            "minecraft:music_disc_mall", "minecraft:music_disc_mellohi", "minecraft:music_disc_stal", "minecraft:music_disc_strad", "minecraft:music_disc_ward",
            "minecraft:music_disc_11", "minecraft:music_disc_wait", "minecraft:music_disc_otherside", "minecraft:music_disc_relic", "minecraft:music_disc_5",
            "minecraft:music_disc_pigstep", "minecraft:disc_fragment_5", "minecraft:phantom_membrane", "minecraft:glow_ink_sac", "minecraft:emerald",
            "minecraft:emerald_block", "minecraft:emerald_ore", "minecraft:deepslate_emerald_ore", "minecraft:shulker_shell", "minecraft:shulker_box",
            "minecraft:rabbit_foot", "minecraft:angler_pottery_sherd", "minecraft:archer_pottery_sherd", "minecraft:arms_up_pottery_sherd",
            "minecraft:blade_pottery_sherd", "minecraft:brewer_pottery_sherd", "minecraft:burn_pottery_sherd", "minecraft:danger_pottery_sherd",
            "minecraft:explorer_pottery_sherd", "minecraft:friend_pottery_sherd", "minecraft:heart_pottery_sherd", "minecraft:heartbreak_pottery_sherd",
            "minecraft:howl_pottery_sherd", "minecraft:miner_pottery_sherd", "minecraft:mourner_pottery_sherd", "minecraft:plenty_pottery_sherd",
            "minecraft:prize_pottery_sherd", "minecraft:sheaf_pottery_sherd", "minecraft:shelter_pottery_sherd", "minecraft:skull_pottery_sherd",
            "minecraft:snort_pottery_sherd", "minecraft:decorated_pot", "minecraft:sniffer_egg");


    @ConfigEntry.Category("epic")
    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public FormattingColorName epic_color = FormattingColorName.LIGHT_PURPLE;

    @ConfigEntry.Category("epic")
    public List<String> epic_list = List.of("minecraft:netherite_ingot", "minecraft:netherite_sword", "minecraft:netherite_axe",
            "minecraft:netherite_pickaxe", "minecraft:netherite_shovel", "minecraft:netherite_hoe", "minecraft:netherite_helmet",
            "minecraft:netherite_chestplate", "minecraft:netherite_leggings", "minecraft:netherite_boots", "minecraft:ancient_debris",
            "minecraft:netherite_scrap", "minecraft:netherite_upgrade_smithing_template", "minecraft:elytra", "minecraft:heart_of_the_sea",
            "minecraft:creeper_head", "minecraft:dragon_head", "minecraft:piglin_head", "minecraft:player_head", "minecraft:zombie_head",
            "minecraft:skeleton_skull", "minecraft:wither_skeleton_skull", "minecraft:wither_rose", "minecraft:experience_bottle",
            "minecraft:end_crystal", "minecraft:creeper_banner_pattern", "minecraft:piglin_banner_pattern", "minecraft:globe_banner_pattern",
            "minecraft:skull_banner_pattern", "minecraft:dragon_breath");


    @ConfigEntry.Category("legendary")
    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public FormattingColorName legendary_color = FormattingColorName.YELLOW;

    @ConfigEntry.Category("legendary")
    public List<String> legendary_list = List.of("minecraft:enchanted_golden_apple", "minecraft:sentry_armor_trim_smithing_template",
            "minecraft:shaper_armor_trim_smithing_template", "minecraft:silence_armor_trim_smithing_template", "minecraft:snout_armor_trim_smithing_template",
            "minecraft:spire_armor_trim_smithing_template", "minecraft:coast_armor_trim_smithing_template", "minecraft:eye_armor_trim_smithing_template",
            "minecraft:dune_armor_trim_smithing_template", "minecraft:host_armor_trim_smithing_template", "minecraft:raiser_armor_trim_smithing_template",
            "minecraft:rib_armor_trim_smithing_template", "minecraft:tide_armor_trim_smithing_template", "minecraft:vex_armor_trim_smithing_template",
            "minecraft:ward_armor_trim_smithing_template", "minecraft:wayfinder_armor_trim_smithing_template", "minecraft:wild_armor_trim_smithing_template",
            "minecraft:dragon_egg", "minecraft:nether_star", "minecraft:totem_of_undying", "minecraft:conduit", "minecraft:beacon", "minecraft:mojang_banner_pattern");


    @ConfigEntry.Category("mythic")
    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public FormattingColorName mythic_color = FormattingColorName.GOLD;

    @ConfigEntry.Category("mythic")
    public List<String> mythic_list = List.of();
}