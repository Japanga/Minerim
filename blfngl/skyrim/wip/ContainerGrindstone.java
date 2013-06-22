package blfngl.skyrim.wip;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import blfngl.skyrim.Skyrim;
import blfngl.skyrim.handler.InventoryGrindstone;
import blfngl.skyrim.tileentity.SlotGrindstone;
import blfngl.skyrim.tileentity.SlotGrindstoneWeapon;

public class ContainerGrindstone extends Container
{
	public InventoryGrindstone craftMatrix = new InventoryGrindstone(this, 3, 3);
	public InventoryGrindstoneRecipe recipe = new InventoryGrindstoneRecipe(this);
	public IInventory craftResult = new InventoryGrindstoneResult();
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;

	public ContainerGrindstone(InventoryPlayer var1, World var2, int var3, int var4, int var5)
	{
		this.worldObj = var2;
		this.posX = var3;
		this.posY = var4;
		this.posZ = var5;
		this.addSlotToContainer(new SlotGrindstone(var1.player, this.craftMatrix, this.craftResult, this.recipe, 0, 139, 35));
		this.addSlotToContainer(new SlotGrindstoneWeapon(this.recipe, 0, 19, 35));
		int var6;
		int var7;

		for (var6 = 0; var6 < 3; ++var6)
		{
			for (var7 = 0; var7 < 3; ++var7)
			{
				this.addSlotToContainer(new Slot(this.craftMatrix, var7 + var6 * 3, 45 + var7 * 18, 17 + var6 * 18));
			}
		}

		for (var6 = 0; var6 < 3; ++var6)
		{
			for (var7 = 0; var7 < 9; ++var7)
			{
				this.addSlotToContainer(new Slot(var1, var7 + var6 * 9 + 9, 8 + var7 * 18, 84 + var6 * 18));
			}
		}

		for (var6 = 0; var6 < 9; ++var6)
		{
			this.addSlotToContainer(new Slot(var1, var6, 8 + var6 * 18, 142));
		}

		this.onCraftMatrixChanged(this.craftMatrix);
		this.onCraftMatrixChanged(this.recipe);
	}

	public void onCraftMatrixChanged(IInventory var1)
	{
		this.craftResult.setInventorySlotContents(0, RecipesGrindstone.getInstance().findMatchingRecipe(this.craftMatrix, this.recipe, this.worldObj));
	}

	/**
	 * Callback for when the crafting gui is closed.
	 */
	 public void onCraftGuiClosed(EntityPlayer var1)
	{
		 super.onCraftGuiClosed(var1);
		 int var2;
		 ItemStack var3;

		 if (!this.worldObj.isRemote)
		 {
			 for (var2 = 0; var2 < 9; ++var2)
			 {
				 var3 = this.craftMatrix.getStackInSlotOnClosing(var2);

				 if (var3 != null)
				 {
					 var1.dropPlayerItem(var3);
				 }
			 }
		 }

		 if (!this.worldObj.isRemote)
		 {
			 for (var2 = 0; var2 < 1; ++var2)
			 {
				 var3 = this.recipe.getStackInSlotOnClosing(var2);

				 if (var3 != null)
				 {
					 var1.dropPlayerItem(var3);
				 }
			 }
		 }
	}

	 public boolean canInteractWith(EntityPlayer var1)
	 {
		 return this.worldObj.getBlockId(this.posX, this.posY, this.posZ) != Skyrim.grindstone.blockID ? false : var1.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
	 }

	 /**
	  * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	  */
	 public ItemStack transferStackInSlot(EntityPlayer var1, int var2)
	 {
		 ItemStack var3 = null;
		 Slot var4 = (Slot)this.inventorySlots.get(var2);

		 if (var4 != null && var4.getHasStack())
		 {
			 ItemStack var5 = var4.getStack();
			 var3 = var5.copy();

			 if (var2 == 0)
			 {
				 if (!this.mergeItemStack(var5, 10, 46, true))
				 {
					 return null;
				 }

				 var4.onSlotChange(var5, var3);
			 }
			 else if (var2 >= 10 && var2 < 37)
			 {
				 if (!this.mergeItemStack(var5, 37, 46, false))
				 {
					 return null;
				 }
			 }
			 else if (var2 >= 37 && var2 < 46)
			 {
				 if (!this.mergeItemStack(var5, 10, 37, false))
				 {
					 return null;
				 }
			 }
			 else if (!this.mergeItemStack(var5, 10, 46, false))
			 {
				 return null;
			 }

			 if (var5.stackSize == 0)
			 {
				 var4.putStack((ItemStack)null);
			 }
			 else
			 {
				 var4.onSlotChanged();
			 }

			 if (var5.stackSize == var3.stackSize)
			 {
				 return null;
			 }

			 var4.onPickupFromSlot(var1, var5);
		 }

		 return var3;
	 }

	 public boolean func_94530_a(ItemStack var1, Slot var2)
	 {
		 return var2.inventory != this.craftResult && super.func_94530_a(var1, var2);
	 }
}
