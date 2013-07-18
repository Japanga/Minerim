package blfngl.skyrim.handler;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import blfngl.skyrim.Skyrim;

public class SkryrimVanillaDrops extends Skyrim
{
	@ForgeSubscribe
	public void playerKillEnderdragon(LivingDeathEvent event)
	{
		if(event.entityLiving instanceof EntityDragon)
		{
			event.entityLiving.dropItem(dragonBone.itemID, 3);
			event.entityLiving.dropItem(dragonScale.itemID, 2);
		}
	}
}