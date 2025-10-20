package com.zehn06.kebabmod.screen;

import com.zehn06.kebabmod.KebabMod;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
	public static ScreenHandlerType<DonerMachineScreenHandler> DONER_MACHINE_SCREEN_HANDLER;
	public static ScreenHandlerType<PreparationTableScreenHandler> PREPARATION_TABLE_SCREEN_HANDLER;
	
	public static void registerScreenHandlers() {
		DONER_MACHINE_SCREEN_HANDLER = Registry.register(
			Registries.SCREEN_HANDLER,
			new Identifier(KebabMod.MOD_ID, "doner_machine"),
			new ScreenHandlerType<>(DonerMachineScreenHandler::new, null)
		);
		
		PREPARATION_TABLE_SCREEN_HANDLER = Registry.register(
			Registries.SCREEN_HANDLER,
			new Identifier(KebabMod.MOD_ID, "preparation_table"),
			new ScreenHandlerType<>(PreparationTableScreenHandler::new, null)
		);
	}
}
