package blfngl.skyrim.handler;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import blfngl.skyrim.Skyrim;
import blfngl.skyrim.entity.EntityDaedricArrow;
import blfngl.skyrim.entity.EntityDremora;
import blfngl.skyrim.entity.EntityShout;
import blfngl.skyrim.entity.dragon.EntityAlduin;
import blfngl.skyrim.entity.dragon.EntityFireDragon;
import blfngl.skyrim.entity.dragon.EntityFrostDragon;
import blfngl.skyrim.entity.dragon.EntityOdahviing;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class EntityHandler extends Skyrim
{
	public static void init()
	{
		EntityRegistry.registerGlobalEntityID(EntityDaedricArrow.class, "DaedraArrow", EntityRegistry.findGlobalUniqueEntityId());

		EntityRegistry.registerGlobalEntityID(EntityShout.class, "EntityShout", EntityRegistry.findGlobalUniqueEntityId());

		EntityRegistry.registerGlobalEntityID(EntityDremora.class, "Dremora", EntityRegistry.findGlobalUniqueEntityId(), 230, 78);
		LanguageRegistry.instance().addStringLocalization("entity.Dremora.name", "en_US", "Dremora");

		EntityRegistry.registerGlobalEntityID(EntityOdahviing.class, "Odahviing", EntityRegistry.findGlobalUniqueEntityId(), 230, 78);
		LanguageRegistry.instance().addStringLocalization("entity.Odahviing.name", "en_US", "Odahviing (WIP)");

		EntityRegistry.registerGlobalEntityID(EntityFireDragon.class, "FireDragon", EntityRegistry.findGlobalUniqueEntityId(), 230, 78);
		LanguageRegistry.instance().addStringLocalization("entity.FireDragon.name", "en_US", "Fire Dragon");
		EntityRegistry.addSpawn(EntityFireDragon.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.plains);
		EntityRegistry.addSpawn(EntityFireDragon.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.desert);
		EntityRegistry.addSpawn(EntityFireDragon.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.desertHills);
		EntityRegistry.addSpawn(EntityFireDragon.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.forest);

		EntityRegistry.registerGlobalEntityID(EntityFrostDragon.class, "FrostDragon", EntityRegistry.findGlobalUniqueEntityId(), 230, 78);
		LanguageRegistry.instance().addStringLocalization("entity.FrostDragon.name", "en_US", "Frost Dragon");
		EntityRegistry.addSpawn(EntityFrostDragon.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.frozenOcean);
		EntityRegistry.addSpawn(EntityFrostDragon.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.forest);
		EntityRegistry.addSpawn(EntityFrostDragon.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.taiga);
		EntityRegistry.addSpawn(EntityFrostDragon.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityFrostDragon.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.frozenRiver);

		EntityRegistry.registerGlobalEntityID(EntityAlduin.class, "Alduin", EntityRegistry.findGlobalUniqueEntityId(), 230, 78);
		
		EntityRegistry.registerGlobalEntityID(EntityDaedricArrow.class, "DaedricArrow", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityDaedricArrow.class, "DaedricArrow", 0, Skyrim.instance, 128, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.DaedricArrow.name", "Daedric Arrow");
	}
}
