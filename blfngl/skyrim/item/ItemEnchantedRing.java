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
		if (par1ItemStack.stackTagCompound.getBoolean("Equipped") == false && Skyrim.ringCheck == false)
		{
			par1ItemStack.stackTagCompound.setBoolean("Equipped", true);
			Skyrim.ringCheck = true;
		}

		else
		{
			par1ItemStack.stackTagCompound.setBoolean("Equipped", false);
			Skyrim.ringCheck = false;
		}

		return par1ItemStack;
	}

	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if (var1.stackTagCompound == null){var1.setTagCompound(new NBTTagCompound());}
		if (var1.stackTagCompound.getBoolean("Equipped") == true){var3.add("Currently Equipped");}
		if (var1.stackTagCompound.getBoolean("FortifyBlock") == true){var3.add("Fortify Block");}
		if (var1.stackTagCompound.getBoolean("FortifyRegen") == true){var3.add("Fortify Health Regeneration");}
		if (var1.stackTagCompound.getBoolean("Waterbreath") == true){var3.add("Waterbreathing");}
	}

	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par1ItemStack.stackTagCompound == null){par1ItemStack.setTagCompound(new NBTTagCompound());}
		par1ItemStack.stackTagCompound.setBoolean("Equipped", false);
		par1ItemStack.stackTagCompound.setBoolean("FortifyBlock", false);
		par1ItemStack.stackTagCompound.setBoolean("FortifyRegen", false);
		par1ItemStack.stackTagCompound.setBoolean("Waterbreath", false);

		if (rand.nextInt(3) == 0)
		{
			par1ItemStack.stackTagCompound.setBoolean("FortifyBlock", true);
		}

		if (rand.nextInt(3) == 1)
		{
			par1ItemStack.stackTagCompound.setBoolean("FortifyRegen", true);
		}

		if (rand.nextInt(3) == 2)
		{
			par1ItemStack.stackTagCompound.setBoolean("Waterbreath", true);
		}
	}

	public void onUpdate(ItemStack par1ItemStack, World var2, Entity par3Entity, int par4, boolean par5) 
	{
		if (par1ItemStack.stackTagCompound == null){par1ItemStack.setTagCompound(new NBTTagCompound());}

		if (par1ItemStack.stackTagCompound.getBoolean("FortifyBlock") && par1ItemStack.stackTagCompound.getBoolean("Equipped"))
		{
			((EntityLiving) par3Entity).addPotionEffect(new PotionEffect(Potion.resistance.id, 20));
		}

		if (par1ItemStack.stackTagCompound.getBoolean("FortifyRegen") && par1ItemStack.stackTagCompound.getBoolean("Equipped"))
		{
			((EntityLiving) par3Entity).addPotionEffect(new PotionEffect(Potion.regeneration.id, 20));
		}

		if (par1ItemStack.stackTagCompound.getBoolean("Waterbreath") && par1ItemStack.stackTagCompound.getBoolean("Equipped"))
		{
			((EntityLiving) par3Entity).addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 20));
		}
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
	{
		if (item.stackTagCompound == null){item.setTagCompound(new NBTTagCompound());}
		if (item.stackTagCompound.getBoolean("Equipped") == true)
		{
			item.stackTagCompound.setBoolean("Equipped", false);
			Skyrim.ringCheck = false;
		}
		return true;
	}

	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}