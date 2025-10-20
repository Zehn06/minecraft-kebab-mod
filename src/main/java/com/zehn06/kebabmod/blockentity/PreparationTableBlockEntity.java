package com.zehn06.kebabmod.blockentity;

import com.zehn06.kebabmod.item.ModItems;
import com.zehn06.kebabmod.screen.PreparationTableScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class PreparationTableBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
	private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10, ItemStack.EMPTY);
	
	public PreparationTableBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.PREPARATION_TABLE_BLOCK_ENTITY, pos, state);
	}
	
	@Override
	public DefaultedList<ItemStack> getItems() {
		return inventory;
	}
	
	@Override
	public Text getDisplayName() {
		return Text.translatable("container.kebab-mod.preparation_table");
	}
	
	@Nullable
	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
		return new PreparationTableScreenHandler(syncId, inv, this);
	}
	
	public void craftDoner() {
		// Check if we have all ingredients
		// Slots: 0-meat, 1-pita, 2-lettuce, 3-tomato, 4-onion, 5-pickle, 6-sauce, 7-8 empty, 9-output
		
		ItemStack meatStack = inventory.get(0);
		ItemStack pitaStack = inventory.get(1);
		ItemStack lettuceStack = inventory.get(2);
		ItemStack tomatoStack = inventory.get(3);
		
		if (meatStack.isEmpty() || pitaStack.isEmpty() || lettuceStack.isEmpty() || tomatoStack.isEmpty()) {
			return;
		}
		
		if (!pitaStack.isOf(ModItems.PITA_BREAD)) {
			return;
		}
		
		ItemStack result = ItemStack.EMPTY;
		
		if (meatStack.isOf(ModItems.SLICED_CHICKEN_DONER)) {
			result = new ItemStack(ModItems.CHICKEN_DONER_WRAP);
		} else if (meatStack.isOf(ModItems.SLICED_LAMB_DONER)) {
			result = new ItemStack(ModItems.LAMB_DONER_WRAP);
		} else if (meatStack.isOf(ModItems.SLICED_BEEF_DONER)) {
			result = new ItemStack(ModItems.BEEF_DONER_WRAP);
		}
		
		if (!result.isEmpty()) {
			ItemStack outputStack = inventory.get(9);
			if (outputStack.isEmpty() || (outputStack.isItemEqual(result) && outputStack.getCount() < outputStack.getMaxCount())) {
				// Consume ingredients
				meatStack.decrement(1);
				pitaStack.decrement(1);
				lettuceStack.decrement(1);
				tomatoStack.decrement(1);
				
				// Optional ingredients
				ItemStack onionStack = inventory.get(4);
				if (!onionStack.isEmpty()) {
					onionStack.decrement(1);
				}
				
				ItemStack pickleStack = inventory.get(5);
				if (!pickleStack.isEmpty()) {
					pickleStack.decrement(1);
				}
				
				ItemStack sauceStack = inventory.get(6);
				if (!sauceStack.isEmpty()) {
					sauceStack.decrement(1);
				}
				
				// Set output
				if (outputStack.isEmpty()) {
					inventory.set(9, result.copy());
				} else {
					outputStack.increment(1);
				}
				
				markDirty();
			}
		}
	}
	
	@Override
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);
		Inventories.readNbt(nbt, inventory);
	}
	
	@Override
	protected void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		Inventories.writeNbt(nbt, inventory);
	}
}
