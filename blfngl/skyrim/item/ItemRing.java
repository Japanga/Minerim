package blfngl.skyrim.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import blfngl.skyrim.Skyrim;

public class ItemRing extends BaseItem
{
	public boolean isEquipped;
	public Potion boost;
	public int modifier;

	public ItemRing(int par1, Potion par2, int par3)
	{
		super(par1);
		boost = par2;
		modifier = par3;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par1ItemStack.stackTagCompound == null){par1ItemStack.setTagCompound(new NBTTagCompound());}
		if (!isEquipped && Skyrim.getRings < 10)
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
		var3.add("Rings Equipped: " + Skyrim.getRings);
	}

	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par1ItemStack.stackTagCompound == null){par1ItemStack.setTagCompound(new NBTTagCompound());}
		par1ItemStack.stackTagCompound.setBoolean("Equipped", false);
	}

	public void onUpdate(ItemStack par1ItemStack, World var2, Entity par3Entity, int par4, boolean par5) 
	{
		if (par1ItemStack.stackTagCompound == null){par1ItemStack.setTagCompound(new NBTTagCompound());}
		isEquipped = par1ItemStack.stackTagCompound.getBoolean("Equipped");
		if (par1ItemStack.stackTagCompound.getBoolean("Equipped"))
		{
			((EntityLiving) par3Entity).addPotionEffect(new PotionEffect(boost.id, 20, modifier));
		}
	}
}