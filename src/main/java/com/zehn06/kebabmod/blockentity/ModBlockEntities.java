package com.zehn06.kebabmod.blockentity;

import com.zehn06.kebabmod.KebabMod;
import com.zehn06.kebabmod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
	public static BlockEntityType<DonerMachineBlockEntity> DONER_MACHINE_BLOCK_ENTITY;
	public static BlockEntityType<PreparationTableBlockEntity> PREPARATION_TABLE_BLOCK_ENTITY;
	
	public static void registerBlockEntities() {
		DONER_MACHINE_BLOCK_ENTITY = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			new Identifier(KebabMod.MOD_ID, "doner_machine_block_entity"),
			FabricBlockEntityTypeBuilder.create(DonerMachineBlockEntity::new, ModBlocks.DONER_MACHINE).build()
		);
		
		PREPARATION_TABLE_BLOCK_ENTITY = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			new Identifier(KebabMod.MOD_ID, "preparation_table_block_entity"),
			FabricBlockEntityTypeBuilder.create(PreparationTableBlockEntity::new, ModBlocks.PREPARATION_TABLE).build()
		);
	}
}
