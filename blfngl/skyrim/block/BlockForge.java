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
	private Icon forgeTop;
	@SideOnly(Side.CLIENT)
	private Icon forgeSide;
	@SideOnly(Side.CLIENT)
	private Icon forgeFront;

	public BlockForge(int par1)
	{
		super(par1, Material.rock);
		this.setCreativeTab(Skyrim.TabSkyrimBlocks);
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.forgeTop : (par1 == 0 ? this.forgeTop : (par1 != par2 ? this.blockIcon : this.forgeFront));
	}

	@SideOnly(Side.CLIENT)

	public void registerIcons(IconRegister par1IconRegister)
	{
		blockIcon = par1IconRegister.registerIcon("skyrim:forgeSide");
		forgeTop = par1IconRegister.registerIcon("skyrim:forgeTop");
		forgeSide = par1IconRegister.registerIcon("skyrim:forgeSide");
		forgeFront = par1IconRegister.registerIcon("skyrim:forgeSide");
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