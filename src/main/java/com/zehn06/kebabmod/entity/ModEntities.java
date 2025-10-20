package com.zehn06.kebabmod.entity;

import com.zehn06.kebabmod.KebabMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
	public static final EntityType<CustomerEntity> CUSTOMER = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(KebabMod.MOD_ID, "customer"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CustomerEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.8f))
					.build()
	);
	
	public static void registerEntities() {
		KebabMod.LOGGER.info("Registering Entities for " + KebabMod.MOD_ID);
		
		FabricDefaultAttributeRegistry.register(CUSTOMER, CustomerEntity.createCustomerAttributes());
	}
}
