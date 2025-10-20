package com.zehn06.kebabmod;

import com.zehn06.kebabmod.block.ModBlocks;
import com.zehn06.kebabmod.item.ModItems;
import com.zehn06.kebabmod.entity.ModEntities;
import com.zehn06.kebabmod.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KebabMod implements ModInitializer {
	public static final String MOD_ID = "kebab-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading Advanced Kebab Shop Mod - Gelişmiş Dönerci Modu");
		
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		ModScreenHandlers.registerScreenHandlers();
		
		LOGGER.info("Advanced Kebab Shop Mod loaded successfully!");
	}
}
