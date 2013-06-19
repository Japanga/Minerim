package blfngl.skyrim.item;

import java.util.List;
import java.util.Random;

import blfngl.skyrim.Skyrim;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BaseSword extends Item
{
	public int damage;
	public String name;
	public double speed;
	Random rand = new Random();

	public BaseSword(int var1, int var2, int var3)
	{
		super(var1);
		this.setMaxDamage(-1);
		damage = var2;
		speed = var3;
		setCreativeTab(Skyrim.TabSkyrimCombat);
		setMaxStackSize(1);
	}

	public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
	{
		return true;
	}

	public int getDamageVsEntity(Entity par1Entity)
	{
		return damage;
	}

	public void func_94581_a(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		var3.add("Damage: " + (double)damage/2 + " Heart(s)");
		if(name !=null)
		{var3.add("Crafted By: " + name);}
		else
		{var3.add("No Owner");}
	}

	public void onUpdate(ItemStack par1ItemStack, World var2, Entity par3Entity, int par4, boolean par5) 
	{
		EntityPlayer player = (EntityPlayer)par3Entity;
		if(player.getHeldItem()==par1ItemStack)
		{
			if(speed == -1){player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20, 0));}
			if(speed == -2){player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20, 1));}
			if(speed == -3){player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20, 2));}
		}
	}

	public boolean isFull3D()
	{
		return true;
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.block;
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 72000;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}
}