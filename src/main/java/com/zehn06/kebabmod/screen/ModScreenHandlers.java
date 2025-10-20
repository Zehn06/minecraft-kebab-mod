package com.zehn06.kebabmod.screen;

import com.zehn06.kebabmod.KebabMod;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
	public static final ScreenHandlerType<DonerMachineScreenHandler> DONER_MACHINE_SCREEN_HANDLER =
			Registry.register(Registries.SCREEN_HANDLER, new Identifier(KebabMod.MOD_ID, "doner_machine"),
					new ExtendedScreenHandlerType<>(DonerMachineScreenHandler::new));
	
	public static final ScreenHandlerType<PreparationTableScreenHandler> PREPARATION_TABLE_SCREEN_HANDLER =
			Registry.register(Registries.SCREEN_HANDLER, new Identifier(KebabMod.MOD_ID, "preparation_table"),
					new ExtendedScreenHandlerType<>(PreparationTableScreenHandler::new));
	
	public static void registerScreenHandlers() {
		KebabMod.LOGGER.info("Registering Screen Handlers for " + KebabMod.MOD_ID);
	}
}
