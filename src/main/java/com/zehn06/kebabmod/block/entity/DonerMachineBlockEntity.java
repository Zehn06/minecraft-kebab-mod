package com.zehn06.kebabmod.block.entity;

import com.zehn06.kebabmod.item.ModItems;
import com.zehn06.kebabmod.screen.DonerMachineScreenHandler;
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
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DonerMachineBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
	private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
	
	private static final int INPUT_SLOT = 0;
	private static final int FUEL_SLOT = 1;
	private static final int OUTPUT_SLOT = 2;
	private static final int KNIFE_SLOT = 3;
	
	protected final PropertyDelegate propertyDelegate;
	private int progress = 0;
	private int maxProgress = 72;
	private int rotation = 0;
	
	public DonerMachineBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.DONER_MACHINE_BLOCK_ENTITY, pos, state);
		this.propertyDelegate = new PropertyDelegate() {
			@Override
			public int get(int index) {
				return switch (index) {
					case 0 -> DonerMachineBlockEntity.this.progress;
					case 1 -> DonerMachineBlockEntity.this.maxProgress;
					case 2 -> DonerMachineBlockEntity.this.rotation;
					default -> 0;
				};
			}
			
			@Override
			public void set(int index, int value) {
				switch (index) {
					case 0 -> DonerMachineBlockEntity.this.progress = value;
					case 1 -> DonerMachineBlockEntity.this.maxProgress = value;
					case 2 -> DonerMachineBlockEntity.this.rotation = value;
				}
			}
			
			@Override
			public int size() {
				return 3;
			}
		};
	}
	
	@Override
	public DefaultedList<ItemStack> getItems() {
		return inventory;
	}
	
	@Override
	public Text getDisplayName() {
		return Text.translatable("block.kebabmod.doner_machine");
	}
	
	@Nullable
	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
		return new DonerMachineScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
	}
	
	@Override
	public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
		buf.writeBlockPos(this.pos);
	}
	
	@Override
	protected void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		Inventories.writeNbt(nbt, inventory);
		nbt.putInt("doner_machine.progress", progress);
		nbt.putInt("doner_machine.rotation", rotation);
	}
	
	@Override
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);
		Inventories.readNbt(nbt, inventory);
		progress = nbt.getInt("doner_machine.progress");
		rotation = nbt.getInt("doner_machine.rotation");
	}
	
	public static void tick(World world, BlockPos pos, BlockState state, DonerMachineBlockEntity entity) {
		if (world.isClient()) {
			return;
		}
		
		// Rotasyon animasyonu
		entity.rotation = (entity.rotation + 1) % 360;
		
		if (hasRecipe(entity)) {
			entity.progress++;
			markDirty(world, pos, state);
			
			if (entity.progress >= entity.maxProgress) {
				craftItem(entity);
			}
		} else {
			entity.progress = 0;
			markDirty(world, pos, state);
		}
	}
	
	private static boolean hasRecipe(DonerMachineBlockEntity entity) {
		ItemStack input = entity.getStack(INPUT_SLOT);
		ItemStack knife = entity.getStack(KNIFE_SLOT);
		ItemStack output = entity.getStack(OUTPUT_SLOT);
		
		boolean hasInput = (input.isOf(ModItems.RAW_CHICKEN_MEAT) || 
				input.isOf(ModItems.RAW_LAMB_MEAT) || 
				input.isOf(ModItems.RAW_BEEF_MEAT));
		
		boolean hasKnife = knife.isOf(ModItems.DONER_KNIFE);
		boolean canInsertIntoOutput = output.isEmpty() || output.getCount() < output.getMaxCount();
		
		return hasInput && hasKnife && canInsertIntoOutput;
	}
	
	private static void craftItem(DonerMachineBlockEntity entity) {
		ItemStack input = entity.getStack(INPUT_SLOT);
		ItemStack output = entity.getStack(OUTPUT_SLOT);
		
		ItemStack result = ItemStack.EMPTY;
		
		if (input.isOf(ModItems.RAW_CHICKEN_MEAT)) {
			result = new ItemStack(ModItems.COOKED_CHICKEN_DONER);
		} else if (input.isOf(ModItems.RAW_LAMB_MEAT)) {
			result = new ItemStack(ModItems.COOKED_LAMB_DONER);
		} else if (input.isOf(ModItems.RAW_BEEF_MEAT)) {
			result = new ItemStack(ModItems.COOKED_BEEF_DONER);
		}
		
		if (!result.isEmpty()) {
			input.decrement(1);
			
			if (output.isEmpty()) {
				entity.setStack(OUTPUT_SLOT, result);
			} else if (output.isOf(result.getItem())) {
				output.increment(1);
			}
			
			// Bıçağı yıprat
			ItemStack knife = entity.getStack(KNIFE_SLOT);
			knife.damage(1, entity.getWorld().getRandom(), null);
			if (knife.getDamage() >= knife.getMaxDamage()) {
				entity.setStack(KNIFE_SLOT, ItemStack.EMPTY);
			}
			
			entity.progress = 0;
		}
	}
}
