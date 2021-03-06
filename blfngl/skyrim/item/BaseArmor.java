package blfngl.skyrim.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import blfngl.skyrim.Skyrim;

public class BaseArmor extends ItemArmor
{
	public String type;
	public String textureFile;
	public Item repairMaterial;

	public BaseArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String par5, String par6, Item par7)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		setCreativeTab(Skyrim.TabSkyrimArmor);
		//setMaxDamage(-1);
		type = par5;
		textureFile = par6;
		canRepair = true;
		repairMaterial = par7;
	}

	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("skyrim:" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	public String getArmorTextureFile(ItemStack par1)
	{
		return "/mods/skyrim/armor/" + textureFile;
	}

	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		var3.add(type + " Armor");
		var3.add("Repair Material: " + repairMaterial.getItemDisplayName(new ItemStack(repairMaterial)));
		var3.add("Total Damage Reduction " + (getArmorMaterial().getEnchantability() + 50) + "%");
	}

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return repairMaterial.itemID == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
}