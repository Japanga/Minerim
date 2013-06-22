package blfngl.skyrim.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import blfngl.skyrim.item.BaseSword;

public class SlotGrindstoneWeapon extends Slot
{
    public SlotGrindstoneWeapon(IInventory var1, int var2, int var3, int var4)
    {
        super(var1, var2, var3, var4);
    }

    public int getSlotStackLimit()
    {
        return 1;
    }

    public boolean isItemValid(ItemStack var1)
    {
        return var1.getItem() instanceof BaseSword;
    }
}