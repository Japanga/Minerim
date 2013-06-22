package blfngl.skyrim.entity.dragon;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import info.ata4.minecraft.dragon.DragonsModForge;
import info.ata4.minecraft.dragon.client.model.anim.DragonAnimator;
import info.ata4.minecraft.dragon.server.entity.ai.DragonBodyHelper;
import info.ata4.minecraft.dragon.server.entity.ai.DragonMoveHelper;
import info.ata4.minecraft.dragon.server.entity.ai.EntityAIBlock;
import info.ata4.minecraft.dragon.server.entity.ai.EntityAIDragonMate;
import info.ata4.minecraft.dragon.server.entity.ai.EntityAIFlyToOwner;
import info.ata4.minecraft.dragon.server.entity.ai.EntityAIFlyToTarget;
import info.ata4.minecraft.dragon.server.entity.ai.EntityAIFollowConspecific;
import info.ata4.minecraft.dragon.server.entity.ai.EntityAIFollowOwnerGround;
import info.ata4.minecraft.dragon.server.entity.ai.EntityAIPanicChild;
import info.ata4.minecraft.dragon.server.entity.ai.EntityAIRideAir;
import info.ata4.minecraft.dragon.server.entity.ai.EntityAIRideGround;
import info.ata4.minecraft.dragon.server.entity.ai.EntityAIRoamAir;
import info.ata4.minecraft.dragon.server.entity.ai.EntityAITargetAttacker;
import info.ata4.minecraft.dragon.server.entity.ai.EntityAIWatchLiving;
import info.ata4.minecraft.dragon.server.util.ItemUtils;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

// Referenced classes of package info.ata4.minecraft.dragon.server.entity:
//            EntityFlyingTameable, DragonBreedHelper, DragonBreed, DragonLifeStage

