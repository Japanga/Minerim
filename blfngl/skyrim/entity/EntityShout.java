package blfngl.skyrim.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class EntityShout extends Entity
{
	public Minecraft game;
	public double radius;

	public EntityShout(Entity entity, World world)
	{
		super(world);
		game = ModLoader.getMinecraftInstance();
		radius = 0.20000000000000001D;
		setSize(0.0F, 0.0F);
		setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		super.onUpdate();

		for (int i = 0; i < 360; i += 10)
		{
			game.effectRenderer.addEffect(new EntityReddustFX(worldObj, posX + radius * Math.cos(Math.toRadians(rotationYaw)) * Math.cos(Math.toRadians(rotationPitch)) * Math.cos(Math.toRadians(i)), posY + radius * Math.sin(Math.toRadians(i)), posZ + radius * Math.sin(Math.toRadians(rotationYaw)) * Math.cos(Math.toRadians(rotationPitch)) * Math.cos(Math.toRadians(i)), 1.0F, 0.0F, 191F, 255F));
		}

		this.moveEntity(-Math.sin(Math.toRadians(rotationYaw)) * Math.cos(Math.toRadians(rotationPitch)), -Math.sin(Math.toRadians(rotationPitch)), Math.cos(Math.toRadians(rotationYaw)) * Math.cos(Math.toRadians(rotationPitch)));
		radius += 0.14999999999999999D;

		if (radius > 5D)
		{
			this.setDead();
		}
	}

	protected void entityInit()
	{

	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{

	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{

	}
}
