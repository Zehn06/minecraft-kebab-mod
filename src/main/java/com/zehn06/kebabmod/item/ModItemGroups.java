package com.zehn06.kebabmod.item;

import com.zehn06.kebabmod.KebabMod;
import com.zehn06.kebabmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
	public static final ItemGroup KEBAB_GROUP = Registry.register(Registries.ITEM_GROUP,
			new Identifier(KebabMod.MOD_ID, "kebab"),
			FabricItemGroup.builder().displayName(Text.translatable("itemgroup.kebab"))
					.icon(() -> new ItemStack(ModItems.CHICKEN_DONER_WRAP)).entries((displayContext, entries) -> {
						// Bloklar
						entries.add(ModBlocks.DONER_MACHINE);
						entries.add(ModBlocks.PREPARATION_TABLE);
						entries.add(ModBlocks.DISPLAY_COUNTER);
						
						// Çiğ Etler
						entries.add(ModItems.RAW_CHICKEN_MEAT);
						entries.add(ModItems.RAW_LAMB_MEAT);
						entries.add(ModItems.RAW_BEEF_MEAT);
						
						// Pişmiş Etler
						entries.add(ModItems.COOKED_CHICKEN_DONER);
						entries.add(ModItems.COOKED_LAMB_DONER);
						entries.add(ModItems.COOKED_BEEF_DONER);
						
						// Malzemeler
						entries.add(ModItems.PIDE_BREAD);
						entries.add(ModItems.LETTUCE);
						entries.add(ModItems.TOMATO);
						entries.add(ModItems.ONION);
						entries.add(ModItems.PICKLE);
						
						// Soslar
						entries.add(ModItems.GARLIC_SAUCE);
						entries.add(ModItems.HOT_SAUCE);
						entries.add(ModItems.YOGURT_SAUCE);
						
						// Dürümler
						entries.add(ModItems.CHICKEN_DONER_WRAP);
						entries.add(ModItems.LAMB_DONER_WRAP);
						entries.add(ModItems.BEEF_DONER_WRAP);
						
						// Özel Eşyalar
						entries.add(ModItems.DONER_KNIFE);
						entries.add(ModItems.COIN);
					}).build());
	
	public static void registerItemGroups() {
		KebabMod.LOGGER.info("Registering Item Groups for " + KebabMod.MOD_ID);
	}
}
