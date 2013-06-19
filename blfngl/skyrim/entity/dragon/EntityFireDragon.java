package blfngl.skyrim.entity.dragon;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityFireDragon extends EntityDragon
{
	public EntityFireDragon(World par1World)
	{
		super(par1World);
		//texture = "/blfngl/skyrim/textures/Dragon.png";
	}

	public int getMaxHealth()
	{
		return 905;
	}

	private boolean destroyBlocksInAABB(AxisAlignedBB par1AxisAlignedBB)
	{
		return false;
	}

	protected void onDeathUpdate()
	{
		float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
		float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
		float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
		this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 2.0D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D);

		int i;
		int j;

		if (!this.worldObj.isRemote)
		{
			i = 1000;

			while (i > 0)
			{
				j = EntityXPOrb.getXPSplit(i);
				i -= j;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
			}

			if (this.deathTicks == 1)
			{
				this.worldObj.func_82739_e(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
			}
		}

		this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
		this.renderYawOffset = this.rotationYaw += 20.0F;

		if (this.deathTicks == 200 && !this.worldObj.isRemote)
		{
			i = 2000;

			while (i > 0)
			{
				j = EntityXPOrb.getXPSplit(i);
				i -= j;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
			}

			this.setDead();
		}

		this.setDead();
	}

	private void createEnderPortal(int par1, int par2)
	{
		return;
	}

	public boolean canBeCollidedWith()
	{
		return true;
	}

	protected String getLivingSound()
	{
		return "blfngl.Dragon";
	}

	protected String getHurtSound()
	{
		return "mob.enderdragon.hit";
	}

	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
	{
		par1EntityPlayer.setFire(10);
	}
}