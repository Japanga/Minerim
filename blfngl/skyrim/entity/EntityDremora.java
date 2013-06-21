package blfngl.skyrim.entity;

import blfngl.skyrim.Skyrim;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityDremora extends EntityMob
{
	World world = null;
	//private static final ItemStack defaultHeldItem = new ItemStack(Skyrim.swordDaedric, 1);

	public EntityDremora(World var1)
	{
		super(var1);
		this.texture = "/blfngl/skyrim/textures/DaedricArmor.png";
		this.moveSpeed = 0.5F;
		this.isImmuneToFire = false;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(3, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 25.0F, 0, true));
	}

	/**
	 * Returns the amount of damage a mob should deal.
	 */
	public int getAttackStrength(Entity var1)
	{
		return 6;
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled()
	{
		return true;
	}

	public int getMaxHealth()
	{
		return 345;
	}

	protected void addRandomArmor()
	{
		this.setCurrentItemOrArmor(0, new ItemStack(Skyrim.swordDaedric));
	}

	public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack)
	{
		super.setCurrentItemOrArmor(par1, par2ItemStack);
	}

	public ItemStack getHeldItem()
    {
            return defaultHeldItem;
    }
            
            static
    {
            defaultHeldItem = new ItemStack(Skyrim.swordDaedric, 1);
    }
            
    private static final ItemStack defaultHeldItem;

	protected int getDropItemId()
	{
		return Skyrim.daedraHeart.itemID;
	}

	//	protected void dropFewItems(boolean var1, int var2)
	//	{
	//		byte var3 = 0;
	//		int var4;
	//		int var5;
	//
	//		if (var3 > 0)
	//		{
	//			var5 = this.rand.nextInt(3 + var2) - 1;
	//
	//			for (var4 = 0; var4 < var5; ++var4)
	//			{
	//				this.dropItem(Skyrim.ingotEbony.itemID, 1);
	//			}
	//		}
	//		else
	//		{
	//			var5 = this.rand.nextInt(3 + var2);
	//
	//			for (var4 = 0; var4 < var5; ++var4)
	//			{
	//				this.dropItem(Skyrim.daedraHeart.itemID, 1);
	//			}
	//		}
	//
	//		var5 = this.rand.nextInt(3 + var2);
	//
	//		for (var4 = 0; var4 < var5; ++var4)
	//		{
	//			this.dropItem(Skyrim.swordEbony.itemID, 1);
	//		}
	//	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	public String getLivingSound()
	{
		return "mob.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	public String getHurtSound()
	{
		return "damage.hit";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	public String getDeathSound()
	{
		return "damage.hit";
	}

	/**
	 * Called when a lightning bolt hits the entity.
	 */
	public void onStruckByLightning(EntityLightningBolt var1)
	{
		int var2 = (int)this.posX;
		int var3 = (int)this.posY;
		int var4 = (int)this.posZ;
	}

	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	protected void fall(float var1)
	{
		int var2 = (int)this.posX;
		int var3 = (int)this.posY;
		int var4 = (int)this.posZ;
		super.fall(var1);
	}

	public void onCriticalHit(Entity var1)
	{
		int var2 = (int)this.posX;
		int var3 = (int)this.posY;
		int var4 = (int)this.posZ;
	}

	/**
	 * This method gets called when the entity kills another one.
	 */
	public void onKillEntity(EntityLiving var1)
	{
		int var2 = (int)this.posX;
		int var3 = (int)this.posY;
		int var4 = (int)this.posZ;
	}

	public boolean canAttackClass(Class par1Class)
	{
		return EntityCreeper.class != par1Class && EntityGhast.class != par1Class;
	}
}
