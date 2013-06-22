package blfngl.skyrim.wip;

import blfngl.skyrim.handler.InventoryGrindstone;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IRecipeGrindstone
{
    boolean matches(InventoryGrindstone var1, InventoryGrindstoneRecipe var2, World var3);

    ItemStack getCraftingResult(InventoryGrindstone var1, InventoryGrindstoneRecipe var2);

    int getRecipeSize();

    ItemStack getRecipeOutput();
}
