package com.zehn06.kebabmod.block;

import com.zehn06.kebabmod.KebabMod;
import com.zehn06.kebabmod.blockentity.ModBlockEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
	public static final Block DONER_MACHINE = registerBlock("doner_machine",
		new DonerMachineBlock(FabricBlockSettings.create()
			.mapColor(MapColor.IRON_GRAY)
			.instrument(Instrument.IRON_XYLOPHONE)
			.strength(3.5f)
			.sounds(BlockSoundGroup.METAL)
			.requiresTool()
			.nonOpaque()
		)
	);
	
	public static final Block PREPARATION_TABLE = registerBlock("preparation_table",
		new PreparationTableBlock(FabricBlockSettings.create()
			.mapColor(MapColor.OAK_TAN)
			.instrument(Instrument.BASS)
			.strength(2.5f)
			.sounds(BlockSoundGroup.WOOD)
		)
	);
	
	public static final Block DISPLAY_COUNTER = registerBlock("display_counter",
		new DisplayCounterBlock(FabricBlockSettings.create()
			.mapColor(MapColor.PALE_YELLOW)
			.strength(2.5f)
			.sounds(BlockSoundGroup.WOOD)
			.nonOpaque()
		)
	);
	
	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, new Identifier(KebabMod.MOD_ID, name), block);
	}
	
	private static void registerBlockItem(String name, Block block) {
		Registry.register(Registries.ITEM, new Identifier(KebabMod.MOD_ID, name),
			new BlockItem(block, new FabricItemSettings()));
	}
	
	public static void registerModBlocks() {
		KebabMod.LOGGER.info("Registering Mod Blocks for " + KebabMod.MOD_ID);
		
		ModBlockEntities.registerBlockEntities();
		
		// Add blocks to creative inventory
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
			content.add(DONER_MACHINE);
			content.add(PREPARATION_TABLE);
			content.add(DISPLAY_COUNTER);
		});
	}
}
