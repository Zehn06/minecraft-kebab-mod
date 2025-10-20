package com.zehn06.kebabmod.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class DonerMachineScreenHandler extends ScreenHandler {
	private final Inventory inventory;
	
	public DonerMachineScreenHandler(int syncId, PlayerInventory playerInventory) {
		this(syncId, playerInventory, new SimpleInventory(4));
	}
	
	public DonerMachineScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(ModScreenHandlers.DONER_MACHINE_SCREEN_HANDLER, syncId);
		checkSize(inventory, 4);
		this.inventory = inventory;
		inventory.onOpen(playerInventory.player);
		
		// Input slot (raw meat)
		this.addSlot(new Slot(inventory, 0, 56, 35));
		
		// Output slot (cooked meat)
		this.addSlot(new Slot(inventory, 1, 116, 35) {
			@Override
			public boolean canInsert(ItemStack stack) {
				return false;
			}
		});
		
		// Fuel slot (optional)
		this.addSlot(new Slot(inventory, 2, 56, 53));
		
		// Extra slot
		this.addSlot(new Slot(inventory, 3, 116, 53) {
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
