package blfngl.skyrim.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseDrink extends ItemFood
{
	public BaseDrink(int par1, int par2, float par3, boolean par4)
	{
		super(par1, par2, par3, par4);
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.drink;
	}

	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("skyrim:" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}