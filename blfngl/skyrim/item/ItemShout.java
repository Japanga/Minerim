package blfngl.skyrim.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import blfngl.skyrim.entity.EntityShout;

public class ItemShout extends BaseItem
{

	public ItemShout(int par1)
	{
		super(par1);
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par2World.spawnEntityInWorld(new EntityShout(par3EntityPlayer, par2World));
		
		return par1ItemStack;
	}
}
