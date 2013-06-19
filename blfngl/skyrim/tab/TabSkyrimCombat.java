package blfngl.skyrim.tab;

import net.minecraft.creativetab.CreativeTabs;
import blfngl.skyrim.Skyrim;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class TabSkyrimCombat extends CreativeTabs
{
	public TabSkyrimCombat(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return Skyrim.daggerDaedric.itemID;
	}

	public String getTranslatedTabLabel()
	{
		return "Skyrim - Weapons";
	}
}