package com.zehn06.kebabmod.item;

import com.zehn06.kebabmod.KebabMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
	// Raw Meats - Çiğ Etler
	public static final Item RAW_CHICKEN_DONER = registerItem("raw_chicken_doner", 
		new Item(new FabricItemSettings().food(FoodComponents.CHICKEN)));
	public static final Item RAW_LAMB_DONER = registerItem("raw_lamb_doner", 
		new Item(new FabricItemSettings().food(FoodComponents.MUTTON)));
	public static final Item RAW_BEEF_DONER = registerItem("raw_beef_doner", 
		new Item(new FabricItemSettings().food(FoodComponents.BEEF)));
	
	// Cooked Meats - Pişmiş Etler
	public static final Item COOKED_CHICKEN_DONER = registerItem("cooked_chicken_doner", 
		new Item(new FabricItemSettings().food(FoodComponents.COOKED_CHICKEN)));
	public static final Item COOKED_LAMB_DONER = registerItem("cooked_lamb_doner", 
		new Item(new FabricItemSettings().food(FoodComponents.COOKED_MUTTON)));
	public static final Item COOKED_BEEF_DONER = registerItem("cooked_beef_doner", 
		new Item(new FabricItemSettings().food(FoodComponents.COOKED_BEEF)));
	
	// Sliced Meats - Dilimlenmis Etler
	public static final Item SLICED_CHICKEN_DONER = registerItem("sliced_chicken_doner", 
		new Item(new FabricItemSettings().food(FoodComponents.COOKED_CHICKEN)));
	public static final Item SLICED_LAMB_DONER = registerItem("sliced_lamb_doner", 
		new Item(new FabricItemSettings().food(FoodComponents.COOKED_MUTTON)));
	public static final Item SLICED_BEEF_DONER = registerItem("sliced_beef_doner", 
		new Item(new FabricItemSettings().food(FoodComponents.COOKED_BEEF)));
	
	// Bread & Vegetables - Ekmek & Sebzeler
	public static final Item PITA_BREAD = registerItem("pita_bread", 
		new Item(new FabricItemSettings().food(FoodComponents.BREAD)));
	public static final Item LETTUCE = registerItem("lettuce", 
		new Item(new FabricItemSettings().food(FoodComponents.CARROT)));
	public static final Item TOMATO = registerItem("tomato", 
		new Item(new FabricItemSettings().food(FoodComponents.CARROT)));
	public static final Item ONION = registerItem("onion", 
		new Item(new FabricItemSettings().food(FoodComponents.CARROT)));
	public static final Item PICKLE = registerItem("pickle", 
		new Item(new FabricItemSettings().food(FoodComponents.CARROT)));
	
	// Sauces - Soslar
	public static final Item GARLIC_SAUCE = registerItem("garlic_sauce", 
		new Item(new FabricItemSettings().maxCount(16)));
	public static final Item HOT_SAUCE = registerItem("hot_sauce", 
		new Item(new FabricItemSettings().maxCount(16)));
	public static final Item YOGURT_SAUCE = registerItem("yogurt_sauce", 
		new Item(new FabricItemSettings().maxCount(16)));
	
	// Finished Products - Bitmiş Ürünler
	public static final Item CHICKEN_DONER_WRAP = registerItem("chicken_doner_wrap", 
		new Item(new FabricItemSettings().food(new FoodComponent.Builder()
			.hunger(12).saturationModifier(0.8f).build())));
	public static final Item LAMB_DONER_WRAP = registerItem("lamb_doner_wrap", 
		new Item(new FabricItemSettings().food(new FoodComponent.Builder()
			.hunger(14).saturationModifier(0.9f).build())));
	public static final Item BEEF_DONER_WRAP = registerItem("beef_doner_wrap", 
		new Item(new FabricItemSettings().food(new FoodComponent.Builder()
			.hunger(13).saturationModifier(0.85f).build())));
	
	// Tools - Araçlar
	public static final Item DONER_KNIFE = registerItem("doner_knife", 
		new DonerKnifeItem(new FabricItemSettings().maxDamage(250)));
	
	// Currency - Para
	public static final Item TURKISH_LIRA = registerItem("turkish_lira", 
		new Item(new FabricItemSettings()));
	
	// Item Group
	public static final RegistryKey<ItemGroup> KEBAB_GROUP = RegistryKey.of(
		Registries.ITEM_GROUP.getKey(), 
		new Identifier(KebabMod.MOD_ID, "kebab_group")
	);
	
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(KebabMod.MOD_ID, name), item);
	}
	
	public static void registerModItems() {
		KebabMod.LOGGER.info("Registering Mod Items for " + KebabMod.MOD_ID);
		
		// Register Item Group
		Registry.register(Registries.ITEM_GROUP, KEBAB_GROUP,
			FabricItemGroup.builder()
				.icon(() -> new ItemStack(CHICKEN_DONER_WRAP))
				.displayName(Text.translatable("itemgroup.kebab-mod"))
				.build()
		);
		
		// Add items to group
		ItemGroupEvents.modifyEntriesEvent(KEBAB_GROUP).register(content -> {
			// Raw Meats
			content.add(RAW_CHICKEN_DONER);
			content.add(RAW_LAMB_DONER);
			content.add(RAW_BEEF_DONER);
			
			// Cooked Meats
			content.add(COOKED_CHICKEN_DONER);
			content.add(COOKED_LAMB_DONER);
			content.add(COOKED_BEEF_DONER);
			
			// Sliced Meats
			content.add(SLICED_CHICKEN_DONER);
			content.add(SLICED_LAMB_DONER);
			content.add(SLICED_BEEF_DONER);
			
			// Bread & Vegetables
			content.add(PITA_BREAD);
			content.add(LETTUCE);
			content.add(TOMATO);
			content.add(ONION);
			content.add(PICKLE);
			
			// Sauces
			content.add(GARLIC_SAUCE);
			content.add(HOT_SAUCE);
			content.add(YOGURT_SAUCE);
			
			// Finished Products
			content.add(CHICKEN_DONER_WRAP);
			content.add(LAMB_DONER_WRAP);
			content.add(BEEF_DONER_WRAP);
			
			// Tools
			content.add(DONER_KNIFE);
			
			// Currency
			content.add(TURKISH_LIRA);
		});
	}
}
