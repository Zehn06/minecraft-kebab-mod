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

public class CustomerEntity extends PathAwareEntity {
	private int orderType = -1; // -1 = no order, 0 = chicken, 1 = lamb, 2 = beef
	private int orderPrice = 0;
	private boolean orderFulfilled = false;
	
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
		this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
		this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.8));
		this.goalSelector.add(4, new LookAroundGoal(this));
	}
	
	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (!this.getWorld().isClient) {
			if (orderType == -1) {
				// Generate new order
				orderType = this.random.nextInt(3);
				orderPrice = 5 + this.random.nextInt(10);
				orderFulfilled = false;
				
				String donerType = switch (orderType) {
					case 0 -> "Tavuk";
					case 1 -> "Kuzu";
					case 2 -> "Dana";
					default -> "Bilinmeyen";
				};
				
				player.sendMessage(Text.literal("Müşteri: Bir " + donerType + " döner lütfen! " + orderPrice + " coin vereceğim."), false);
			} else if (!orderFulfilled) {
				// Check if player has the correct döner
				ItemStack heldItem = player.getStackInHand(hand);
				boolean correctOrder = false;
				
				if (orderType == 0 && heldItem.isOf(ModItems.CHICKEN_DONER_WRAP)) {
					correctOrder = true;
				} else if (orderType == 1 && heldItem.isOf(ModItems.LAMB_DONER_WRAP)) {
					correctOrder = true;
				} else if (orderType == 2 && heldItem.isOf(ModItems.BEEF_DONER_WRAP)) {
					correctOrder = true;
				}
				
				if (correctOrder) {
					heldItem.decrement(1);
					player.getInventory().insertStack(new ItemStack(ModItems.COIN, orderPrice));
					player.sendMessage(Text.literal("Müşteri: Teşekkür ederim! İşte " + orderPrice + " coin."), false);
					orderFulfilled = true;
					orderType = -1;
					orderPrice = 0;
				} else {
					player.sendMessage(Text.literal("Müşteri: Bu benim istediğim değil!"), false);
				}
			} else {
				player.sendMessage(Text.literal("Müşteri: Teşekkürler, başka bir şeye ihtiyacım yok."), false);
			}
		}
		
		return ActionResult.SUCCESS;
	}
	
	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("OrderType", orderType);
		nbt.putInt("OrderPrice", orderPrice);
		nbt.putBoolean("OrderFulfilled", orderFulfilled);
	}
	
	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		orderType = nbt.getInt("OrderType");
		orderPrice = nbt.getInt("OrderPrice");
		orderFulfilled = nbt.getBoolean("OrderFulfilled");
	}
}
