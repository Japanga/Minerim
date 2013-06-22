package blfngl.skyrim.inventory.recipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import blfngl.skyrim.handler.InventoryGrindstone;
import blfngl.skyrim.wip.IRecipeGrindstone;
import blfngl.skyrim.wip.InventoryGrindstoneRecipe;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ShapelessRecipesGrindstone implements IRecipeGrindstone
{
    private final ItemStack recipeOutput;
    public final List recipeItems;
    public final ItemStack recipe;

    public ShapelessRecipesGrindstone(ItemStack var1, ItemStack var2, List var3)
    {
        this.recipeOutput = var1;
        this.recipeItems = var3;
        this.recipe = var2;
    }

    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }

    public boolean matches(InventoryGrindstone var1, InventoryGrindstoneRecipe var2, World var3)
    {
        ArrayList var4 = new ArrayList(this.recipeItems);
        ItemStack var5 = this.recipe;

        for (int var6 = 0; var6 < 3; ++var6)
        {
            for (int var7 = 0; var7 < 3; ++var7)
            {
                ItemStack var8 = var1.getStackInRowAndColumn(var7, var6);
                ItemStack var9 = var2.getStackInSlot(0);

                if (var8 != null && var9 != null)
                {
                    boolean var10 = false;
                    Iterator var11 = var4.iterator();

                    while (var11.hasNext())
                    {
                        ItemStack var12 = (ItemStack)var11.next();

                        if (var8.itemID == var12.itemID && (var12.getItemDamage() == 32767 || var8.getItemDamage() == var12.getItemDamage()))
                        {
                            var10 = true;
                            var4.remove(var12);
                            break;
                        }
                    }

                    if (var5.itemID != var9.itemID)
                    {
                        var10 = false;
                    }

                    if (!var10)
                    {
                        return false;
                    }
                }
            }
        }

        return var4.isEmpty();
    }

    public ItemStack getCraftingResult(InventoryGrindstone var1, InventoryGrindstoneRecipe var2)
    {
        return this.recipeOutput.copy();
    }

    public int getRecipeSize()
    {
        return this.recipeItems.size();
    }
}