package blfngl.skyrim.handler;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import blfngl.skyrim.Skyrim;
import blfngl.skyrim.block.WorldGenSkyrim;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldHandler extends Skyrim
{
	public static void init()
	{
		GameRegistry.registerWorldGenerator(new WorldGenSkyrim());

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(dwemmerBentScrap), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(dwemmerLargePlate), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(dwemmerSmallPlate), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(dwemmerMetal), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(dwemmerStrut), 2, 5, 20));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(saltPile), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(saltPile), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(saltPile), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(saltPile), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(saltPile), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(saltPile), 2, 5, 20));

		MinecraftForge.addGrassSeed(new ItemStack(foodCabbage), 5);
		MinecraftForge.addGrassSeed(new ItemStack(garlic), 5);
		MinecraftForge.addGrassSeed(new ItemStack(leek), 5);

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ancientPick), 1, 1, 10));
	}
}
