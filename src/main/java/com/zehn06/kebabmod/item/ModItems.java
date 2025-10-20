package com.zehn06.kebabmod.item;

import com.zehn06.kebabmod.KebabMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
	// Çiğ Etler
	public static final Item RAW_CHICKEN_MEAT = registerItem("raw_chicken_meat",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).meat().build())));
	
	public static final Item RAW_LAMB_MEAT = registerItem("raw_lamb_meat",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).meat().build())));
	
	public static final Item RAW_BEEF_MEAT = registerItem("raw_beef_meat",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).meat().build())));
	
	// Pişmiş Döner Etleri
	public static final Item COOKED_CHICKEN_DONER = registerItem("cooked_chicken_doner",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).meat().build())));
	
	public static final Item COOKED_LAMB_DONER = registerItem("cooked_lamb_doner",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).meat().build())));
	
	public static final Item COOKED_BEEF_DONER = registerItem("cooked_beef_doner",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).meat().build())));
	
	// Malzemeler
	public static final Item PIDE_BREAD = registerItem("pide_bread",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build())));
	
	public static final Item LETTUCE = registerItem("lettuce",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build())));
	
	public static final Item TOMATO = registerItem("tomato",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));
	
	public static final Item ONION = registerItem("onion",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build())));
	
	public static final Item PICKLE = registerItem("pickle",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build())));
	
	// Soslar
	public static final Item GARLIC_SAUCE = registerItem("garlic_sauce",
			new Item(new FabricItemSettings()));
	
	public static final Item HOT_SAUCE = registerItem("hot_sauce",
			new Item(new FabricItemSettings()));
	
	public static final Item YOGURT_SAUCE = registerItem("yogurt_sauce",
			new Item(new FabricItemSettings()));
	
	// Döner Dürümler
	public static final Item CHICKEN_DONER_WRAP = registerItem("chicken_doner_wrap",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(10).saturationModifier(1.2f).build())));
	
	public static final Item LAMB_DONER_WRAP = registerItem("lamb_doner_wrap",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(10).saturationModifier(1.2f).build())));
	
	public static final Item BEEF_DONER_WRAP = registerItem("beef_doner_wrap",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(10).saturationModifier(1.2f).build())));
	
	// Özel Eşyalar
	public static final Item DONER_KNIFE = registerItem("doner_knife",
			new DonerKnifeItem(new FabricItemSettings().maxCount(1).maxDamage(250)));
	
	public static final Item COIN = registerItem("coin",
			new Item(new FabricItemSettings()));
	
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(KebabMod.MOD_ID, name), item);
	}
	
	public static void registerModItems() {
		KebabMod.LOGGER.info("Registering Mod Items for " + KebabMod.MOD_ID);
	}
}
