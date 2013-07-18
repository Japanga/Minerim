package blfngl.skyrim.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

public class SlotGrindstone extends Slot
{
    private final IInventory craftMatrix;
    private final IInventory recipe;
    private EntityPlayer thePlayer;
    private int amountCrafted;

    public SlotGrindstone(EntityPlayer var1, IInventory var2, IInventory var3, IInventory var4, int var5, int var6, int var7)
    {
        super(var3, var5, var6, var7);
        this.thePlayer = var1;
        this.craftMatrix = var2;
        this.recipe = var4;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack var1)
    {
        return false;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int var1)
    {
        if (this.getHasStack())
        {
            this.amountCrafted += Math.min(var1, this.getStack().stackSize);
        }

        return super.decrStackSize(var1);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    protected void onCrafting(ItemStack var1, int var2)
    {
        this.amountCrafted += var2;
        this.onCrafting(var1);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    protected void onCrafting(ItemStack var1) {}

    public void onPickupFromSlot(EntityPlayer var1, ItemStack var2)
    {
        this.onCrafting(var2);
        int var3;
        ItemStack var4;
        ItemStack var5;

        for (var3 = 0; var3 < this.craftMatrix.getSizeInventory(); ++var3)
        {
            var4 = this.craftMatrix.getStackInSlot(var3);

            if (var4 != null)
            {
                this.craftMatrix.decrStackSize(var3, 1);

                if (var4.getItem().hasContainerItem())
                {
                    var5 = var4.getItem().getContainerItemStack(var4);

                    if (var5.isItemStackDamageable() && var5.getItemDamage() > var5.getMaxDamage())
                    {
                        MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(this.thePlayer, var5));
                        var5 = null;
                    }

                    if (var5 != null && (!var4.getItem().doesContainerItemLeaveCraftingGrid(var4) || !this.thePlayer.inventory.addItemStackToInventory(var5)))
                    {
                        if (this.craftMatrix.getStackInSlot(var3) == null)
                        {
                            this.craftMatrix.setInventorySlotContents(var3, var5);
                        }
                        else
                        {
                            this.thePlayer.dropPlayerItem(var5);
                        }
                    }
                }
            }
        }

        for (var3 = 0; var3 < this.recipe.getSizeInventory(); ++var3)
        {
            var4 = this.recipe.getStackInSlot(var3);

            if (var4 != null && var4.getItem().hasContainerItem())
            {
                var5 = var4.getItem().getContainerItemStack(var4);

                if (var5.isItemStackDamageable() && var5.getItemDamage() > var5.getMaxDamage())
                {
                    MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(this.thePlayer, var5));
                    var5 = null;
                }

                if (var5 != null && (!var4.getItem().doesContainerItemLeaveCraftingGrid(var4) || !this.thePlayer.inventory.addItemStackToInventory(var5)))
                {
                    if (this.recipe.getStackInSlot(var3) == null)
                    {
                        this.recipe.setInventorySlotContents(var3, var5);
                    }
                    else
                    {
                        this.thePlayer.dropPlayerItem(var5);
                    }
                }
            }
        }
    }
}
