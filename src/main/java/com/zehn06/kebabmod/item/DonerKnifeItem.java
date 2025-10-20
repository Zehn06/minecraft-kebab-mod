package com.zehn06.kebabmod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DonerKnifeItem extends Item {
	public DonerKnifeItem(Settings settings) {
		super(settings);
	}
	
	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(attacker.getActiveHand()));
		return true;
	}
}
