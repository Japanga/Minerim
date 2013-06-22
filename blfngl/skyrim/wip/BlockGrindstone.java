package blfngl.skyrim.wip;

import blfngl.skyrim.Skyrim;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGrindstone extends Block
{
	@SideOnly(Side.CLIENT)
	private Icon forgeIconTop;
	@SideOnly(Side.CLIENT)
	private Icon forgeIconFront;
	@SideOnly(Side.CLIENT)
	private Icon forgeIconBottom;

	public BlockGrindstone(int var1)
	{
		super(var1, Material.rock);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int var1, int var2)
	{
		return var1 == 1 ? this.forgeIconTop : (var1 == 0 ? this.forgeIconBottom : (var1 != 2 && var1 != 4 ? this.blockIcon : this.forgeIconFront));
	}

	@SideOnly(Side.CLIENT)

	public void registerIcons(IconRegister var1)
	{
		this.blockIcon = var1.registerIcon("blfngl:grindstone");
		this.forgeIconTop = var1.registerIcon("blfngl:grindstone");
		this.forgeIconFront = var1.registerIcon("blfngl:grindstone");
		this.forgeIconBottom = var1.registerIcon("blfngl:grindstone");
	}

	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
	{
		var5.openGui(Skyrim.instance, 3, var1, var2, var3, var4);
		return true;
	}
}
