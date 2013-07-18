package blfngl.skyrim.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import blfngl.skyrim.Skyrim;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class TabSkyrimBlocks extends CreativeTabs
{
	public TabSkyrimBlocks(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return new ItemStack(Skyrim.oreCorundum).itemID;
	}

	public String getTranslatedTabLabel()
	{
		return "Skyrim - Blocks";
	}
}