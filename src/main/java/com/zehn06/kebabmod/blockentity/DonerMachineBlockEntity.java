package com.zehn06.kebabmod.blockentity;

import com.zehn06.kebabmod.item.ModItems;
import com.zehn06.kebabmod.screen.DonerMachineScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DonerMachineBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
	private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
	private int cookTime = 0;
	private int cookTimeTotal = 200; // 10 seconds
	private float rotationAngle = 0.0f;
	
	public DonerMachineBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.DONER_MACHINE_BLOCK_ENTITY, pos, state);
	}
	
	@Override
	public DefaultedList<ItemStack> getItems() {
		return inventory;
	}
	
	@Override
	public Text getDisplayName() {
		return Text.translatable("container.kebab-mod.doner_machine");
	}
	
	@Nullable
	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
		return new DonerMachineScreenHandler(syncId, inv, this);
	}
	
	public void tick(World world, BlockPos pos, BlockState state) {
		if (world.isClient) {
			// Rotate the döner for animation
			rotationAngle += 2.0f;
			if (rotationAngle >= 360.0f) {
				rotationAngle = 0.0f;
			}
			return;
		}
		
		boolean dirty = false;
		
		// Check if we have raw meat to cook
		ItemStack inputStack = inventory.get(0);
		ItemStack outputStack = inventory.get(1);
		
		if (canCook(inputStack)) {
			cookTime++;
			dirty = true;
			
			if (cookTime >= cookTimeTotal) {
				cookTime = 0;
				craftItem();
				dirty = true;
			}
		} else {
			cookTime = 0;
		}
		
		if (dirty) {
			markDirty();
		}
	}
	
	private boolean canCook(ItemStack input) {
		if (input.isEmpty()) {
			return false;
		}
		
		ItemStack result = getCookingResult(input);
		if (result.isEmpty()) {
			return false;
		}
		
		ItemStack outputStack = inventory.get(1);
		if (outputStack.isEmpty()) {
			return true;
		}
		
		if (!outputStack.isItemEqual(result)) {
			return false;
		}
		
		return outputStack.getCount() + result.getCount() <= outputStack.getMaxCount();
	}
	
	private void craftItem() {
		ItemStack inputStack = inventory.get(0);
		ItemStack result = getCookingResult(inputStack);
		ItemStack outputStack = inventory.get(1);
		
		if (outputStack.isEmpty()) {
			inventory.set(1, result.copy());
		} else if (outputStack.isItemEqual(result)) {
			outputStack.increment(result.getCount());
		}
		
		inputStack.decrement(1);
	}
	
	private ItemStack getCookingResult(ItemStack input) {
		if (input.isOf(ModItems.RAW_CHICKEN_DONER)) {
			return new ItemStack(ModItems.COOKED_CHICKEN_DONER);
		} else if (input.isOf(ModItems.RAW_LAMB_DONER)) {
			return new ItemStack(ModItems.COOKED_LAMB_DONER);
		} else if (input.isOf(ModItems.RAW_BEEF_DONER)) {
			return new ItemStack(ModItems.COOKED_BEEF_DONER);
		}
		return ItemStack.EMPTY;
	}
	
	public ItemStack sliceMeat() {
		ItemStack cookedStack = inventory.get(1);
		
		if (cookedStack.isOf(ModItems.COOKED_CHICKEN_DONER)) {
			cookedStack.decrement(1);
			markDirty();
			return new ItemStack(ModItems.SLICED_CHICKEN_DONER, 3);
		} else if (cookedStack.isOf(ModItems.COOKED_LAMB_DONER)) {
			cookedStack.decrement(1);
			markDirty();
			return new ItemStack(ModItems.SLICED_LAMB_DONER, 3);
		} else if (cookedStack.isOf(ModItems.COOKED_BEEF_DONER)) {
			cookedStack.decrement(1);
			markDirty();
			return new ItemStack(ModItems.SLICED_BEEF_DONER, 3);
		}
		
		return ItemStack.EMPTY;
	}
	
	public float getRotationAngle() {
		return rotationAngle;
	}
	
	public int getCookProgress() {
		return cookTime * 24 / cookTimeTotal;
	}
	
	@Override
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);
		Inventories.readNbt(nbt, inventory);
		cookTime = nbt.getInt("CookTime");
	}
	
	@Override
	protected void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		Inventories.writeNbt(nbt, inventory);
		nbt.putInt("CookTime", cookTime);
	}
}
