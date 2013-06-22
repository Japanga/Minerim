package blfngl.skyrim.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import blfngl.skyrim.Skyrim;

public class RecipesForge extends Skyrim
{
	private static final RecipesForge instance = new RecipesForge();
	private List recipes = new ArrayList();

	public static final RecipesForge getInstance()
	{
		return instance;
	}

	private RecipesForge()
	{
		recipes = new ArrayList();

		addShapelessRecipe(new ItemStack(daggerEbony), new Object [] {leatherStrips, ingotEbony});
		addShapelessRecipe(new ItemStack(swordEbony), new Object [] {leatherStrips, ingotEbony, ingotEbony});
		addShapelessRecipe(new ItemStack(greatSwordEbony), new Object [] {leatherStrips, leatherStrips, leatherStrips, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony});
		addShapelessRecipe(new ItemStack(warAxeEbony), new Object [] {leatherStrips, leatherStrips, ingotEbony, ingotEbony});
		addShapelessRecipe(new ItemStack(battleAxeEbony), new Object [] {leatherStrips, leatherStrips, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony});
		addShapelessRecipe(new ItemStack(maceEbony), new Object [] {leatherStrips, ingotEbony, ingotEbony, ingotEbony});
		addShapelessRecipe(new ItemStack(warhammerEbony), new Object [] {leatherStrips, leatherStrips, leatherStrips, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony});

		addShapelessRecipe(new ItemStack(daggerGlass), new Object [] {leatherStrips, ingotMalachite, ingotMoonstone});
		addShapelessRecipe(new ItemStack(swordGlass), new Object [] {leatherStrips, ingotMalachite, ingotMalachite, ingotMoonstone});
		addShapelessRecipe(new ItemStack(greatSwordGlass), new Object [] {leatherStrips, leatherStrips, leatherStrips, ingotMalachite, ingotMalachite, ingotMoonstone, ingotMoonstone});
		addShapelessRecipe(new ItemStack(warAxeGlass), new Object [] {leatherStrips, leatherStrips, ingotMalachite, ingotMoonstone});
		addShapelessRecipe(new ItemStack(battleAxeGlass), new Object [] {leatherStrips, leatherStrips, ingotMalachite, ingotMalachite, ingotMoonstone, ingotMoonstone});
		addShapelessRecipe(new ItemStack(maceGlass), new Object [] {leatherStrips, ingotMalachite, ingotMoonstone, ingotMoonstone});
		addShapelessRecipe(new ItemStack(warhammerGlass), new Object [] {leatherStrips, leatherStrips, leatherStrips, ingotMalachite, ingotMalachite, ingotMoonstone, ingotMoonstone, ingotMoonstone});

		addShapelessRecipe(new ItemStack(daggerDaedric), new Object [] {leatherStrips, ingotEbony, daedraHeart});
		addShapelessRecipe(new ItemStack(swordDaedric), new Object [] {leatherStrips, ingotEbony, ingotEbony, daedraHeart});
		addShapelessRecipe(new ItemStack(greatSwordDaedric), new Object [] {leatherStrips, leatherStrips, leatherStrips, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony, daedraHeart});
		addShapelessRecipe(new ItemStack(warAxeDaedric), new Object [] {leatherStrips, leatherStrips, ingotEbony, ingotEbony, daedraHeart});
		addShapelessRecipe(new ItemStack(battleAxeDaedric), new Object [] {leatherStrips, leatherStrips, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony, daedraHeart});
		addShapelessRecipe(new ItemStack(maceDaedric), new Object [] {leatherStrips, ingotEbony, ingotEbony, ingotEbony, daedraHeart});
		addShapelessRecipe(new ItemStack(warhammerDaedric), new Object [] {leatherStrips, leatherStrips, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony, daedraHeart});		

		addShapelessRecipe(new ItemStack(arrowDwarven, 24), new Object [] {firewood, ingotDwarven});
		addShapelessRecipe(new ItemStack(arrowDaedric, 24), new Object [] {firewood, ingotEbony, daedraHeart});
		addShapelessRecipe(new ItemStack(arrowGlass, 24), new Object [] {firewood, ingotMalachite});
		addShapelessRecipe(new ItemStack(arrowDragonbone, 24), new Object [] {firewood, dragonBone});
		addShapelessRecipe(new ItemStack(arrowIron, 24), new Object [] {firewood, Item.ingotIron});

		addShapelessRecipe(new ItemStack(helmDwarf), new Object [] {ingotDwarven, ingotDwarven, leatherStrips, leatherStrips, ingotSteel, Item.ingotIron});
		addShapelessRecipe(new ItemStack(chestDwarf), new Object [] {ingotDwarven, ingotDwarven, ingotDwarven, leatherStrips, leatherStrips, leatherStrips, ingotSteel, Item.ingotIron});
		addShapelessRecipe(new ItemStack(gauntletsDwarf), new Object [] {ingotDwarven, leatherStrips, leatherStrips, ingotSteel, Item.ingotIron});
		addShapelessRecipe(new ItemStack(bootsDwarf), new Object [] {ingotDwarven, ingotDwarven, leatherStrips, ingotSteel, Item.ingotIron});

		addShapelessRecipe(new ItemStack(helmEbony), new Object [] {ingotEbony, ingotEbony, ingotEbony, ingotEbony, leatherStrips, leatherStrips});
		addShapelessRecipe(new ItemStack(chestEbony), new Object [] {ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony, leatherStrips, leatherStrips, leatherStrips, leatherStrips});
		addShapelessRecipe(new ItemStack(gauntletsEbony), new Object [] {ingotEbony, ingotEbony, leatherStrips, leatherStrips});
		addShapelessRecipe(new ItemStack(bootsEbony), new Object [] {ingotEbony, ingotEbony, ingotEbony, leatherStrips, leatherStrips});

		addShapelessRecipe(new ItemStack(helmGlass), new Object [] {leatherStrips, ingotMalachite, ingotMalachite, ingotMoonstone, Item.leather});
		addShapelessRecipe(new ItemStack(chestGlass), new Object [] {leatherStrips, leatherStrips, leatherStrips, ingotMalachite, ingotMalachite, ingotMalachite, ingotMalachite, ingotMoonstone, ingotMoonstone});
		addShapelessRecipe(new ItemStack(gauntletsGlass), new Object [] {leatherStrips, leatherStrips, ingotMalachite, ingotMoonstone, Item.leather});
		addShapelessRecipe(new ItemStack(bootsGlass), new Object [] {leatherStrips, leatherStrips, ingotMalachite, ingotMalachite, ingotMoonstone, Item.leather});

		addShapelessRecipe(new ItemStack(daggerOrc), new Object [] {ingotOrichalcum, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(swordOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(greatSwordOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(warAxeOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(battleAxeOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(maceOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(warhammerOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, leatherStrips, Item.ingotIron, Item.ingotIron});

		addShapelessRecipe(new ItemStack(helmOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(chestOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(gauntletsOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(bootsOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, leatherStrips, Item.ingotIron});

		addShapelessRecipe(new ItemStack(daggerStalhrim), new Object [] {stalhrim, leatherStrips});
		addShapelessRecipe(new ItemStack(warhammerStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, stalhrim, stalhrim, leatherStrips, leatherStrips, leatherStrips, leatherStrips});
		addShapelessRecipe(new ItemStack(swordStalhrim), new Object [] {stalhrim, stalhrim, leatherStrips});
		addShapelessRecipe(new ItemStack(maceStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, leatherStrips});
		addShapelessRecipe(new ItemStack(warAxeStalhrim), new Object [] {stalhrim, stalhrim, leatherStrips, leatherStrips});
		addShapelessRecipe(new ItemStack(battleAxeStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, stalhrim, stalhrim, leatherStrips, leatherStrips});
		addShapelessRecipe(new ItemStack(greatSwordStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, stalhrim, stalhrim, leatherStrips, leatherStrips, leatherStrips});

		addShapelessRecipe(new ItemStack(helmStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, stalhrim, ingotQuicksilver, leatherStrips});
		addShapelessRecipe(new ItemStack(chestStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, stalhrim, stalhrim, ingotQuicksilver, leatherStrips, leatherStrips});
		addShapelessRecipe(new ItemStack(gauntletsStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, ingotQuicksilver, leatherStrips, leatherStrips});
		addShapelessRecipe(new ItemStack(bootsStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, stalhrim, ingotQuicksilver, leatherStrips, leatherStrips});

		addShapelessRecipe(new ItemStack(daggerNordic), new Object [] {ingotSteel, leatherStrips, ingotQuicksilver});
		addShapelessRecipe(new ItemStack(warhammerNordic), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotSteel, ingotSteel, ingotSteel, leatherStrips, ingotQuicksilver});
		addShapelessRecipe(new ItemStack(swordNordic), new Object [] {ingotSteel, ingotSteel, leatherStrips, ingotQuicksilver});
		addShapelessRecipe(new ItemStack(maceNordic), new Object [] {ingotSteel, leatherStrips, leatherStrips, ingotQuicksilver});
		addShapelessRecipe(new ItemStack(warAxeNordic), new Object [] {ingotSteel, ingotSteel, leatherStrips, leatherStrips, ingotQuicksilver});
		addShapelessRecipe(new ItemStack(battleAxeNordic), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotSteel, ingotSteel, leatherStrips, leatherStrips, ingotQuicksilver});
		addShapelessRecipe(new ItemStack(greatSwordNordic), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotSteel, ingotSteel, leatherStrips, leatherStrips, leatherStrips, ingotQuicksilver});

		addShapelessRecipe(new ItemStack(helmSteel), new Object [] {ingotSteel, ingotSteel, leatherStrips, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(chestSteel), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotSteel, leatherStrips, leatherStrips, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(gauntletsSteel), new Object [] {ingotSteel, ingotSteel, leatherStrips, Item.ingotIron, Item.ingotIron});
		addShapelessRecipe(new ItemStack(bootsSteel), new Object [] {ingotSteel, ingotSteel, ingotSteel, leatherStrips, leatherStrips, Item.ingotIron});

		addShapelessRecipe(new ItemStack(daggerSteel), new Object [] {ingotSteel, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(warhammerSteel), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotSteel, leatherStrips, leatherStrips, leatherStrips, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(swordSteel), new Object [] {ingotSteel, ingotSteel, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(maceSteel), new Object [] {ingotSteel, ingotSteel, ingotSteel, leatherStrips, Item.ingotIron});
		addShapelessRecipe(new ItemStack(warAxeSteel), new Object [] {ingotSteel, ingotSteel, leatherStrips, leatherStrips, Item.ingotIron, Item.ingotIron});
		addShapelessRecipe(new ItemStack(battleAxeSteel), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotSteel, leatherStrips, Item.ingotIron, Item.ingotIron});
		addShapelessRecipe(new ItemStack(greatSwordSteel), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotSteel, leatherStrips, leatherStrips, leatherStrips, Item.ingotIron, Item.ingotIron});

		addShapelessRecipe(new ItemStack(helmNordic), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotSteel, ingotEbony, ingotQuicksilver, leatherStrips});
		addShapelessRecipe(new ItemStack(chestNordic), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotSteel, ingotSteel, ingotSteel, ingotEbony, ingotQuicksilver, leatherStrips});
		addShapelessRecipe(new ItemStack(gauntletsNordic), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotEbony, ingotQuicksilver, leatherStrips, leatherStrips});
		addShapelessRecipe(new ItemStack(bootsNordic), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotSteel, ingotEbony, ingotQuicksilver, leatherStrips, leatherStrips});

		addShapelessRecipe(new ItemStack(helmElven), new Object [] {ingotMoonstone, ingotMoonstone, Item.ingotIron, Item.leather, leatherStrips});
		addShapelessRecipe(new ItemStack(chestElven), new Object [] {ingotMoonstone, ingotMoonstone, ingotMoonstone, ingotMoonstone, Item.ingotIron, Item.leather, leatherStrips, leatherStrips, leatherStrips});
		addShapelessRecipe(new ItemStack(gauntletsElven), new Object [] {ingotMoonstone, Item.ingotIron, Item.leather, leatherStrips});
		addShapelessRecipe(new ItemStack(bootsElven), new Object [] {ingotMoonstone, ingotMoonstone, Item.ingotIron, Item.leather, leatherStrips, leatherStrips});
		addShapelessRecipe(new ItemStack(chestElvenGilded), new Object [] {ingotMoonstone, ingotMoonstone, ingotMoonstone, ingotMoonstone, Item.ingotIron, ingotQuicksilver, leatherStrips, leatherStrips, leatherStrips});

		addShapelessRecipe(new ItemStack(ringSilver), new Object [] {ingotSilver});

		Collections.sort(this.recipes, new RecipesForgeSorter(this));
		System.out.println(this.recipes.size() + " recipes");
	}

	public ShapedRecipes getRecipes(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
	{
		String var3 = "";
		int var4 = 0;
		int var5 = 0;
		int var6 = 0;

		if (par2ArrayOfObj[var4] instanceof String[])
		{
			String[] var7 = (String[])((String[])par2ArrayOfObj[var4++]);

			for (int var8 = 0; var8 < var7.length; ++var8)
			{
				String var9 = var7[var8];
				++var6;
				var5 = var9.length();
				var3 = var3 + var9;
			}
		}
		else
		{
			while (par2ArrayOfObj[var4] instanceof String)
			{
				String var11 = (String)par2ArrayOfObj[var4++];
				++var6;
				var5 = var11.length();
				var3 = var3 + var11;
			}
		}

		HashMap var12;

		for (var12 = new HashMap(); var4 < par2ArrayOfObj.length; var4 += 2)
		{
			Character var13 = (Character)par2ArrayOfObj[var4];
			ItemStack var14 = null;

			if (par2ArrayOfObj[var4 + 1] instanceof Item)
			{
				var14 = new ItemStack((Item)par2ArrayOfObj[var4 + 1]);
			}
			else if (par2ArrayOfObj[var4 + 1] instanceof Block)
			{
				var14 = new ItemStack((Block)par2ArrayOfObj[var4 + 1], 1, -1);
			}
			else if (par2ArrayOfObj[var4 + 1] instanceof ItemStack)
			{
				var14 = (ItemStack)par2ArrayOfObj[var4 + 1];
			}

			var12.put(var13, var14);
		}

		ItemStack[] var15 = new ItemStack[var5 * var6];

		for (int var16 = 0; var16 < var5 * var6; ++var16)
		{
			char var10 = var3.charAt(var16);

			if (var12.containsKey(Character.valueOf(var10)))
			{
				var15[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).copy();
			}
			else
			{
				var15[var16] = null;
			}
		}

		ShapedRecipes var17 = new ShapedRecipes(var5, var6, var15, par1ItemStack);
		this.recipes.add(var17);
		return var17;
	}

	public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
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
					throw new RuntimeException("Invalid shapeless recipe");
				}

				var3.add(new ItemStack((Block)var7));
			}
		}

		this.recipes.add(new ShapelessRecipes(par1ItemStack, var3));
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

	/**
	 * returns the List<> of all recipes
	 */
	public List getRecipeList()
	{
		return this.recipes;
	}
}