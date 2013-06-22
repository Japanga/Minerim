package blfngl.skyrim.wip;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryGrindstoneResult implements IInventory
{
	private ItemStack[] stackResult = new ItemStack[1];

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory()
	{
		return 1;
	}

	/**
	 * Returns the stack in slot i
	 */
	public ItemStack getStackInSlot(int var1)
	{
		return this.stackResult[0];
	}

	/**
	 * Returns the name of the inventory.
	 */
	public String getInvName()
	{
		return "ForgeResult";
	}

	/**
	 * If this returns false, the inventory name will be used as an unlocalized name, and translated into the player's
	 * language. Otherwise it will be used directly.
	 */
	public boolean isInvNameLocalized()
	{
		return false;
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 */
	public ItemStack decrStackSize(int var1, int var2)
	{
		if (this.stackResult[0] != null)
		{
			ItemStack var3 = this.stackResult[0];
			this.stackResult[0] = null;
			return var3;
		}
		else
		{
			return null;
		}
	}

	public ItemStack getStackInSlotOnClosing(int var1)
	{
		if (this.stackResult[0] != null)
		{
			ItemStack var2 = this.stackResult[0];
			this.stackResult[0] = null;
			return var2;
		}
		else
		{
			return null;
		}
	}

	public void setInventorySlotContents(int var1, ItemStack var2)
	{
		this.stackResult[0] = var2;
	}

	public int getInventoryStackLimit()
	{
		return 64;
	}

	public void onInventoryChanged() {}

	public boolean isUseableByPlayer(EntityPlayer var1)
	{
		return true;
	}

	public void openChest() {}

	public void closeChest() {}

	public boolean isStackValidForSlot(int var1, ItemStack var2)
	{
		return true;
	}
}