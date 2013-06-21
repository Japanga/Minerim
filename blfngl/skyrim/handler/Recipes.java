package blfngl.skyrim.handler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import blfngl.skyrim.Skyrim;
import blfngl.skyrim.block.BlockBase;
import blfngl.skyrim.item.BaseArmor;
import blfngl.skyrim.item.BaseItem;
import blfngl.skyrim.item.BasePick;
import blfngl.skyrim.item.BaseSword;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes extends Skyrim
{
	public static void init()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(leatherStrips, 4), new Object [] {Item.leather});

		GameRegistry.addSmelting(dwemmerBentScrap.itemID, new ItemStack(ingotDwarven, 3), 0.1f);
		GameRegistry.addSmelting(dwemmerLargePlate.itemID, new ItemStack(ingotDwarven, 3), 0.1f);
		GameRegistry.addSmelting(dwemmerSmallPlate.itemID, new ItemStack(ingotDwarven, 3), 0.1f);
		GameRegistry.addSmelting(dwemmerMetal.itemID, new ItemStack(ingotDwarven, 5), 0.1f);
		GameRegistry.addSmelting(dwemmerStrut.itemID, new ItemStack(ingotDwarven, 3), 0.1f);

		GameRegistry.addShapelessRecipe(new ItemStack(foodAppleCabbageStew), new Object [] {Item.appleRed, foodCabbage, saltPile, Item.bowlEmpty});
		GameRegistry.addShapelessRecipe(new ItemStack(foodApplePie), new Object [] {sackFlour, butter, Item.appleRed, Item.appleRed, Item.egg, saltPile, saltPile});
		GameRegistry.addShapelessRecipe(new ItemStack(foodBeefStew), new Object [] {Item.beefCooked, Item.carrot, saltPile, garlic, Item.bowlEmpty});
		GameRegistry.addShapelessRecipe(new ItemStack(foodCabbagePotatoSoup), new Object [] {saltPile, Item.potato, leek, foodCabbage, Item.bowlEmpty});
		GameRegistry.addShapelessRecipe(new ItemStack(butter), new Object [] {Item.bucketMilk});

		GameRegistry.addShapelessRecipe(new ItemStack(firewood), new Object [] {Block.planks, Item.axeStone});

		GameRegistry.addRecipe(new ItemStack(smelterIdle), new Object [] {" X ", "*&*", "%%%", 'X', Block.stone, '*', Block.fenceIron, '%', Item.ingotIron, '&', Block.furnaceIdle});
		GameRegistry.addRecipe(new ItemStack(forge), new Object [] {"XXX", " * ", "%$%", 'X', Block.stone, '*', Block.anvil, '%', Item.ingotIron, '$', Block.workbench});

		//GameRegistry.addShapelessRecipe(new ItemStack(helmAncientNord), new Object [] {});
		//GameRegistry.addShapelessRecipe(new ItemStack(chestAncientNord), new Object [] {});
		//GameRegistry.addShapelessRecipe(new ItemStack(gauntletsAncientNord), new Object [] {});
		//GameRegistry.addShapelessRecipe(new ItemStack(bootsAncientNord), new Object [] {});
	}
}
