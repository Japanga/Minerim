package blfngl.skyrim.handler;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import blfngl.skyrim.Skyrim;
import blfngl.skyrim.block.WorldGenCorundum;
import blfngl.skyrim.block.WorldGenEbony;
import blfngl.skyrim.block.WorldGenMalachite;
import blfngl.skyrim.block.WorldGenMoonstone;
import blfngl.skyrim.block.WorldGenOrichalcum;
import blfngl.skyrim.block.WorldGenQuicksilver;
import blfngl.skyrim.block.WorldGenSilver;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldHandler extends Skyrim
{
	public static void init()
	{
		GameRegistry.registerWorldGenerator(new WorldGenCorundum());
		GameRegistry.registerWorldGenerator(new WorldGenMalachite());
		GameRegistry.registerWorldGenerator(new WorldGenEbony());
		GameRegistry.registerWorldGenerator(new WorldGenQuicksilver());
		GameRegistry.registerWorldGenerator(new WorldGenMoonstone());
		GameRegistry.registerWorldGenerator(new WorldGenSilver());
		GameRegistry.registerWorldGenerator(new WorldGenOrichalcum());

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
