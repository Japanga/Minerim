package blfngl.skyrim.tab;

import net.minecraft.creativetab.CreativeTabs;
import blfngl.skyrim.Skyrim;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class TabSkyrimFood extends CreativeTabs
{	
	public TabSkyrimFood(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return Skyrim.foodCabbage.itemID;
	}

	public String getTranslatedTabLabel()
	{
		return "Skyrim - Food";
	}
}