package com.castillix.infiniteExchange;

import com.castillix.infiniteExchange.BlockEntities.CustomBlockEntity;
import com.castillix.infiniteExchange.Blocks.CustomBlock;
import com.castillix.infiniteExchange.Items.CustomItem;
import com.castillix.infiniteExchange.ScreenHandlers.CustomScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfiniteExchangeMod implements ModInitializer {
    public static final Block CUSTOM_BLOCK;
    public static final BlockItem CUSTOM_BLOCK_ITEM;
    public static final BlockEntityType<CustomBlockEntity> CUSTOM_BLOCK_ENTITY;

    public static final String MOD_ID = "iexchange";
    public static final Identifier CUSTOM = new Identifier(MOD_ID, "custom_block");

    public static final ScreenHandlerType<CustomScreenHandler> CUSTOM_SCREEN_HANDLER;

    public static final Logger LOGGER = LoggerFactory.getLogger("InfiniteExchange");

    static {
        CUSTOM_BLOCK = Registry.register(Registry.BLOCK, CUSTOM, new CustomBlock(FabricBlockSettings.copyOf(Blocks.CHEST)));
        CUSTOM_BLOCK_ITEM = Registry.register(Registry.ITEM, CUSTOM, new BlockItem(CUSTOM_BLOCK, new Item.Settings().group(ItemGroup.MISC)));

        CUSTOM_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, CUSTOM, FabricBlockEntityTypeBuilder.create(CustomBlockEntity::new, CUSTOM_BLOCK).build(null));

        CUSTOM_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(CUSTOM, CustomScreenHandler::new);
    }

    @Override
    public void onInitialize() {

    }
}
