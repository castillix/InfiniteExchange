package com.castillix.infiniteExchange;

import com.castillix.infiniteExchange.Items.CustomItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfiniteExchangeMod implements ModInitializer {
    public static final Item CUSTOM_ITEM = new CustomItem(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Block CUSTOM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Identifier EMC = new Identifier("iexchange", "emc");
    public static final Logger LOGGER = LoggerFactory.getLogger("InfiniteExchange");

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("iexchange", "custom_item"), CUSTOM_ITEM);

        Registry.register(Registry.BLOCK, new Identifier("iexchange", "custom_block"), CUSTOM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("iexchange", "custom_block"), new BlockItem(CUSTOM_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.CUSTOM_STAT, "emc", EMC);

        Stats.CUSTOM.getOrCreateStat(EMC, StatFormatter.DEFAULT);

        LOGGER.info("Hello World!");
    }
}
