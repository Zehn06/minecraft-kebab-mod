package com.zehn06.kebabmod.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class PreparationTableScreenHandler extends ScreenHandler {
	private final Inventory inventory;
	
	public PreparationTableScreenHandler(int syncId, PlayerInventory playerInventory) {
		this(syncId, playerInventory, new SimpleInventory(10));
	}
	
	public PreparationTableScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(ModScreenHandlers.PREPARATION_TABLE_SCREEN_HANDLER, syncId);
		checkSize(inventory, 10);
		this.inventory = inventory;
		inventory.onOpen(playerInventory.player);
		
		// Ingredient slots
		this.addSlot(new Slot(inventory, 0, 30, 17));  // Meat
		this.addSlot(new Slot(inventory, 1, 48, 17));  // Pita bread
		this.addSlot(new Slot(inventory, 2, 66, 17));  // Lettuce
		this.addSlot(new Slot(inventory, 3, 84, 17));  // Tomato
		this.addSlot(new Slot(inventory, 4, 102, 17)); // Onion
		this.addSlot(new Slot(inventory, 5, 120, 17)); // Pickle
		this.addSlot(new Slot(inventory, 6, 138, 17)); // Sauce
		
		// Empty slots
		this.addSlot(new Slot(inventory, 7, 30, 53));
		this.addSlot(new Slot(inventory, 8, 48, 53));
		
		// Output slot
		this.addSlot(new Slot(inventory, 9, 134, 53) {
			@Override
			public boolean canInsert(ItemStack stack) {
				return false;
			}
		});
		
		// Player Inventory
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		// Player Hotbar
		for (int i = 0; i < 9; ++i) {
			this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
		}
	}
	
	@Override
	public ItemStack quickMove(PlayerEntity player, int index) {
		ItemStack newStack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		
		if (slot != null && slot.hasStack()) {
			ItemStack originalStack = slot.getStack();
			newStack = originalStack.copy();
			
			if (index < this.inventory.size()) {
				if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
				return ItemStack.EMPTY;
			}
			
			if (originalStack.isEmpty()) {
				slot.setStack(ItemStack.EMPTY);
			} else {
				slot.markDirty();
			}
		}
		
		return newStack;
	}
	
	@Override
	public boolean canUse(PlayerEntity player) {
		return this.inventory.canPlayerUse(player);
	}
}
