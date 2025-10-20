package com.zehn06.kebabmod.block.entity;

import com.zehn06.kebabmod.KebabMod;
import com.zehn06.kebabmod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
	public static final BlockEntityType<DonerMachineBlockEntity> DONER_MACHINE_BLOCK_ENTITY =
			Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(KebabMod.MOD_ID, "doner_machine_be"),
					FabricBlockEntityTypeBuilder.create(DonerMachineBlockEntity::new,
							ModBlocks.DONER_MACHINE).build());
	
	public static final BlockEntityType<PreparationTableBlockEntity> PREPARATION_TABLE_BLOCK_ENTITY =
			Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(KebabMod.MOD_ID, "preparation_table_be"),
					FabricBlockEntityTypeBuilder.create(PreparationTableBlockEntity::new,
							ModBlocks.PREPARATION_TABLE).build());
	
	public static void registerBlockEntities() {
		KebabMod.LOGGER.info("Registering Block Entities for " + KebabMod.MOD_ID);
	}
}
