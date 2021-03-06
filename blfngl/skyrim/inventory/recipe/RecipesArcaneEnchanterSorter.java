package blfngl.skyrim.inventory.recipe;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

class RecipesArcaneEnchanterSorter implements Comparator
{
	final RecipesArcaneEnchanter recipes;

	RecipesArcaneEnchanterSorter(RecipesArcaneEnchanter par1SpiritCraftingManager)
	{
		this.recipes = par1SpiritCraftingManager;
	}

	public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
	{
		return par1IRecipe instanceof ShapelessRecipesEnchanter ? 1 : (par2IRecipe instanceof ShapelessRecipesEnchanter ? -1 :
			(par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
	}

	public int compare(Object par1Obj, Object par2Obj)
	{
		return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
	}
}