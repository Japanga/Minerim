package blfngl.skyrim.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import blfngl.skyrim.Skyrim;

public class BlockBase extends BlockOre
{
	public static int block;

	public BlockBase(int var1, int var2, Material var3, float var4, String var5)
	{
		super(var1);
		setHardness(var4);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(var5);
		setCreativeTab(Skyrim.TabSkyrimBlocks);
		block = var1;
	}

	public void func_94332_a(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("skyrim" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	public int idDropped(int par1, Random random, int par2)
	{
		return this.blockID;
	}
}