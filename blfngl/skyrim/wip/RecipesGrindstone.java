package blfngl.skyrim.wip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import blfngl.skyrim.handler.InventoryGrindstone;
import blfngl.skyrim.inventory.recipe.ShapelessRecipesGrindstone;

public class RecipesGrindstone
{
	private static final RecipesGrindstone instance = new RecipesGrindstone();
	private List recipes = new ArrayList();

	public static final RecipesGrindstone getInstance()
	{
		return instance;
	}

	private RecipesGrindstone()
	{
		//this.addRecipe(new ItemStack(Block.enderChest), new ItemStack(FantasyOfMinecraft.recipeContainer, 1), new Object[] {"###", "#E#", "###", '#', Block.obsidian, 'E', Item.eyeOfEnder});
		Object[][] var1 = new Object[][] {{Block.blockGold, new ItemStack(Item.ingotGold, 9)}, {Block.blockIron, new ItemStack(Item.ingotIron, 9)}, {Block.blockDiamond, new ItemStack(Item.diamond, 9)}, {Block.blockEmerald, new ItemStack(Item.emerald, 9)}, {Block.blockLapis, new ItemStack(Item.dyePowder, 9, 4)}, {Block.blockRedstone, new ItemStack(Item.redstone, 9)}};

		for (int var2 = 0; var2 < var1.length; ++var2)
		{
			Block var3 = (Block)var1[var2][0];
			ItemStack var4 = (ItemStack)var1[var2][1];
		}

		Object[][] var13 = new Object[][] {{Item.ingotIron, Item.diamond, Item.ingotGold}, 
				{Item.pickaxeIron, Item.pickaxeDiamond, Item.pickaxeGold}, {Item.shovelIron, Item.shovelDiamond, Item.shovelGold}, 
				{Item.axeIron, Item.axeDiamond, Item.axeGold}, {Item.hoeIron, Item.hoeDiamond, Item.hoeGold}, {Item.swordIron, Item.swordDiamond, Item.swordGold}};
		String[][] var14 = new String[][] {{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}, {"X", "X", "#"}};
		Object[] var15 = new Object[] {};

		for (int var5 = 0; var5 < var13[0].length; ++var5)
		{
			Object var6 = var13[0][var5];

			for (int var7 = 0; var7 < var13.length - 1; ++var7)
			{
				Item var8 = (Item)var15[var7];
				Item var9 = (Item)var13[var7 + 1][var5];
			}
		}

		Object[][] var16 = new Object[][] {{Block.fire, Item.ingotIron, Item.diamond, Item.ingotGold}, 
				{Item.helmetChain, Item.helmetIron, Item.helmetDiamond, Item.helmetGold}, {Item.plateChain, Item.plateIron, Item.plateDiamond, Item.plateGold},
				{Item.legsChain, Item.legsIron, Item.legsDiamond, Item.legsGold}, {Item.bootsChain, Item.bootsIron, Item.bootsDiamond, Item.bootsGold}};
		String[][] var17 = new String[][] {{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};

		for (int var19 = 0; var19 < var16[0].length; ++var19)
		{
			Object var20 = var16[0][var19];

			for (int var10 = 0; var10 < var16.length - 1; ++var10)
			{
				Item var11 = (Item)var16[var10 + 1][var19];
			}
		}

		//TODO Collections.sort(this.recipes, new RecipesForgeSorter(this));
		System.out.println(this.recipes.size() + " recipes");
	}

	public void addShapelessRecipe(ItemStack var1, ItemStack var2, Object ... var3)
	{
		ArrayList var4 = new ArrayList();
		Object[] var5 = var3;
		int var6 = var3.length;

		for (int var7 = 0; var7 < var6; ++var7)
		{
			Object var8 = var5[var7];

			if (var8 instanceof ItemStack)
			{
				var4.add(((ItemStack)var8).copy());
			}
			else if (var8 instanceof Item)
			{
				var4.add(new ItemStack((Item)var8));
			}
			else
			{
				if (!(var8 instanceof Block))
				{
					throw new RuntimeException("Invalid shapeless recipy!");
				}

				var4.add(new ItemStack((Block)var8));
			}
		}

		this.recipes.add(new ShapelessRecipesGrindstone(var1, var2, var4));
	}

	public ItemStack findMatchingRecipe(InventoryGrindstone var1, InventoryGrindstoneRecipe var2, World var3)
	{
		int var4 = 0;
		ItemStack var5 = null;
		ItemStack var6 = null;
		Object var7 = null;
		int var8;
		ItemStack var9;

		for (var8 = 0; var8 < var1.getSizeInventory(); ++var8)
		{
			var9 = var1.getStackInSlot(var8);

			if (var9 != null)
			{
				if (var4 == 0)
				{
					var5 = var9;
				}

				if (var4 == 1)
				{
					var6 = var9;
				}

				++var4;
			}
		}

		var9 = var2.getStackInSlot(1);

		if (var4 == 2 && var5.itemID == var6.itemID && var5.stackSize == 1 && var6.stackSize == 1 && Item.itemsList[var5.itemID].isRepairable())
		{
			Item var15 = Item.itemsList[var5.itemID];
			int var11 = var15.getMaxDamage() - var5.getItemDamageForDisplay();
			int var12 = var15.getMaxDamage() - var6.getItemDamageForDisplay();
			int var13 = var11 + var12 + var15.getMaxDamage() * 5 / 100;
			int var14 = var15.getMaxDamage() - var13;

			if (var14 < 0)
			{
				var14 = 0;
			}

			return new ItemStack(var5.itemID, 1, var14);
		}
		else
		{
			for (var8 = 0; var8 < this.recipes.size(); ++var8)
			{
				IRecipeGrindstone var10 = (IRecipeGrindstone)this.recipes.get(var8);

				if (var10.matches(var1, var2, var3))
				{
					return var10.getCraftingResult(var1, var2);
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
