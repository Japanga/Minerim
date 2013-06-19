package blfngl.skyrim.item;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import blfngl.skyrim.Skyrim;
import blfngl.skyrim.entity.EntityShout;

public class ItemWabbajack extends BaseItem
{
	public World world1;
	public Minecraft mc;
	public int weaponDamage;
	private boolean lava;
    MovingObjectPosition movingobjectposition;
    
	public ItemWabbajack(int par1)
	{
		super(par1);
		setCreativeTab(Skyrim.TabSkyrimCombat);
	}

	public int getDamageVsEntity(Entity entity, EntityPlayer entityplayer)
	{
//		weaponDamage = 4 + EnumToolMaterial.IRON.getDamageVsEntity();
//		world1 = mc.theWorld;
//		EntityPlayerSP entityplayersp = mc.thePlayer;
		Random random = new Random();
		int i = random.nextInt(10);

		if (i == 0 && (random.nextInt(3) == 0 || random.nextInt(3) == 0))
		{
			List list = world1.getEntitiesWithinAABBExcludingEntity(entityplayer, AxisAlignedBB.getBoundingBox(((EntityPlayer)(entityplayer)).posX, ((EntityPlayer)(entityplayer)).posY, ((EntityPlayer)(entityplayer)).posZ, ((EntityPlayer)(entityplayer)).posX + 1.0D, ((EntityPlayer)(entityplayer)).posY + 10D, ((EntityPlayer)(entityplayer)).posZ + 1.0D).expand(15D, 2D, 15D));

			if (!list.isEmpty())
			{
				world1.spawnEntityInWorld(new EntityShout(entityplayer, world1));

				for (Iterator iterator = list.iterator(); iterator.hasNext();)
				{
					Object obj = iterator.next();
					Entity entity1 = (Entity)obj;
					entity1.addVelocity(-MathHelper.sin((((EntityPlayer)(entityplayer)).rotationYaw * (float)Math.PI) / 180F) * 15F * 0.5F, 0.10000000000000001D, MathHelper.cos((((EntityPlayer)(entityplayer)).rotationYaw * (float)Math.PI) / 180F) * 15F * 0.5F);
					entityplayer.motionX *= 0.59999999999999998D;
					entityplayer.motionZ *= 0.59999999999999998D;
				}
			}

			//mc.ingameGUI.addChatMessage("FUS.. RO DAH!!!");
		}

		if (i == 1)
		{
			entityplayer.addPotionEffect(new PotionEffect(5, 400, 0));
			//mc.ingameGUI.addChatMessage("MORTAL, I grant you POWER!");
		}

		if (i == 2 && random.nextInt(3) == 0)
		{
			entityplayer.addPotionEffect(new PotionEffect(18, 400, 0));
			//mc.ingameGUI.addChatMessage("MORTAL, you have been CURSED!");
		}

		if (i == 3 && random.nextInt(3) == 0)
		{
			float f = 4F;
			entityplayer.motionZ = 0.0D;
			entityplayer.motionX = 0.0D;
			entityplayer.motionY = 0.0D;

			//            for (int j1 = 10; j1 <= 12; j1++)
			//            {
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX - 5D, ((EntityPlayer)(entityplayersp)).posY - (double)j1, ((EntityPlayer)(entityplayersp)).posZ + 5D, f, 10.0F, true);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX, ((EntityPlayer)(entityplayersp)).posY - (double)j1, ((EntityPlayer)(entityplayersp)).posZ + 5D, f);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX + 5D, ((EntityPlayer)(entityplayersp)).posY - (double)j1, ((EntityPlayer)(entityplayersp)).posZ + 5D, f);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX - 5D, ((EntityPlayer)(entityplayersp)).posY - (double)j1, ((EntityPlayer)(entityplayersp)).posZ, f);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX + 5D, ((EntityPlayer)(entityplayersp)).posY - (double)j1, ((EntityPlayer)(entityplayersp)).posZ, f);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX - 5D, ((EntityPlayer)(entityplayersp)).posY - (double)j1, ((EntityPlayer)(entityplayersp)).posZ - 5D, f);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX, ((EntityPlayer)(entityplayersp)).posY, ((EntityPlayer)(entityplayersp)).posZ - 5D, f);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX + 5D, ((EntityPlayer)(entityplayersp)).posY - (double)j1, ((EntityPlayer)(entityplayersp)).posZ - 5D, f);
			//                entityplayersp.motionZ = 0.0D;
			//                entityplayersp.motionX = 0.0D;
			//                entityplayersp.motionY = 0.0D;
			//            }

			//            for (int k1 = 1; k1 <= 10; k1++)
			//            {
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX - 7D, ((EntityPlayer)(entityplayersp)).posY - (double)k1, ((EntityPlayer)(entityplayersp)).posZ + 7D, f);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX, ((EntityPlayer)(entityplayersp)).posY - (double)k1, ((EntityPlayer)(entityplayersp)).posZ + 7D, f);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX + 7D, ((EntityPlayer)(entityplayersp)).posY - (double)k1, ((EntityPlayer)(entityplayersp)).posZ + 7D, f);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX - 7D, ((EntityPlayer)(entityplayersp)).posY - (double)k1, ((EntityPlayer)(entityplayersp)).posZ, f);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX + 7D, ((EntityPlayer)(entityplayersp)).posY - (double)k1, ((EntityPlayer)(entityplayersp)).posZ, f);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX - 7D, ((EntityPlayer)(entityplayersp)).posY - (double)k1, ((EntityPlayer)(entityplayersp)).posZ - 7D, f);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX, ((EntityPlayer)(entityplayersp)).posY, ((EntityPlayer)(entityplayersp)).posZ - 7D, f);
			//                world1.createExplosion(entityplayersp, ((EntityPlayer)(entityplayersp)).posX + 7D, ((EntityPlayer)(entityplayersp)).posY - (double)k1, ((EntityPlayer)(entityplayersp)).posZ - 7D, f);
			//                entityplayersp.motionZ = 0.0D;
			//                entityplayersp.motionX = 0.0D;
			//                entityplayersp.motionY = 0.0D;
			//            }

			//mc.ingameGUI.addChatMessage("CATACLYSM!!! (DEMACIA!)");
		}

		if (i == 4 && random.nextInt(2) == 0)
		{
			weaponDamage = 16;
			movingobjectposition = mc.objectMouseOver;
			lava = true;
			BlockFire blockfire = Block.fire;
			entityplayer.motionX = 0.0D;
			entityplayer.motionY = 0.0D;
			entityplayer.motionZ = 0.0D;
			//mc.thePlayer.isImmuneToFire = true;
			//          duration = 600;

//			for (int l1 = -2; l1 <= 1; l1++)
//			{
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX) + 1, (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX) - 1, (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX), (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ + 1.0D), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX), (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ - 1.0D), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX) + 2, (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ - 1.0D), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX) + 2, (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX) + 2, (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ + 1.0D), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX) - 2, (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ - 1.0D), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX) - 2, (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX) - 2, (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ + 1.0D), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX), (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ + 2D), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX - 1.0D), (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ + 2D), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX + 1.0D), (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ + 2D), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX), (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ - 2D), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX - 1.0D), (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ - 2D), ((Block)(blockfire)).blockID);
//				world1.setBlockWithNotify((int)Math.round(((EntityPlayer)(entityplayersp)).posX + 1.0D), (int)Math.round(((EntityPlayer)(entityplayersp)).posY + (double)l1), (int)Math.round(((EntityPlayer)(entityplayersp)).posZ - 2D), ((Block)(blockfire)).blockID);
//			}

			//mc.ingameGUI.addChatMessage("BURRRNNN HAHAHAAA!! (immune to fire for 30 seconds!)");
		}

		if (i == 5 && random.nextInt(2) == 0)
		{
			entityplayer.heal(6);
			entityplayer.addPotionEffect(new PotionEffect(10, 400, 0));
			//mc.ingameGUI.addChatMessage("MEDIC!! Regeneration <3");
		}

		if (i == 6 && (random.nextInt(3) == 0 || random.nextInt(3) == 0))
		{
			weaponDamage = 10000;
			EntityLightningBolt entitylightningbolt = new EntityLightningBolt(world1, ((EntityPlayer)(entityplayer)).posX, ((EntityPlayer)(entityplayer)).posY, ((EntityPlayer)(entityplayer)).posZ + 4D);
			world1.spawnEntityInWorld(entitylightningbolt);
			EntityLightningBolt entitylightningbolt1 = new EntityLightningBolt(world1, ((EntityPlayer)(entityplayer)).posX, ((EntityPlayer)(entityplayer)).posY, ((EntityPlayer)(entityplayer)).posZ - 4D);
			world1.spawnEntityInWorld(entitylightningbolt1);
			EntityLightningBolt entitylightningbolt6 = new EntityLightningBolt(world1, ((EntityPlayer)(entityplayer)).posX + 4D, ((EntityPlayer)(entityplayer)).posY, ((EntityPlayer)(entityplayer)).posZ);
			world1.spawnEntityInWorld(entitylightningbolt6);
			EntityLightningBolt entitylightningbolt7 = new EntityLightningBolt(world1, ((EntityPlayer)(entityplayer)).posX - 4D, ((EntityPlayer)(entityplayer)).posY, ((EntityPlayer)(entityplayer)).posZ);
			world1.spawnEntityInWorld(entitylightningbolt7);
			//mc.ingameGUI.addChatMessage("Notch's Fury");
		}

		if (i == 7 && random.nextInt(3) == 0 && ((EntityPlayer)(entityplayer)).getHealth() / 2 != 0)
		{
			entityplayer.attackEntityFrom(DamageSource.generic, ((EntityPlayer)(entityplayer)).getHealth() / 2);
			//mc.ingameGUI.addChatMessage("MORTAL! PAY ME IN BLOOD!");
		}

		if (i == 8 && (random.nextInt(3) == 0 || random.nextInt(3) == 0))
		{
			weaponDamage = 16;
			//mc.ingameGUI.addChatMessage("How you like that [insert mob name here]! 8 heart damage yeaah!");
		}

		if (i == 9 && random.nextInt(2) == 0)
		{
			weaponDamage = 10000;

			for (int j = -2; j <= 2; j++)
			{
				EntityLightningBolt entitylightningbolt2 = new EntityLightningBolt(world1, ((EntityPlayer)(entityplayer)).posX + (double)j, ((EntityPlayer)(entityplayer)).posY, ((EntityPlayer)(entityplayer)).posZ + 5D);
				world1.spawnEntityInWorld(entitylightningbolt2);
			}

			for (int k = -2; k <= 2; k++)
			{
				EntityLightningBolt entitylightningbolt3 = new EntityLightningBolt(world1, ((EntityPlayer)(entityplayer)).posX + (double)k, ((EntityPlayer)(entityplayer)).posY, ((EntityPlayer)(entityplayer)).posZ - 5D);
				world1.spawnEntityInWorld(entitylightningbolt3);
			}

			for (int l = -2; l <= 2; l++)
			{
				EntityLightningBolt entitylightningbolt4 = new EntityLightningBolt(world1, ((EntityPlayer)(entityplayer)).posX + 5D, ((EntityPlayer)(entityplayer)).posY, ((EntityPlayer)(entityplayer)).posZ + (double)l);
				world1.spawnEntityInWorld(entitylightningbolt4);
			}

			for (int i1 = -2; i1 <= 2; i1++)
			{
				EntityLightningBolt entitylightningbolt5 = new EntityLightningBolt(world1, ((EntityPlayer)(entityplayer)).posX - 5D, ((EntityPlayer)(entityplayer)).posY, ((EntityPlayer)(entityplayer)).posZ + (double)i1);
				world1.spawnEntityInWorld(entitylightningbolt5);
			}

			//mc.ingameGUI.addChatMessage("Notch's WRATH!!");
		}

		return weaponDamage;
	}
}
