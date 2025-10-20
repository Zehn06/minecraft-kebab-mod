package com.zehn06.kebabmod;

import com.zehn06.kebabmod.screen.DonerMachineScreen;
import com.zehn06.kebabmod.screen.ModScreenHandlers;
import com.zehn06.kebabmod.screen.PreparationTableScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class KebabModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HandledScreens.register(ModScreenHandlers.DONER_MACHINE_SCREEN_HANDLER, DonerMachineScreen::new);
		HandledScreens.register(ModScreenHandlers.PREPARATION_TABLE_SCREEN_HANDLER, PreparationTableScreen::new);
	}
}
