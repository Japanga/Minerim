package blfngl.skyrim.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import blfngl.skyrim.Skyrim;
import blfngl.skyrim.inventory.recipe.RecipesArcaneEnchanter;

public class ContainerArcaneEnchanter extends Container
{
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 2, 2);
	public IInventory craftResult = new InventoryCraftResult();
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;

	public ContainerArcaneEnchanter(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
	{
		this.worldObj = par2World;
		this.posX = par3;
		this.posY = par4;
		this.posZ = par5;

		this.addSlotToContainer(new SlotCrafting(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 144, 36));
		int var6;
		int var7;

		for (var6 = 0; var6 < 2; ++var6)
		{
			for (var7 = 0; var7 < 2; ++var7)
			{
				this.addSlotToContainer(new Slot(this.craftMatrix, var7 + var6 * 2, 43 + var7 * 18, 26 + var6 * 18));
			}
		}

		for (var6 = 0; var6 < 3; ++var6)
		{
			for (var7 = 0; var7 < 9; ++var7)
			{
				this.addSlotToContainer(new Slot(par1InventoryPlayer, var7 + (var6 + 1) * 9, 8 + var7 * 18, 84 + var6 * 18));
			}
		}

		for (var6 = 0; var6 < 9; ++var6)
		{
			this.addSlotToContainer(new Slot(par1InventoryPlayer, var6, 8 + var6 * 18, 142));
		}

		this.onCraftMatrixChanged(this.craftMatrix);
	}

	/**
	 * Callback for when the crafting matrix is changed.
	 */
	 public void onCraftMatrixChanged(IInventory par1IInventory)
	{
		 this.craftResult.setInventorySlotContents(0, RecipesArcaneEnchanter.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
	}

	 /**
	  * Callback for when the crafting gui is closed.
	  */
	 public void onCraftGuiClosed(EntityPlayer par1EntityPlayer)
	 {
		 super.onCraftGuiClosed(par1EntityPlayer);

		 if (!this.worldObj.isRemote)
		 {
			 for (int var2 = 0; var2 < 4; ++var2)
			 {
				 ItemStack var3 = this.craftMatrix.getStackInSlotOnClosing(var2);

				 if (var3 != null)
				 {
					 par1EntityPlayer.dropPlayerItem(var3);
				 }
			 }
		 }
	 }

	 public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	 {
		 return this.worldObj.getBlockId(this.posX, this.posY, this.posZ) != Skyrim.arcaneEnchanter.blockID ? false : par1EntityPlayer.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
	 }

	 /**
	  * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	  */
	 public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	 {
		 ItemStack var3 = null;
		 Slot var4 = (Slot)this.inventorySlots.get(par2);

		 if (var4 != null && var4.getHasStack())
		 {
			 ItemStack var5 = var4.getStack();
			 var3 = var5.copy();

			 if (par2 == 0)
			 {
				 if (!this.mergeItemStack(var5, 9, 45, true))
				 {
					 return null;
				 }

				 var4.onSlotChange(var5, var3);
			 }
			 else if (par2 >= 10 && par2 < 37)
			 {
				 if (!this.mergeItemStack(var5, 9, 45, false))
				 {
					 return null;
				 }
			 }
			 else if (par2 >= 37 && par2 < 46)
			 {
				 if (!this.mergeItemStack(var5, 9, 45, false))
				 {
					 return null;
				 }
			 }
			 else if (!this.mergeItemStack(var5, 9, 45, false))
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

			 var4.onPickupFromSlot(par1EntityPlayer, var5);
		 }

		 return var3;
	 }
}