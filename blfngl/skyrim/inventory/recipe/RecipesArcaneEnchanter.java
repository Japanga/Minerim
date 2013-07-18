package blfngl.skyrim.inventory.recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import blfngl.skyrim.Skyrim;

public class RecipesArcaneEnchanter extends Skyrim
{
	private static final RecipesArcaneEnchanter instance = new RecipesArcaneEnchanter();
	private List recipes = new ArrayList();

	public static final RecipesArcaneEnchanter getInstance()
	{
		return instance;
	}

	private RecipesArcaneEnchanter()
	{
		recipes = new ArrayList();

		addShapeless(new ItemStack(ringGoldE), new Object [] {ringGold, soulGemPetty});
		addShapeless(new ItemStack(ringGoldDiamondE), new Object [] {ringGoldDiamond, soulGemPetty});
		addShapeless(new ItemStack(ringGoldEmeraldE), new Object [] {ringGoldEmerald, soulGemPetty});
		addShapeless(new ItemStack(ringGoldSapphireE), new Object [] {ringGoldSapphire, soulGemPetty});
		addShapeless(new ItemStack(ringSilverE), new Object [] {ringSilver, soulGemPetty});
		addShapeless(new ItemStack(ringSilverAmethystE), new Object [] {ringSilverAmethyst, soulGemPetty});
		addShapeless(new ItemStack(ringSilverGarnetE), new Object [] {ringSilverGarnet, soulGemPetty});
		addShapeless(new ItemStack(ringSilverRubyE), new Object [] {ringSilverRuby, soulGemPetty, soulGemPetty});

		Collections.sort(this.recipes, new RecipesArcaneEnchanterSorter(this));
		System.out.println(this.recipes.size() + " recipes");
	}

	public void addShapeless(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
	{
		ArrayList var3 = new ArrayList();
		Object[] var4 = par2ArrayOfObj;
		int var5 = par2ArrayOfObj.length;

		for (int var6 = 0; var6 < var5; ++var6)
		{
			Object var7 = var4[var6];

			if (var7 instanceof ItemStack)
			{
				var3.add(((ItemStack)var7).copy());
			}
			else if (var7 instanceof Item)
			{
				var3.add(new ItemStack((Item)var7));
			}
			else
			{
				if (!(var7 instanceof Block))
				{
					throw new RuntimeException("Invalid shapeless recipe!");
				}

				var3.add(new ItemStack((Block)var7));
			}
		}

		this.recipes.add(new ShapelessRecipesEnchanter(par1ItemStack, var3));
	}

	public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
	{
		int var3 = 0;
		ItemStack var4 = null;
		ItemStack var5 = null;
		int var6;

		for (var6 = 0; var6 < par1InventoryCrafting.getSizeInventory(); ++var6)
		{
			ItemStack var7 = par1InventoryCrafting.getStackInSlot(var6);

			if (var7 != null)
			{
				if (var3 == 0)
				{
					var4 = var7;
				}

				if (var3 == 1)
				{
					var5 = var7;
				}

				++var3;
			}
		}

		if (var3 == 2 && var4.itemID == var5.itemID && var4.stackSize == 1 && var5.stackSize == 1 && Item.itemsList[var4.itemID].isRepairable())
		{
			Item var11 = Item.itemsList[var4.itemID];
			int var13 = var11.getMaxDamage() - var4.getItemDamageForDisplay();
			int var8 = var11.getMaxDamage() - var5.getItemDamageForDisplay();
			int var9 = var13 + var8 + var11.getMaxDamage() * 5 / 100;
			int var10 = var11.getMaxDamage() - var9;

			if (var10 < 0)
			{
				var10 = 0;
			}

			return new ItemStack(var4.itemID, 1, var10);
		}
		else
		{
			for (var6 = 0; var6 < this.recipes.size(); ++var6)
			{
				IRecipe var12 = (IRecipe)this.recipes.get(var6);

				if (var12.matches(par1InventoryCrafting, par2World))
				{
					return var12.getCraftingResult(par1InventoryCrafting);
				}
			}

			return null;
		}
	}

	public List getRecipeList()
	{
		return this.recipes;
	}
}