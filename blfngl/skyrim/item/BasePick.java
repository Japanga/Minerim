package blfngl.skyrim.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class BasePick extends ItemPickaxe
{
	public BasePick(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, par2EnumToolMaterial);
	}

	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("skyrim:" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}
