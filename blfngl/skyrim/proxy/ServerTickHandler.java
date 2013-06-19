package blfngl.skyrim.proxy;

import java.util.EnumSet;

import blfngl.skyrim.Skyrim;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler
{

	private void onPlayerTick(EntityPlayer player)
	{
		if(player.getCurrentItemOrArmor(1) != null && player.getCurrentItemOrArmor(2) != null
				&& player.getCurrentItemOrArmor(3) != null && player.getCurrentItemOrArmor(4) != null)
		{
			ItemStack boots = player.getCurrentItemOrArmor(1);
			ItemStack legs = player.getCurrentItemOrArmor(2);
			ItemStack chest = player.getCurrentItemOrArmor(3);
			ItemStack helm = player.getCurrentItemOrArmor(4);

			if(helm.itemID == Skyrim.helmDaedric.itemID && chest.itemID == Skyrim.chestDaedric.itemID && legs.itemID == Skyrim.gauntletsDaedric.itemID
					&& boots.itemID == Skyrim.bootsDaedric.itemID
					||helm.itemID == Skyrim.helmDwarf.itemID && chest.itemID == Skyrim.chestDwarf.itemID && legs.itemID == Skyrim.gauntletsDwarf.itemID
					&& boots.itemID == Skyrim.bootsDwarf.itemID
					||helm.itemID == Skyrim.helmEbony.itemID && chest.itemID == Skyrim.chestEbony.itemID && legs.itemID == Skyrim.gauntletsEbony.itemID
					&& boots.itemID == Skyrim.bootsEbony.itemID
					||helm.itemID == Skyrim.helmNordic.itemID && chest.itemID == Skyrim.chestNordic.itemID && legs.itemID == Skyrim.gauntletsNordic.itemID
					&& boots.itemID == Skyrim.bootsNordic.itemID
					||helm.itemID == Skyrim.helmOrc.itemID && chest.itemID == Skyrim.chestOrc.itemID && legs.itemID == Skyrim.gauntletsOrc.itemID
					&& boots.itemID == Skyrim.bootsOrc.itemID
					||helm.itemID == Skyrim.helmStalhrim.itemID && chest.itemID == Skyrim.chestStalhrim.itemID && legs.itemID == Skyrim.gauntletsStalhrim.itemID
					&& boots.itemID == Skyrim.bootsStalhrim.itemID
					||helm.itemID == Skyrim.helmSteel.itemID && chest.itemID == Skyrim.chestSteel.itemID && legs.itemID == Skyrim.gauntletsSteel.itemID
					&& boots.itemID == Skyrim.bootsSteel.itemID)
			{
				player.addPotionEffect((new PotionEffect(Potion.moveSlowdown.getId(), 20, 0)));
			}
		}
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		if (type.equals(EnumSet.of(TickType.PLAYER)))
		{
			onPlayerTick((EntityPlayer)tickData[0]);
		}
	}

	@Override
	public EnumSet<TickType> ticks() 
	{
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{

	}

	@Override
	public String getLabel()
	{
		return "Fallout" + this.getClass().getSimpleName();
	}
}