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
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(dwemmerLargePlate), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(dwemmerSmallPlate), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(dwemmerMetal), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(dwemmerStrut), 2, 5, 20));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(saltPile), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(saltPile), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(saltPile), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(saltPile), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(saltPile), 2, 5, 20));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(saltPile), 2, 5, 20));

		MinecraftForge.addGrassSeed(new ItemStack(foodCabbage), 5);
		MinecraftForge.addGrassSeed(new ItemStack(garlic), 5);
		MinecraftForge.addGrassSeed(new ItemStack(leek), 5);

	}
}
