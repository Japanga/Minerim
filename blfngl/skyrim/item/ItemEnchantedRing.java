package blfngl.skyrim.item;

import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import blfngl.skyrim.Skyrim;

public class ItemEnchantedRing extends Item
{
	Random rand = new Random();

	public ItemEnchantedRing(int par1)
	{
		super(par1);
		setMaxStackSize(1);
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par1ItemStack.stackTagCompound == null){par1ItemStack.setTagCompound(new NBTTagCompound());}
		if (par1ItemStack.stackTagCompound.getBoolean("Equipped") == false && Skyrim.getRings < 20)
		{
			par1ItemStack.stackTagCompound.setBoolean("Equipped", true);
			Skyrim.getRings += 1;
		}

		else
		{
			par1ItemStack.stackTagCompound.setBoolean("Equipped", false);
			Skyrim.getRings -= 1;
		}

		return par1ItemStack;
	}

	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if (var1.stackTagCompound == null){var1.setTagCompound(new NBTTagCompound());}
		if (var1.stackTagCompound.getBoolean("Equipped") == true){var3.add("Currently Equipped");}
		if (var1.stackTagCompound.getBoolean("FortifyBlock") == true){var3.add("Fortify Block");}
		var3.add("Rings Equipped: " + Skyrim.getRings / 2);
	}

	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par1ItemStack.stackTagCompound == null){par1ItemStack.setTagCompound(new NBTTagCompound());}
		par1ItemStack.stackTagCompound.setBoolean("Equipped", false);
		par1ItemStack.stackTagCompound.setBoolean("FortifyBlock", false);

		if (rand.nextInt(4) == 0)
		{
			par1ItemStack.stackTagCompound.setBoolean("FortifyBlock", true);
		}
	}

	public void onUpdate(ItemStack par1ItemStack, World var2, Entity par3Entity, int par4, boolean par5) 
	{
		if (par1ItemStack.stackTagCompound == null){par1ItemStack.setTagCompound(new NBTTagCompound());}
		//isEquipped = par1ItemStack.stackTagCompound.getBoolean("Equipped");

		if (par1ItemStack.stackTagCompound.getBoolean("FortifyBlock") && par1ItemStack.stackTagCompound.getBoolean("Equipped"))
		{
			((EntityLiving) par3Entity).addPotionEffect(new PotionEffect(Potion.resistance.id, 20));
		}
	}

	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}