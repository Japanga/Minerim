package blfngl.skyrim.handler;

import net.minecraftforge.common.MinecraftForge;
import blfngl.skyrim.Skyrim;
import blfngl.skyrim.block.BlockBase;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks extends Skyrim
{
	public static void init()
	{
		MinecraftForge.setBlockHarvestLevel(oreCorundum, "pickaxe", 2);
		GameRegistry.registerBlock(oreCorundum, "Corundum Ore");
		MinecraftForge.setBlockHarvestLevel(oreEbony, "pickaxe", 3);
		GameRegistry.registerBlock(oreEbony, "Ebony Ore");
		MinecraftForge.setBlockHarvestLevel(oreMalachite, "pickaxe", 2);
		GameRegistry.registerBlock(oreMalachite, "Malachite Ore");
		MinecraftForge.setBlockHarvestLevel(oreQuicksilver, "pickaxe", 1);
		GameRegistry.registerBlock(oreQuicksilver, "Quicksilver Ore");
		MinecraftForge.setBlockHarvestLevel(oreSilver, "pickaxe", 2);
		GameRegistry.registerBlock(oreSilver, "Silver Ore");
		MinecraftForge.setBlockHarvestLevel(oreMoonstone, "pickaxe", 3);
		GameRegistry.registerBlock(oreMoonstone, "Moonstone Ore");
		MinecraftForge.setBlockHarvestLevel(oreOrichalcum, "pickaxe", 2);
		GameRegistry.registerBlock(oreOrichalcum, "Orichalcum Ore");
		MinecraftForge.setBlockHarvestLevel(smelterIdle, "pickaxe", 3);
		GameRegistry.registerBlock(smelterIdle, "Smelter");
		MinecraftForge.setBlockHarvestLevel(smelterActive, "pickaxe", 3);
		GameRegistry.registerBlock(smelterActive, "SmelterActive");
		MinecraftForge.setBlockHarvestLevel(grindstone, "pickaxe", 3);
		GameRegistry.registerBlock(grindstone, "GrindstoneIdle");
		//MinecraftForge.setBlockHarvestLevel(grindstoneActive, "pickaxe", 3);
		//GameRegistry.registerBlock(grindstoneActive, "GrindstoneActive");
		
		MinecraftForge.setBlockHarvestLevel(oreStalhrim, "pickaxe", 4);
		GameRegistry.registerBlock(oreStalhrim, "Stalhrim Ore");
		MinecraftForge.setBlockHarvestLevel(forge, "pickaxe", 3);
		GameRegistry.registerBlock(forge, "Forge");
		
		MinecraftForge.setBlockHarvestLevel(levelUp, "pickaxe", 1);
		GameRegistry.registerBlock(levelUp, "LevelUp");
		MinecraftForge.setBlockHarvestLevel(arcaneEnchanter, "pickaxe", 2);
		GameRegistry.registerBlock(arcaneEnchanter, "ArcaneEnchanter");
		//GameRegistry.registerBlock(chestSkyrim, "ChestSkyrim");
		//MinecraftForge.setBlockHarvestLevel(chestSkyrim, "axe", 2);
	}
}
