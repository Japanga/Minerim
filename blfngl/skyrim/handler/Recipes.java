package blfngl.skyrim.handler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import blfngl.skyrim.Skyrim;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes extends Skyrim
{
	public static void init()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(leatherStrips, 4), new Object [] {Item.leather});
		GameRegistry.addShapelessRecipe(new ItemStack(daggerEbony), new Object [] {leatherStrips, ingotEbony});
		GameRegistry.addShapelessRecipe(new ItemStack(swordEbony), new Object [] {leatherStrips, ingotEbony, ingotEbony});
		GameRegistry.addShapelessRecipe(new ItemStack(greatSwordEbony), new Object [] {leatherStrips, leatherStrips, leatherStrips, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony});
		GameRegistry.addShapelessRecipe(new ItemStack(warAxeEbony), new Object [] {leatherStrips, leatherStrips, ingotEbony, ingotEbony});
		GameRegistry.addShapelessRecipe(new ItemStack(battleAxeEbony), new Object [] {leatherStrips, leatherStrips, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony});
		GameRegistry.addShapelessRecipe(new ItemStack(maceEbony), new Object [] {leatherStrips, ingotEbony, ingotEbony, ingotEbony});
		GameRegistry.addShapelessRecipe(new ItemStack(warhammerEbony), new Object [] {leatherStrips, leatherStrips, leatherStrips, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony});

		GameRegistry.addShapelessRecipe(new ItemStack(daggerGlass), new Object [] {leatherStrips, ingotMalachite, ingotMoonstone});
		GameRegistry.addShapelessRecipe(new ItemStack(swordGlass), new Object [] {leatherStrips, ingotMalachite, ingotMalachite, ingotMoonstone});
		GameRegistry.addShapelessRecipe(new ItemStack(greatSwordGlass), new Object [] {leatherStrips, leatherStrips, leatherStrips, ingotMalachite, ingotMalachite, ingotMoonstone, ingotMoonstone});
		GameRegistry.addShapelessRecipe(new ItemStack(warAxeGlass), new Object [] {leatherStrips, leatherStrips, ingotMalachite, ingotMoonstone});
		GameRegistry.addShapelessRecipe(new ItemStack(battleAxeGlass), new Object [] {leatherStrips, leatherStrips, ingotMalachite, ingotMalachite, ingotMoonstone, ingotMoonstone});
		GameRegistry.addShapelessRecipe(new ItemStack(maceGlass), new Object [] {leatherStrips, ingotMalachite, ingotMoonstone, ingotMoonstone});
		GameRegistry.addShapelessRecipe(new ItemStack(warhammerGlass), new Object [] {leatherStrips, leatherStrips, leatherStrips, ingotMalachite, ingotMalachite, ingotMoonstone, ingotMoonstone, ingotMoonstone});

		GameRegistry.addShapelessRecipe(new ItemStack(daggerDaedric), new Object [] {leatherStrips, ingotEbony, daedraHeart});
		GameRegistry.addShapelessRecipe(new ItemStack(swordDaedric), new Object [] {leatherStrips, ingotEbony, ingotEbony, daedraHeart});
		GameRegistry.addShapelessRecipe(new ItemStack(greatSwordDaedric), new Object [] {leatherStrips, leatherStrips, leatherStrips, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony, daedraHeart});
		GameRegistry.addShapelessRecipe(new ItemStack(warAxeDaedric), new Object [] {leatherStrips, leatherStrips, ingotEbony, ingotEbony, daedraHeart});
		GameRegistry.addShapelessRecipe(new ItemStack(battleAxeDaedric), new Object [] {leatherStrips, leatherStrips, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony, daedraHeart});
		GameRegistry.addShapelessRecipe(new ItemStack(maceDaedric), new Object [] {leatherStrips, ingotEbony, ingotEbony, ingotEbony, daedraHeart});
		GameRegistry.addShapelessRecipe(new ItemStack(warhammerDaedric), new Object [] {leatherStrips, leatherStrips, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony, daedraHeart});

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

		GameRegistry.addShapelessRecipe(new ItemStack(arrowDwarven, 24), new Object [] {firewood, ingotDwarven});
		GameRegistry.addShapelessRecipe(new ItemStack(arrowDaedric, 24), new Object [] {firewood, ingotEbony, daedraHeart});
		GameRegistry.addShapelessRecipe(new ItemStack(arrowGlass, 24), new Object [] {firewood, ingotMalachite});
		GameRegistry.addShapelessRecipe(new ItemStack(arrowDragonbone, 24), new Object [] {firewood, dragonBone});
		GameRegistry.addShapelessRecipe(new ItemStack(arrowIron, 24), new Object [] {firewood, Item.ingotIron});

		GameRegistry.addShapelessRecipe(new ItemStack(firewood), new Object [] {Block.planks, Item.axeStone});

		GameRegistry.addShapelessRecipe(new ItemStack(helmDwarf), new Object [] {ingotDwarven, ingotDwarven, leatherStrips, leatherStrips, ingotSteel, Item.ingotIron});
		GameRegistry.addShapelessRecipe(new ItemStack(chestDwarf), new Object [] {ingotDwarven, ingotDwarven, ingotDwarven, leatherStrips, leatherStrips, leatherStrips, ingotSteel, Item.ingotIron});
		GameRegistry.addShapelessRecipe(new ItemStack(gauntletsDwarf), new Object [] {ingotDwarven, leatherStrips, leatherStrips, ingotSteel, Item.ingotIron});
		GameRegistry.addShapelessRecipe(new ItemStack(bootsDwarf), new Object [] {ingotDwarven, ingotDwarven, leatherStrips, ingotSteel, Item.ingotIron});

		GameRegistry.addShapelessRecipe(new ItemStack(helmEbony), new Object [] {ingotEbony, ingotEbony, ingotEbony, ingotEbony, leatherStrips, leatherStrips});
		GameRegistry.addShapelessRecipe(new ItemStack(chestEbony), new Object [] {ingotEbony, ingotEbony, ingotEbony, ingotEbony, ingotEbony, leatherStrips, leatherStrips, leatherStrips, leatherStrips});
		GameRegistry.addShapelessRecipe(new ItemStack(gauntletsEbony), new Object [] {ingotEbony, ingotEbony, leatherStrips, leatherStrips});
		GameRegistry.addShapelessRecipe(new ItemStack(bootsEbony), new Object [] {ingotEbony, ingotEbony, ingotEbony, leatherStrips, leatherStrips});

		GameRegistry.addShapelessRecipe(new ItemStack(helmGlass), new Object [] {leatherStrips, ingotMalachite, ingotMalachite, ingotMoonstone, Item.leather});
		GameRegistry.addShapelessRecipe(new ItemStack(chestGlass), new Object [] {leatherStrips, leatherStrips, leatherStrips, ingotMalachite, ingotMalachite, ingotMalachite, ingotMalachite, ingotMoonstone, ingotMoonstone});
		GameRegistry.addShapelessRecipe(new ItemStack(gauntletsGlass), new Object [] {leatherStrips, leatherStrips, ingotMalachite, ingotMoonstone, Item.leather});
		GameRegistry.addShapelessRecipe(new ItemStack(bootsGlass), new Object [] {leatherStrips, leatherStrips, ingotMalachite, ingotMalachite, ingotMoonstone, Item.leather});

		GameRegistry.addShapelessRecipe(new ItemStack(daggerOrc), new Object [] {ingotOrichalcum, leatherStrips, Item.ingotIron});
		GameRegistry.addShapelessRecipe(new ItemStack(swordOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, leatherStrips, Item.ingotIron});
		GameRegistry.addShapelessRecipe(new ItemStack(greatSwordOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, leatherStrips, Item.ingotIron});
		GameRegistry.addShapelessRecipe(new ItemStack(warAxeOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, Item.ingotIron});
		GameRegistry.addShapelessRecipe(new ItemStack(battleAxeOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, Item.ingotIron});
		GameRegistry.addShapelessRecipe(new ItemStack(maceOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, Item.ingotIron});
		GameRegistry.addShapelessRecipe(new ItemStack(warhammerOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, leatherStrips, Item.ingotIron, Item.ingotIron});

		GameRegistry.addShapelessRecipe(new ItemStack(helmOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, Item.ingotIron});
		GameRegistry.addShapelessRecipe(new ItemStack(chestOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, leatherStrips, Item.ingotIron});
		GameRegistry.addShapelessRecipe(new ItemStack(gauntletsOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, Item.ingotIron});
		GameRegistry.addShapelessRecipe(new ItemStack(bootsOrc), new Object [] {ingotOrichalcum, ingotOrichalcum, ingotOrichalcum, leatherStrips, leatherStrips, leatherStrips, Item.ingotIron});

		GameRegistry.addRecipe(new ItemStack(smelterIdle), new Object [] {" X ", "*&*", "%%%", 'X', Block.stone, '*', Block.fenceIron, '%', Item.ingotIron, '&', Block.furnaceIdle});

		GameRegistry.addShapelessRecipe(new ItemStack(daggerStalhrim), new Object [] {stalhrim, leatherStrips});
		GameRegistry.addShapelessRecipe(new ItemStack(warhammerStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, stalhrim, stalhrim, leatherStrips, leatherStrips, leatherStrips, leatherStrips});
		GameRegistry.addShapelessRecipe(new ItemStack(swordStalhrim), new Object [] {stalhrim, stalhrim, leatherStrips});
		GameRegistry.addShapelessRecipe(new ItemStack(maceStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, leatherStrips});
		GameRegistry.addShapelessRecipe(new ItemStack(warAxeStalhrim), new Object [] {stalhrim, stalhrim, leatherStrips, leatherStrips});
		GameRegistry.addShapelessRecipe(new ItemStack(battleAxeStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, stalhrim, stalhrim, leatherStrips, leatherStrips});
		GameRegistry.addShapelessRecipe(new ItemStack(greatSwordStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, stalhrim, stalhrim, leatherStrips, leatherStrips, leatherStrips});

		GameRegistry.addShapelessRecipe(new ItemStack(helmStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, stalhrim, ingotQuicksilver, leatherStrips});
		GameRegistry.addShapelessRecipe(new ItemStack(chestStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, stalhrim, stalhrim, ingotQuicksilver, leatherStrips, leatherStrips});
		GameRegistry.addShapelessRecipe(new ItemStack(gauntletsStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, ingotQuicksilver, leatherStrips, leatherStrips});
		GameRegistry.addShapelessRecipe(new ItemStack(bootsStalhrim), new Object [] {stalhrim, stalhrim, stalhrim, stalhrim, ingotQuicksilver, leatherStrips, leatherStrips});

		GameRegistry.addShapelessRecipe(new ItemStack(daggerNordic), new Object [] {ingotSteel, leatherStrips, ingotQuicksilver});
		GameRegistry.addShapelessRecipe(new ItemStack(warhammerNordic), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotSteel, ingotSteel, ingotSteel, leatherStrips, ingotQuicksilver});
		GameRegistry.addShapelessRecipe(new ItemStack(swordNordic), new Object [] {ingotSteel, ingotSteel, leatherStrips, ingotQuicksilver});
		GameRegistry.addShapelessRecipe(new ItemStack(maceNordic), new Object [] {ingotSteel, leatherStrips, leatherStrips, ingotQuicksilver});
		GameRegistry.addShapelessRecipe(new ItemStack(warAxeNordic), new Object [] {ingotSteel, ingotSteel, leatherStrips, leatherStrips, ingotQuicksilver});
		GameRegistry.addShapelessRecipe(new ItemStack(battleAxeNordic), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotSteel, ingotSteel, leatherStrips, leatherStrips, ingotQuicksilver});
		GameRegistry.addShapelessRecipe(new ItemStack(greatSwordNordic), new Object [] {ingotSteel, ingotSteel, ingotSteel, ingotSteel, ingotSteel, leatherStrips, leatherStrips, leatherStrips, ingotQuicksilver});
	}
}
