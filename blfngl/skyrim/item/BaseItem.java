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

	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("skyrim:" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}