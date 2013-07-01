package blfngl.skyrim.block;

import java.util.Random;

import blfngl.skyrim.Skyrim;

import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BlockGeodeOre extends BlockOre
{
	public BlockGeodeOre(int var1)
	{
		super(var1);
	}

	public void func_94332_a(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("skyrim" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	public int idDropped(int par1, Random random, int par2)
	{
		if (random.nextInt(100) + 1> 80){return Skyrim.amethyst.itemID;}
		else if (random.nextInt(100) + 1> 60){return Item.emerald.itemID;}
		else if (random.nextInt(100) + 1> 40){return Item.diamond.itemID;}
		else if (random.nextInt(100) + 1 > 20){return Skyrim.ruby.itemID;}
		else {return Skyrim.garnet.itemID;}
	}
}