public class EntityTameableDragon extends EntityFlyingTameable
    implements IBossDisplayData, IAnimals
{

    public EntityTameableDragon(World world)
    {
        super(world);
        lifeStage = null;
        lifeStagePrev = null;
        breed = DEFAULT_BREED;
        try
        {
            ObfuscationReflectionHelper.setPrivateValue(net/minecraft/entity/EntityLiving, this, new DragonMoveHelper(this), new String[] {
                "moveHelper", "bK"
            });
            ObfuscationReflectionHelper.setPrivateValue(net/minecraft/entity/EntityLiving, this, new DragonBodyHelper(this), new String[] {
                "bodyHelper", "bM"
            });
        }
        catch(Exception ex)
        {
            L.log(Level.WARNING, "Can't override AI helper!", ex);
        }
        breedHelper = new DragonBreedHelper(this);
        field_70138_W = 1.0F;
        field_70697_bw = 0.3F;
        moveSpeedAir = 1.0F;
        field_70747_aH = field_70746_aG;
        field_70158_ak = true;
        if(isClient())
        {
            animator = new DragonAnimator(this);
        } else
        {
            field_70714_bg.func_75776_a(0, new EntityAIBlock(this));
            field_70714_bg.func_75776_a(1, new EntityAIRideGround(this, field_70697_bw));
            field_70714_bg.func_75776_a(2, field_70911_d);
            field_70714_bg.func_75776_a(3, new EntityAIDragonMate(this, field_70697_bw * 0.75F));
            field_70714_bg.func_75776_a(4, new EntityAITempt(this, field_70697_bw * 0.5F, Item.field_77754_aU.field_77779_bT, false));
            field_70714_bg.func_75776_a(6, new EntityAIAttackOnCollide(this, field_70697_bw, true));
            field_70714_bg.func_75776_a(7, new EntityAIFollowConspecific(this, field_70697_bw * 0.8F));
            field_70714_bg.func_75776_a(8, new EntityAIFollowOwnerGround(this, field_70697_bw, 12F, 24F, 32F));
            field_70714_bg.func_75776_a(9, new EntityAIPanicChild(this, field_70697_bw));
            field_70714_bg.func_75776_a(10, new EntityAIWander(this, field_70697_bw));
            field_70714_bg.func_75776_a(11, new EntityAIWatchLiving(this, 16F, 0.05F));
            airTasks.func_75776_a(0, new EntityAIRideAir(this, moveSpeedAir));
            airTasks.func_75776_a(1, new EntityAIRoamAir(this, moveSpeedAir, 100D, 22500D, 80, 32, 0.12F));
            airTasks.func_75776_a(2, new EntityAIFlyToTarget(this, moveSpeedAir));
            airTasks.func_75776_a(3, new EntityAIFlyToOwner(this, moveSpeedAir));
            field_70715_bh.func_75776_a(1, new EntityAIOwnerHurtByTarget(this));
            field_70715_bh.func_75776_a(2, new EntityAIOwnerHurtTarget(this));
            field_70715_bh.func_75776_a(3, new EntityAITargetAttacker(this, false));
        }
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        field_70180_af.func_75682_a(19, Byte.valueOf((byte)0));
        field_70180_af.func_75682_a(20, Integer.valueOf(0));
        field_70180_af.func_75682_a(21, "");
        field_70180_af.func_75682_a(22, DEFAULT_BREED.name());
    }

    public void func_70014_b(NBTTagCompound nbt)
    {
        super.func_70014_b(nbt);
        nbt.func_74757_a("Saddle", isSaddled());
        nbt.func_74778_a("HatchedBy", getBreederName() != null ? getBreederName() : "");
        nbt.func_74778_a("Breed", getBreed() != null ? getBreed().name() : "");
        breedHelper.writeToNBT(nbt);
    }

    public void func_70037_a(NBTTagCompound nbt)
    {
        super.func_70037_a(nbt);
        setSaddled(nbt.func_74767_n("Saddle"));
        setBreederName(nbt.func_74779_i("HatchedBy"));
        String breedName = nbt.func_74779_i("Breed");
        try
        {
            setBreed(DragonBreed.valueOf(breedName));
        }
        catch(IllegalArgumentException ex)
        {
            L.log(Level.WARNING, "Dragon {0} loaded with invalid breed type {1}, using {2}", new Object[] {
                Integer.valueOf(field_70157_k), breedName, DEFAULT_BREED.name()
            });
            setBreed(DEFAULT_BREED);
        }
        breedHelper.readFromNBT(nbt);
    }

    public boolean isSaddled()
    {
        return (field_70180_af.func_75683_a(19) & 1) != 0;
    }

    public void setSaddled(boolean saddled)
    {
        if(isSaddled() != saddled)
            L.log(Level.FINE, "Dragon {0} changed saddled to {1}", new Object[] {
                Integer.valueOf(field_70157_k), Boolean.valueOf(saddled)
            });
        field_70180_af.func_75692_b(19, Byte.valueOf(((byte)(saddled ? 1 : 0))));
    }

    public DragonBreed getBreed()
    {
        String breedName = field_70180_af.func_75681_e(22);
        if(breed.name().equals(breedName))
            return breed;
        try
        {
            breed = DragonBreed.valueOf(breedName);
        }
        catch(IllegalArgumentException ex)
        {
            breed = DEFAULT_BREED;
            if(isServer())
            {
                L.log(Level.WARNING, "Dragon {0} fixed invalid breed type {1} to {2}", new Object[] {
                    Integer.valueOf(field_70157_k), breedName, DEFAULT_BREED.name()
                });
                setBreed(breed);
            }
        }
        return breed;
    }

    public void setBreed(DragonBreed breed)
    {
        DragonBreed oldBreed = getBreed();
        field_70180_af.func_75692_b(22, breed.name());
        if(oldBreed != breed)
        {
            L.log(Level.FINE, "Dragon {0} changed breed to {1}", new Object[] {
                Integer.valueOf(field_70157_k), breed
            });
            breedHelper.onBreedChanged(oldBreed, breed);
        }
    }

    public int func_70968_i()
    {
        return field_70180_af.func_75679_c(20);
    }

    public void setDragonHealth(int health)
    {
        if(func_70968_i() != health)
            L.log(Level.FINE, "Dragon {0} health set to {1}", new Object[] {
                Integer.valueOf(field_70157_k), Integer.valueOf(health)
            });
        field_70180_af.func_75692_b(20, Integer.valueOf(health));
    }

    public String getBreederName()
    {
        return field_70180_af.func_75681_e(21);
    }

    public EntityPlayer getBreeder()
    {
        String breederName = getBreederName();
        return field_70170_p.func_72924_a(breederName);
    }

    public void setBreederName(String breederName)
    {
        if(!getBreederName().equals(breederName))
            L.log(Level.FINE, "Dragon {0} breeder set to {1}", new Object[] {
                Integer.valueOf(field_70157_k), breederName
            });
        field_70180_af.func_75692_b(21, breederName);
    }

    public boolean isOwner(EntityPlayer player)
    {
        return player.field_71092_bJ.equalsIgnoreCase(func_70905_p());
    }

    public boolean isRiddenByOwner()
    {
        return field_70153_n == func_70902_q();
    }

    public String func_70023_ak()
    {
        if(func_94056_bM())
        {
            return func_94057_bL();
        } else
        {
            String entName = EntityList.func_75621_b(this);
            return StatCollector.func_74838_a((new StringBuilder()).append("entity.").append(entName).append(".").append(breed.name().toLowerCase()).append(".name").toString());
        }
    }

    public EntityPlayer getRidingPlayer()
    {
        if(field_70153_n instanceof EntityPlayer)
            return (EntityPlayer)field_70153_n;
        else
            return null;
    }

    public void setRidingPlayer(EntityPlayer player)
    {
        if(field_70153_n == player)
        {
            float heightTmp = field_70131_O;
            field_70131_O = 1.0F;
            player.func_70078_a(null);
            field_70131_O = heightTmp;
        } else
        {
            player.func_70078_a(this);
        }
    }

    public DragonAnimator getAnimator()
    {
        return animator;
    }

    public void func_70636_d()
    {
        int age = func_70874_b();
        lifeStage = DragonLifeStage.getLifeStageForAge(age);
        if(lifeStagePrev != lifeStage)
        {
            onNewLifeStage();
            lifeStagePrev = lifeStage;
        }
        if(isServer() && func_70906_o() && (isHatchling() || isJuvenile()))
            field_70911_d.func_75270_a(false);
        if(isClient())
        {
            if(isEgg())
            {
                int eggAge = DragonLifeStage.EGG.getAgeLimit();
                int hatchAge = DragonLifeStage.HATCHLING.getAgeLimit();
                float chance = (float)(age - eggAge) / (float)(hatchAge - eggAge);
                if(chance > 0.66F)
                {
                    chance /= 60F;
                    if(eggWiggleX > 0)
                        eggWiggleX--;
                    else
                    if(field_70146_Z.nextFloat() < chance)
                    {
                        eggWiggleX = field_70146_Z.nextBoolean() ? 10 : 20;
                        playEggCrackEffect();
                    }
                    if(eggWiggleZ > 0)
                        eggWiggleZ--;
                    else
                    if(field_70146_Z.nextFloat() < chance)
                    {
                        eggWiggleZ = field_70146_Z.nextBoolean() ? 10 : 20;
                        playEggCrackEffect();
                    }
                }
                double px = field_70165_t + (field_70146_Z.nextDouble() - 0.5D);
                double py = field_70163_u + (field_70146_Z.nextDouble() - 0.5D);
                double pz = field_70161_v + (field_70146_Z.nextDouble() - 0.5D);
                double ox = (field_70146_Z.nextDouble() - 0.5D) * 2D;
                double oy = (field_70146_Z.nextDouble() - 0.5D) * 2D;
                double oz = (field_70146_Z.nextDouble() - 0.5D) * 2D;
                field_70170_p.func_72869_a("portal", px, py, pz, ox, oy, oz);
                if(breed != DEFAULT_BREED && field_70173_aa % 2 == 0)
                    field_70170_p.func_72869_a("reddust", px, py + 1.0D, pz, breed.getColorR(), breed.getColorG(), breed.getColorB());
            } else
            {
                animator.setOnGround(!isFlying());
                animator.update();
            }
        } else
        {
            setDragonHealth(field_70734_aK);
            if(isEgg() && field_70173_aa % 20 == 0)
                breedHelper.onUpdate();
        }
        super.func_70636_d();
    }

    protected void func_70609_aI()
    {
        field_70725_aQ++;
        if(field_70153_n != null)
            field_70153_n.func_70078_a(null);
        field_70159_w = field_70181_x = field_70179_y = 0.0D;
        field_70177_z = field_70126_B;
        field_70759_as = field_70758_at;
        if(isEgg())
        {
            if(isClient())
                playEggCrackEffect();
            func_70106_y();
        } else
        {
            if(isClient() && field_70725_aQ < getMaxDeathTime() - 20)
                spawnBodyParticles("cloud", 4);
            if(field_70725_aQ == getMaxDeathTime())
                func_70106_y();
        }
    }

    public boolean func_70085_c(EntityPlayer player)
    {
        if(isEgg())
            return false;
        if(func_70909_n() || func_70631_g_())
        {
            ItemFood food = null;
            if(func_70968_i() != func_70667_aM())
                food = (ItemFood)ItemUtils.consumeEquipped(player, new Item[] {
                    Item.field_77754_aU, Item.field_77784_aq, Item.field_77741_bi, Item.field_77735_bk
                });
            if(food != null)
            {
                func_70691_i(food.func_77847_f());
                field_70170_p.func_72956_a(this, "random.eat", 0.7F, (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F + 0.5F);
                return true;
            }
            if(!isOwner(player))
            {
                if(isServer())
                    player.func_71035_c("dragon.owned");
            } else
            if(!func_70631_g_())
                if(!isSaddled() && ItemUtils.consumeEquipped(player, Item.field_77765_aA))
                {
                    if(isServer())
                    {
                        L.log(Level.FINE, "Dragon {0} was saddled by {1}", new Object[] {
                            Integer.valueOf(field_70157_k), player.field_71092_bJ
                        });
                        setSaddled(true);
                    }
                } else
                if(field_70153_n == null && ItemUtils.hasEquipped(player, Item.field_77755_aX))
                {
                    if(isServer())
                    {
                        L.log(Level.FINE, "Dragon {0} was told to sit by {1}", new Object[] {
                            Integer.valueOf(field_70157_k), player.field_71092_bJ
                        });
                        field_70911_d.func_75270_a(!func_70906_o());
                        field_70703_bu = false;
                        func_70778_a(null);
                    }
                } else
                if(field_70153_n == null && ItemUtils.hasEquipped(player, Item.field_77760_aL))
                {
                    if(isClient())
                        player.openGui(DragonsModForge.instance, 0, field_70170_p, field_70157_k, 0, 0);
                } else
                if(field_70153_n == null && ItemUtils.consumeEquipped(player, Item.field_77754_aU))
                {
                    if(isClient())
                        spawnBodyParticles("heart");
                    field_70881_d = 600;
                    field_70789_a = null;
                } else
                if(isSaddled() && !ItemUtils.hasEquippedUsable(player) && isServer())
                {
                    L.log(Level.FINE, "Dragon {0} got a mount request from {1}", new Object[] {
                        Integer.valueOf(field_70157_k), player.field_71092_bJ
                    });
                    setRidingPlayer(player);
                }
        } else
        {
            if(isServer() && ItemUtils.consumeEquipped(player, Item.field_77754_aU))
                if(field_70146_Z.nextInt(3) == 0)
                {
                    func_70903_f(true);
                    func_70778_a(null);
                    func_70624_b(null);
                    func_70910_a(player.field_71092_bJ);
                    func_70908_e(true);
                    field_70170_p.func_72960_a(this, (byte)7);
                } else
                {
                    func_70908_e(false);
                    field_70170_p.func_72960_a(this, (byte)6);
                }
            return true;
        }
        return false;
    }

    protected void func_70628_a(boolean par1, int par2)
    {
        super.func_70628_a(par1, par2);
        if(isSaddled())
            func_70025_b(Item.field_77765_aA.field_77779_bT, 1);
    }

    public boolean func_70652_k(Entity victim)
    {
        field_70170_p.func_72956_a(this, "random.eat", 0.7F, (field_70146_Z.nextFloat() - field_70146_Z.nextFloat()) * 0.2F + 0.5F);
        field_70724_aR = 20;
        func_70607_j(victim);
        int damage = (int)(8F * getSize());
        return victim.func_70097_a(DamageSource.func_76358_a(this), damage);
    }

    public boolean func_70097_a(DamageSource src, int par2)
    {
        if(isImmuneToDamage(src))
            return false;
        field_70911_d.func_75270_a(false);
        if(!isEgg() && src.func_76346_g() != null && src.func_76346_g() != func_70643_av() && src.func_76346_g() != func_70902_q())
            field_70170_p.func_72956_a(this, "mob.enderdragon.growl", 1.0F, 0.5F + (1.0F / lifeStage.getSize()) * 0.5F);
        return super.func_70097_a(src, par2);
    }

    public boolean isImmuneToDamage(DamageSource src)
    {
        Entity srcEnt = src.func_76346_g();
        if(srcEnt != null)
        {
            if(srcEnt == this)
                return true;
            if(srcEnt == field_70153_n)
                return true;
        }
        if(src.field_76373_n.equals("inWall"))
            return true;
        if(src.field_76373_n.equals("drown"))
            return true;
        return breed.isImmuneToDamage(src);
    }

    public boolean func_70067_L()
    {
        EntityPlayer rider = getRidingPlayer();
        if(rider != null && ItemUtils.hasEquipped(rider, Item.field_77707_k))
            return false;
        else
            return super.func_70067_L();
    }

    protected void func_70069_a(float f)
    {
    }

    protected boolean func_70650_aV()
    {
        return true;
    }

    public boolean func_70104_M()
    {
        return isEgg();
    }

    protected boolean func_70692_ba()
    {
        return false;
    }

    public boolean func_70617_f_()
    {
        return false;
    }

    public void transformToEgg()
    {
        if(func_70630_aN() <= 0)
            return;
        field_70170_p.func_72956_a(this, "mob.enderdragon.transform", 1.0F, 0.5F + (0.5F - field_70146_Z.nextFloat()) * 0.1F);
        if(isSaddled())
            func_70025_b(Item.field_77765_aA.field_77779_bT, 1);
        func_70099_a(new ItemStack(Block.field_72084_bK), 0.0F);
        func_70106_y();
        L.log(Level.FINE, "Dragon {0} transformed to egg", Integer.valueOf(field_70157_k));
    }

    public float func_70047_e()
    {
        float eyeHeight = field_70131_O;
        eyeHeight *= 2.0F + ((float)func_70968_i() / (float)func_70667_aM()) * 2.0F;
        if(func_70906_o())
            eyeHeight *= 0.8F;
        return eyeHeight;
    }

    public boolean func_70878_b(EntityAnimal mate)
    {
        if(mate == this)
            return false;
        if(!func_70909_n())
            return false;
        if(!(mate instanceof EntityTameableDragon))
        {
            return false;
        } else
        {
            EntityTameableDragon dragonMate = (EntityTameableDragon)mate;
            return dragonMate.func_70909_n() ? func_70880_s() && dragonMate.func_70880_s() : false;
        }
    }

    public EntityAgeable func_90011_a(EntityAgeable mate)
    {
        if(!(mate instanceof EntityTameableDragon))
            throw new IllegalArgumentException("The mate isn't a dragon");
        EntityTameableDragon parent1 = this;
        EntityTameableDragon parent2 = (EntityTameableDragon)mate;
        EntityTameableDragon baby = new EntityTameableDragon(field_70170_p);
        if(func_70909_n())
        {
            if(parent1.func_94056_bM() && parent2.func_94056_bM())
            {
                String p1Name = parent1.func_94057_bL();
                String p2Name = parent2.func_94057_bL();
                String babyName;
                if(p1Name.contains(" ") || p2Name.contains(" "))
                {
                    String p1Names[] = p1Name.split(" ");
                    String p2Names[] = p2Name.split(" ");
                    p1Name = fixName(p1Names[field_70146_Z.nextInt(p1Names.length)]);
                    p2Name = fixName(p2Names[field_70146_Z.nextInt(p2Names.length)]);
                    babyName = field_70146_Z.nextBoolean() ? (new StringBuilder()).append(p1Name).append(" ").append(p2Name).toString() : (new StringBuilder()).append(p2Name).append(" ").append(p1Name).toString();
                } else
                {
                    if(field_70146_Z.nextBoolean())
                        p1Name = p1Name.substring(0, (p1Name.length() - 1) / 2);
                    else
                        p1Name = p1Name.substring((p1Name.length() - 1) / 2);
                    if(field_70146_Z.nextBoolean())
                        p2Name = p2Name.substring(0, (p2Name.length() - 1) / 2);
                    else
                        p2Name = p2Name.substring((p2Name.length() - 1) / 2);
                    p2Name = fixName(p2Name);
                    babyName = field_70146_Z.nextBoolean() ? (new StringBuilder()).append(p1Name).append(p2Name).toString() : (new StringBuilder()).append(p2Name).append(p1Name).toString();
                }
                baby.func_94058_c(babyName);
            }
            baby.breedHelper.addBreedPoints(parent1.getBreed(), 1800 + parent1.field_70146_Z.nextInt(1800));
            baby.breedHelper.addBreedPoints(parent2.getBreed(), 1800 + parent2.field_70146_Z.nextInt(1800));
        }
        return baby;
    }

    private String fixName(String text)
    {
        if(text == null || text.isEmpty())
        {
            return text;
        } else
        {
            char chars[] = text.toLowerCase().toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            return new String(chars);
        }
    }

    public String getTexture(int index)
    {
        return getBreed().getTexture(index);
    }

    public String func_70073_O()
    {
        return getTexture(0);
    }

    public double func_70042_X()
    {
        return func_70906_o() ? 1.7000000476837158D : 2.2000000476837158D;
    }

    protected String func_70639_aQ()
    {
        if(isEgg() || isFlying())
            return "";
        if(getBreed() == DragonBreed.GHOST)
            return "mob.skeleton.say";
        else
            return "mob.enderdragon.idle";
    }

    protected String func_70621_aR()
    {
        if(isEgg())
            return "mob.zombie.wood";
        else
            return "mob.enderdragon.hit";
    }

    protected String func_70673_aS()
    {
        if(isEgg())
            return "mob.zombie.woodbreak";
        else
            return "mob.enderdragon.death";
    }

    protected String getWingsSound()
    {
        return field_70171_ac ? null : "mob.enderdragon.wings";
    }

    protected void func_70036_a(int x, int y, int z, int blockId)
    {
        if(!isEgg() && !field_70171_ac)
            if(isHatchling())
                super.func_70036_a(x, y, z, blockId);
            else
                field_70170_p.func_72956_a(this, "mob.enderdragon.walk", 0.5F, 1.0F);
    }

    public void func_70642_aH()
    {
        if(!field_70171_ac)
        {
            String sound = func_70639_aQ();
            if(sound != null && field_70146_Z.nextBoolean())
                func_85030_a(sound, func_70599_aP(), func_70647_i() * 0.5F);
        }
    }

    public void onWingsDown(float speed)
    {
        float pitch = 0.8F + (0.5F - field_70146_Z.nextFloat()) * 0.3F + (1.0F - speed) * 0.2F;
        pitch *= getSize();
        float volume = 0.3F + (1.0F - speed) * 0.2F;
        field_70170_p.func_72980_b(field_70165_t, field_70163_u, field_70161_v, getWingsSound(), volume, pitch, false);
    }

    protected void spawnBodyParticle(String effect)
    {
        float s = getSize() * 1.2F;
        double ox;
        double oy;
        double oz;
        if(effect.equals("explode"))
        {
            ox = field_70146_Z.nextGaussian() * (double)s;
            oy = field_70146_Z.nextGaussian() * (double)s;
            oz = field_70146_Z.nextGaussian() * (double)s;
        } else
        if(effect.equals("cloud"))
        {
            ox = (field_70146_Z.nextDouble() - 0.5D) * 0.10000000000000001D;
            oy = field_70146_Z.nextDouble() * 0.20000000000000001D;
            oz = (field_70146_Z.nextDouble() - 0.5D) * 0.10000000000000001D;
        } else
        if(effect.equals("reddust"))
        {
            ox = 0.80000000000000004D;
            oy = 0.0D;
            oz = 0.80000000000000004D;
        } else
        {
            ox = 0.0D;
            oy = 0.0D;
            oz = 0.0D;
        }
        double x = field_70165_t + (field_70146_Z.nextDouble() - 0.5D) * (double)field_70130_N * (double)s;
        double y = field_70163_u + (field_70146_Z.nextDouble() - 0.5D) * (double)field_70131_O * (double)s;
        double z = field_70161_v + (field_70146_Z.nextDouble() - 0.5D) * (double)field_70130_N * (double)s;
        field_70170_p.func_72869_a(effect, x, y, z, ox, oy, oz);
    }

    protected void spawnBodyParticles(String effect, int baseAmount)
    {
        int amount = (int)((float)baseAmount * getSize());
        for(int i = 0; i < amount; i++)
            spawnBodyParticle(effect);

    }

    protected void spawnBodyParticles(String effect)
    {
        spawnBodyParticles(effect, 32);
    }

    public void func_70656_aK()
    {
        spawnBodyParticles("explode");
    }

    protected void func_70908_e(boolean success)
    {
        spawnBodyParticles(success ? "heart" : "smoke");
    }

    public int getEggWiggleX()
    {
        return eggWiggleX;
    }

    public int getEggWiggleZ()
    {
        return eggWiggleZ;
    }

    public int getDeathTime()
    {
        return field_70725_aQ;
    }

    public int getMaxDeathTime()
    {
        return 120;
    }

    public int func_70667_aM()
    {
        return (int)(80F * getSize());
    }

    public float getSize()
    {
        return getLifeStage().getSize();
    }

    public DragonLifeStage getLifeStage()
    {
        return lifeStage != null ? lifeStage : DragonLifeStage.EGG;
    }

    public final void setLifeStage(DragonLifeStage lifeStage)
    {
        func_70873_a(lifeStage.getAgeLimit());
    }

    public boolean isEgg()
    {
        return lifeStage == DragonLifeStage.EGG;
    }

    public boolean isHatchling()
    {
        return lifeStage == DragonLifeStage.HATCHLING;
    }

    public boolean isJuvenile()
    {
        return lifeStage == DragonLifeStage.JUVENILE;
    }

    public boolean isAdult()
    {
        return lifeStage == DragonLifeStage.ADULT;
    }

    private void onNewLifeStage()
    {
        L.log(Level.FINE, "Dragon {0} entered life stage {1}", new Object[] {
            Integer.valueOf(field_70157_k), lifeStage
        });
        boolean hatched = lifeStagePrev == DragonLifeStage.EGG && isHatchling();
        canFly = !isEgg() && !isHatchling();
        if(isClient())
        {
            if(hatched)
                playEggCrackEffect();
            else
                func_70656_aK();
        } else
        {
            func_70661_as().func_75490_c(isHatchling());
            if(isEgg())
            {
                field_70911_d.func_75270_a(true);
                func_70778_a(null);
                func_70624_b(null);
            }
            func_70606_j(func_70667_aM());
        }
        func_70105_a(-1F, 0.0F);
        if(isEgg())
        {
            func_70105_a(0.98F, 0.98F);
        } else
        {
            float multi = getSize();
            func_70105_a(multi * 4F, multi * 3F);
        }
    }

    protected void func_70619_bc()
    {
        if(!isEgg())
            super.func_70619_bc();
    }

    private void playEggCrackEffect()
    {
        int bx = (int)Math.round(field_70165_t - 0.5D);
        int by = (int)Math.round(field_70163_u);
        int bz = (int)Math.round(field_70161_v - 0.5D);
        field_70170_p.func_72926_e(2001, bx, by, bz, Block.field_72084_bK.field_71990_ca);
    }

    void setImmuneToFire(boolean isImmuneToFire)
    {
        field_70178_ae = isImmuneToFire;
    }

    protected void func_70664_aZ()
    {
        if(isRiddenByOwner())
            super.func_70664_aZ();
    }

    public EnumCreatureAttribute func_70668_bt()
    {
        return breedHelper.getCreatureAttribute();
    }

    public void func_98054_a(boolean flag)
    {
    }

    private static final Logger L;
    public static final DragonBreed DEFAULT_BREED;
    private static final int INDEX_SADDLED = 19;
    private static final int INDEX_HEALTH = 20;
    private static final int INDEX_BREEDER = 21;
    private static final int INDEX_BREED = 22;
    private static final String NBT_SADDLED = "Saddle";
    private static final String NBT_BREEDER = "HatchedBy";
    private static final String NBT_BREED = "Breed";
    private DragonLifeStage lifeStage;
    private DragonLifeStage lifeStagePrev;
    private DragonBreed breed;
    private DragonBreedHelper breedHelper;
    private DragonAnimator animator;
    private int eggWiggleX;
    private int eggWiggleZ;

    static 
    {
        L = DragonsModForge.L;
        DEFAULT_BREED = DragonBreed.END;
    }
}