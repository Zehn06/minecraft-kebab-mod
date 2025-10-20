package com.zehn06.kebabmod.entity;

import com.zehn06.kebabmod.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Random;

public class CustomerEntity extends PathAwareEntity {
	private ItemStack wantedItem = ItemStack.EMPTY;
	private int orderPrice = 0;
	private int waitTime = 6000; // 5 minutes in ticks
	private boolean hasOrdered = false;
	
	public CustomerEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
	}
	
	public static DefaultAttributeContainer.Builder createCustomerAttributes() {
		return PathAwareEntity.createMobAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0);
	}
	
	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new SwimGoal(this));
		this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25));
		this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.8));
		this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.add(4, new LookAroundGoal(this));
	}
	
	@Override
	public void tick() {
		super.tick();
		
		if (!this.getWorld().isClient && !hasOrdered) {
			generateOrder();
			hasOrdered = true;
		}
		
		if (!this.getWorld().isClient && hasOrdered) {
			waitTime--;
			if (waitTime <= 0) {
				// Leave without paying
				this.discard();
			}
		}
	}
	
	private void generateOrder() {
		Random random = new Random();
		int orderType = random.nextInt(3);
		
		switch (orderType) {
			case 0:
				wantedItem = new ItemStack(ModItems.CHICKEN_DONER_WRAP);
				orderPrice = 15;
				break;
			case 1:
				wantedItem = new ItemStack(ModItems.LAMB_DONER_WRAP);
				orderPrice = 20;
				break;
			case 2:
				wantedItem = new ItemStack(ModItems.BEEF_DONER_WRAP);
				orderPrice = 18;
				break;
		}
	}
	
	@Override
	protected ActionResult interactMob(PlayerEntity player, Hand hand) {
		ItemStack itemStack = player.getStackInHand(hand);
		
		if (!this.getWorld().isClient) {
			if (!wantedItem.isEmpty() && itemStack.isItemEqual(wantedItem)) {
				// Customer receives order
				itemStack.decrement(1);
				
				// Give payment
				ItemStack payment = new ItemStack(ModItems.TURKISH_LIRA, orderPrice);
				if (!player.getInventory().insertStack(payment)) {
					player.dropItem(payment, false);
				}
				
				player.sendMessage(Text.literal("Müşteri: Teşekkür ederim! İşte " + orderPrice + " lira."), false);
				
				// Customer leaves happy
				this.discard();
				return ActionResult.SUCCESS;
			} else {
				// Show order
				if (!wantedItem.isEmpty()) {
					player.sendMessage(
						Text.literal("Müşteri: " + wantedItem.getName().getString() + " istiyorum. Fiyat: " + orderPrice + " lira"),
						false
					);
				}
				return ActionResult.SUCCESS;
			}
		}
		
		return ActionResult.PASS;
	}
	
	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		if (nbt.contains("WantedItem")) {
			wantedItem = ItemStack.fromNbt(nbt.getCompound("WantedItem"));
		}
		orderPrice = nbt.getInt("OrderPrice");
		waitTime = nbt.getInt("WaitTime");
		hasOrdered = nbt.getBoolean("HasOrdered");
	}
	
	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		if (!wantedItem.isEmpty()) {
			nbt.put("WantedItem", wantedItem.writeNbt(new NbtCompound()));
		}
		nbt.putInt("OrderPrice", orderPrice);
		nbt.putInt("WaitTime", waitTime);
		nbt.putBoolean("HasOrdered", hasOrdered);
	}
}
