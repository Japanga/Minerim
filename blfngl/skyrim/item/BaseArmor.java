package blfngl.skyrim.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import blfngl.skyrim.Skyrim;

public class BaseArmor extends ItemArmor implements IArmorTextureProvider
{
	public String type;
	public String textureFile;

	public BaseArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String par5, String par6)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		setCreativeTab(Skyrim.TabSkyrimArmor);
		type = par5;
		textureFile = par6;
	}

	public void func_94581_a(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("skyrim" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	public String getArmorTextureFile(ItemStack par1)
	{
		return "/mods/skyrim/armor/" + textureFile;
	}

	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		var3.add(type + " Armor");
	}
}