package blfngl.skyrim.item;

import blfngl.skyrim.Skyrim;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BaseItem extends Item
{
	public BaseItem(int par1)
	{
		super(par1);
		setCreativeTab(Skyrim.TabSkyrimItems);
	}

	public void func_94581_a(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}