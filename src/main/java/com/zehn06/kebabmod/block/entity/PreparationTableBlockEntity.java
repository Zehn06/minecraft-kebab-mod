package com.zehn06.kebabmod.block.entity;

import com.zehn06.kebabmod.item.ModItems;
import com.zehn06.kebabmod.screen.PreparationTableScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class PreparationTableBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
	private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10, ItemStack.EMPTY);
	
	// Slots: 0-6 ingredients, 7-8 sauce slots, 9 output
	protected final PropertyDelegate propertyDelegate;
	
	public PreparationTableBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.PREPARATION_TABLE_BLOCK_ENTITY, pos, state);
		this.propertyDelegate = new PropertyDelegate() {
			@Override
			public int get(int index) {
				return 0;
			}
			
			@Override
			public void set(int index, int value) {
			}
			
			@Override
			public int size() {
				return 1;
			}
		};
	}
	
	@Override
	public DefaultedList<ItemStack> getItems() {
		return inventory;
	}
	
	@Override
	public Text getDisplayName() {
		return Text.translatable("block.kebabmod.preparation_table");
	}
	
	@Nullable
	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
		return new PreparationTableScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
	}
	
	@Override
	public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
		buf.writeBlockPos(this.pos);
	}
	
	@Override
	protected void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		Inventories.writeNbt(nbt, inventory);
	}
	
	@Override
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);
		Inventories.readNbt(nbt, inventory);
	}
	
	public void craftDoner() {
		// Check if we have all ingredients for a döner wrap
		ItemStack meat = ItemStack.EMPTY;
		boolean hasBread = false;
		boolean hasVegetables = false;
		boolean hasSauce = false;
		
		// Find cooked meat
		for (int i = 0; i < 7; i++) {
			ItemStack stack = getStack(i);
			if (stack.isOf(ModItems.COOKED_CHICKEN_DONER) || 
				stack.isOf(ModItems.COOKED_LAMB_DONER) || 
				stack.isOf(ModItems.COOKED_BEEF_DONER)) {
				meat = stack;
				break;
			}
		}
		
		// Check for bread
		for (int i = 0; i < 7; i++) {
			if (getStack(i).isOf(ModItems.PIDE_BREAD)) {
				hasBread = true;
				break;
			}
		}
		
		// Check for vegetables (at least one)
		for (int i = 0; i < 7; i++) {
			ItemStack stack = getStack(i);
			if (stack.isOf(ModItems.LETTUCE) || stack.isOf(ModItems.TOMATO) || 
				stack.isOf(ModItems.ONION) || stack.isOf(ModItems.PICKLE)) {
				hasVegetables = true;
				break;
			}
		}
		
		// Check for sauce
		for (int i = 7; i < 9; i++) {
			ItemStack stack = getStack(i);
			if (stack.isOf(ModItems.GARLIC_SAUCE) || stack.isOf(ModItems.HOT_SAUCE) || 
				stack.isOf(ModItems.YOGURT_SAUCE)) {
				hasSauce = true;
				break;
			}
		}
		
		if (!meat.isEmpty() && hasBread && hasVegetables && hasSauce) {
			ItemStack output = ItemStack.EMPTY;
			
			if (meat.isOf(ModItems.COOKED_CHICKEN_DONER)) {
				output = new ItemStack(ModItems.CHICKEN_DONER_WRAP);
			} else if (meat.isOf(ModItems.COOKED_LAMB_DONER)) {
				output = new ItemStack(ModItems.LAMB_DONER_WRAP);
			} else if (meat.isOf(ModItems.COOKED_BEEF_DONER)) {
				output = new ItemStack(ModItems.BEEF_DONER_WRAP);
			}
			
			if (!output.isEmpty() && getStack(9).isEmpty()) {
				// Consume ingredients
				for (int i = 0; i < 9; i++) {
					ItemStack stack = getStack(i);
					if (!stack.isEmpty()) {
						stack.decrement(1);
					}
				}
				
				setStack(9, output);
			}
		}
	}
}
