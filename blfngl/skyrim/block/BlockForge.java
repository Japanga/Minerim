package blfngl.skyrim.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import blfngl.skyrim.Skyrim;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockForge extends Block
{

	@SideOnly(Side.CLIENT)
	private Icon field_94385_a;
	@SideOnly(Side.CLIENT)
	private Icon field_94384_b;

	public BlockForge(int par1)
	{
		super(par1, Material.rock);
		this.setCreativeTab(Skyrim.TabSkyrimBlocks);
	}

	@SideOnly(Side.CLIENT)

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		return par1 == 1 ? this.field_94385_a : (par1 == 0 ? Block.planks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.field_94384_b));
	}

	@SideOnly(Side.CLIENT)

	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("MTJT:smithsBenchSide2");
		this.field_94385_a = par1IconRegister.registerIcon("MTJT:smithsBenchTop");
		this.field_94384_b = par1IconRegister.registerIcon("MTJT:smithsBenchSide1");
	}

	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9)
	{
		if (player.isSneaking()){return false;}
		else
		{
			player.openGui(Skyrim.instance, 3, var1, var2, var3, var4);
			return true;
		}
	}
}