package com.zehn06.kebabmod.block;

import com.zehn06.kebabmod.KebabMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
	public static final Block DONER_MACHINE = registerBlock("doner_machine",
			new DonerMachineBlock(FabricBlockSettings.create()
					.strength(3.0f)
					.requiresTool()
					.sounds(BlockSoundGroup.METAL)
					.nonOpaque()));
	
	public static final Block PREPARATION_TABLE = registerBlock("preparation_table",
			new PreparationTableBlock(FabricBlockSettings.create()
					.strength(2.5f)
					.sounds(BlockSoundGroup.WOOD)));
	
	public static final Block DISPLAY_COUNTER = registerBlock("display_counter",
			new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
					.strength(2.0f)
					.sounds(BlockSoundGroup.WOOD)));
	
	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, new Identifier(KebabMod.MOD_ID, name), block);
	}
	
	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, new Identifier(KebabMod.MOD_ID, name),
				new BlockItem(block, new FabricItemSettings()));
	}
	
	public static void registerModBlocks() {
		KebabMod.LOGGER.info("Registering ModBlocks for " + KebabMod.MOD_ID);
	}
}
