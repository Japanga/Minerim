package blfngl.skyrim.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityNoteFX;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityShout extends Entity
{
	public Minecraft game;
	public double radius;

	public EntityShout(Entity entity, World world)
	{
		super(world);
		game = ModLoader.getMinecraftInstance();
		radius = 0.2D;
		setSize(1.0F, 1.0F);
		setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onUpdate()
	{
		//super.onUpdate();

		for (int i = 0; i < 360; i += 10)
		{
			game.effectRenderer.addEffect(new EntityNoteFX(worldObj, posX + radius * Math.cos(Math.toRadians(rotationYaw)) * Math.cos(Math.toRadians(rotationPitch)) * Math.cos(Math.toRadians(i)), posY + radius * Math.sin(Math.toRadians(i)), posZ + radius * Math.sin(Math.toRadians(rotationYaw)) * Math.cos(Math.toRadians(rotationPitch)) * Math.cos(Math.toRadians(i)), 1.0F, 0.0F, 191F, 255F));
		}

		this.moveEntity(-Math.sin(Math.toRadians(rotationYaw)) * Math.cos(Math.toRadians(rotationPitch)), -Math.sin(Math.toRadians(rotationPitch)), Math.cos(Math.toRadians(rotationYaw)) * Math.cos(Math.toRadians(rotationPitch)));
		radius += 0.15D;

		if (radius > 5D){setDead();}
	}

	protected void entityInit()
	{

	}

//	@Override
//	protected void onImpact(MovingObjectPosition movingobjectposition)
//	{
//		if (movingobjectposition.entityHit != null)
//		{
//			byte b0 = 10;
//
//			movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
//		}
//
//		for (int i = 0; i < 8; ++i)
//		{
//			this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
//		}
//
//		if (!this.worldObj.isRemote)
//		{
//			this.setDead();
//		}		
//	}
//
//	@Override
//	protected float getGravityVelocity()
//	{
//		return 0;
//	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		// TODO Auto-generated method stub
		
	}
}