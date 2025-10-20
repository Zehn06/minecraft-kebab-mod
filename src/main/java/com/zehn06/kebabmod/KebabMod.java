package com.zehn06.kebabmod;

import com.zehn06.kebabmod.block.ModBlocks;
import com.zehn06.kebabmod.block.entity.ModBlockEntities;
import com.zehn06.kebabmod.entity.ModEntities;
import com.zehn06.kebabmod.item.ModItemGroups;
import com.zehn06.kebabmod.item.ModItems;
import com.zehn06.kebabmod.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KebabMod implements ModInitializer {
	public static final String MOD_ID = "kebabmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Kebab Mod");
		
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModEntities.registerEntities();
		
		LOGGER.info("Kebab Mod initialized successfully!");
	}
}
