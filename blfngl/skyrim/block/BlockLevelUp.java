package blfngl.skyrim.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import blfngl.skyrim.Skyrim;

public class BlockLevelUp extends Block
{
	public BlockLevelUp(int par1, Material par2Material)
	{
		super(par1, par2Material);
		setCreativeTab(Skyrim.TabSkyrimBlocks);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float a, float b, float c)
	{
		player.openGui(Skyrim.instance, 4, world, x, y, z);
		return true;
	}
}