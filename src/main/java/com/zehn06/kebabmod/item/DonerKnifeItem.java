package com.zehn06.kebabmod.item;

import com.zehn06.kebabmod.block.entity.DonerMachineBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DonerKnifeItem extends Item {
	public DonerKnifeItem(Settings settings) {
		super(settings);
	}
	
	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		World world = context.getWorld();
		BlockPos pos = context.getBlockPos();
		
		if (!world.isClient && world.getBlockEntity(pos) instanceof DonerMachineBlockEntity blockEntity) {
			ItemStack result = blockEntity.sliceMeat();
			if (!result.isEmpty()) {
				// Damage the knife
				context.getStack().damage(1, context.getPlayer(), 
					player -> player.sendToolBreakStatus(context.getHand()));
				
				// Drop the sliced meat
				if (!context.getPlayer().getInventory().insertStack(result)) {
					context.getPlayer().dropItem(result, false);
				}
				
				return ActionResult.SUCCESS;
			}
		}
		
		return ActionResult.PASS;
	}
	
	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damage(2, attacker, e -> e.sendEquipmentBreakStatus(net.minecraft.entity.EquipmentSlot.MAINHAND));
		return true;
	}
}
