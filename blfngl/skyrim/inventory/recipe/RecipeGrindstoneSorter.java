package blfngl.skyrim.inventory.recipe;

import java.util.Comparator;

import blfngl.skyrim.wip.IRecipeGrindstone;
import blfngl.skyrim.wip.RecipesGrindstone;

class RecipeGrindstoneSorter implements Comparator
{
    final RecipesGrindstone craftingManager;

    RecipeGrindstoneSorter(RecipesGrindstone var1)
    {
        this.craftingManager = var1;
    }

    public int compareRecipes(IRecipeGrindstone var1, IRecipeGrindstone var2)
    {
        return var1 instanceof ShapelessRecipesGrindstone ? 1 : (var2 instanceof ShapelessRecipesGrindstone ? -1 : (var2.getRecipeSize() < var1.getRecipeSize() ? -1 : (var2.getRecipeSize() > var1.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object var1, Object var2)
    {
        return this.compareRecipes((IRecipeGrindstone)var1, (IRecipeGrindstone)var2);
    }
}