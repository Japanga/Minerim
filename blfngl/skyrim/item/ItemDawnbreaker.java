package blfngl.skyrim.item;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemDawnbreaker extends BaseSword
{
	public ItemDawnbreaker(int var1, int var2, int var3, Item var4)
	{
		super(var1, var2, var3, var4);
	}

	public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
	{
		par2EntityLiving.setFire(20);
		return true;
	}
}