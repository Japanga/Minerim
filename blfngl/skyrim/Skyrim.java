package blfngl.skyrim;

import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import blfngl.skyrim.block.BlockBase;
import blfngl.skyrim.block.BlockGrindstone;
import blfngl.skyrim.block.BlockSkyrimChest;
import blfngl.skyrim.block.BlockSmelter;
import blfngl.skyrim.handler.Blocks;
import blfngl.skyrim.handler.EntityHandler;
import blfngl.skyrim.handler.Languages;
import blfngl.skyrim.handler.Recipes;
import blfngl.skyrim.handler.SkryrimVanillaDrops;
import blfngl.skyrim.handler.WorldHandler;
import blfngl.skyrim.item.BaseArmor;
import blfngl.skyrim.item.BaseFood;
import blfngl.skyrim.item.BaseItem;
import blfngl.skyrim.item.BasePick;
import blfngl.skyrim.item.BaseSword;
import blfngl.skyrim.item.ItemSkyrimBow;
import blfngl.skyrim.proxy.CommonProxy;
import blfngl.skyrim.tab.TabSkyrimArmor;
import blfngl.skyrim.tab.TabSkyrimBlocks;
import blfngl.skyrim.tab.TabSkyrimCombat;
import blfngl.skyrim.tab.TabSkyrimFood;
import blfngl.skyrim.tab.TabSkyrimItems;
import blfngl.skyrim.tileentity.TileEntityGrindstone;
import blfngl.skyrim.tileentity.TileEntitySmelter;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * The Skyrim Mod
 * 
 * @Author blfngl
 * @License Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * The code in this repository, in any form, is the copyright of blfngl
 **/

@Mod(modid = "skyrim", name = "The Skyrim Mod", version = "MC v1.5.2 | SM v1.0.5")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Skyrim
{
	@Instance("skyrim")
	public static Skyrim instance;

	@SidedProxy(clientSide="blfngl.skyrim.proxy.ClientProxy", serverSide="blfngl.skyrim.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs TabSkyrimBlocks = new TabSkyrimBlocks(CreativeTabs.getNextID(), "TabSkyrimBlocks");
	public static CreativeTabs TabSkyrimItems = new TabSkyrimItems(CreativeTabs.getNextID(), "TabSkyrimItems");
	public static CreativeTabs TabSkyrimCombat = new TabSkyrimCombat(CreativeTabs.getNextID(), "TabSkyrimCombat");
	public static CreativeTabs TabSkyrimArmor = new TabSkyrimArmor(CreativeTabs.getNextID(), "TabSkyrimArmor");
	public static CreativeTabs TabSkyrimFood = new TabSkyrimFood(CreativeTabs.getNextID(), "TabSkyrimFood");

	public static EnumArmorMaterial DWARVEN = EnumHelper.addArmorMaterial("DWARVEN", 34, new int[]{4, 8, 6, 2}, 25);
	public static EnumArmorMaterial DAEDRIC = EnumHelper.addArmorMaterial("DAEDRIC", 49, new int[]{4, 8, 6, 2}, 25);
	public static EnumArmorMaterial GLASS = EnumHelper.addArmorMaterial("GLASS", 38, new int[]{3, 6, 5, 2}, 25);
	public static EnumArmorMaterial EBONY = EnumHelper.addArmorMaterial("EBONY", 43, new int[]{4, 8, 6, 2}, 25);
	public static EnumArmorMaterial ORCISH = EnumHelper.addArmorMaterial("ORCISH", 40, new int[]{4, 8, 6, 2}, 25);
	public static EnumArmorMaterial STEEL = EnumHelper.addArmorMaterial("STEEL", 31, new int[]{4, 8, 6, 2}, 25);
	public static EnumArmorMaterial STALHRIM = EnumHelper.addArmorMaterial("STALHRIM", 46, new int[]{4, 8, 6, 2}, 25);
	public static EnumArmorMaterial ELVEN = EnumHelper.addArmorMaterial("ELVEN", 29, new int[]{3, 6, 5, 2}, 25);
	public static EnumArmorMaterial ELVENGILDED = EnumHelper.addArmorMaterial("ELVENGILDED", 35, new int[]{3, 6, 5, 2}, 25);
	public static EnumArmorMaterial ANCIENTNORD = EnumHelper.addArmorMaterial("ANCIENTNORD", 25, new int[]{4, 8, 6, 2}, 25);
	public static EnumArmorMaterial STALHRIMLIGHT = EnumHelper.addArmorMaterial("STALHRIMLIGHT", 39, new int[]{3, 6, 5, 2}, 25);

	public static EnumToolMaterial STALHRIMTOOL = EnumHelper.addToolMaterial("STALHRIMTOOL", 4, -1, 6.0F, 3, 40);

	public static final Item ingotCorundum = new BaseItem(11000).setUnlocalizedName("CorundumIngot").setCreativeTab(TabSkyrimItems);
	public static final Item ingotDwarven = new BaseItem(11001).setUnlocalizedName("DwarvenIngot").setCreativeTab(TabSkyrimItems);
	public static final Item ingotEbony = new BaseItem(11002).setUnlocalizedName("EbonyIngot").setCreativeTab(TabSkyrimItems);
	public static final Item ingotOrichalcum = new BaseItem(11003).setUnlocalizedName("OrichalcumIngot").setCreativeTab(TabSkyrimItems);
	public static final Item ingotQuicksilver = new BaseItem(11004).setUnlocalizedName("QuicksilverIngot").setCreativeTab(TabSkyrimItems);
	public static final Item ingotMalachite = new BaseItem(11005).setUnlocalizedName("RefinedMalachiteIngot").setCreativeTab(TabSkyrimItems);
	public static final Item ingotMoonstone = new BaseItem(11006).setUnlocalizedName("RefinedMoonstoneIngot").setCreativeTab(TabSkyrimItems);
	public static final Item ingotSteel = new BaseItem(11007).setUnlocalizedName("SteelIngot").setCreativeTab(TabSkyrimItems);
	public static final Item ingotSilver = new BaseItem(11008).setUnlocalizedName("SilverIngot").setCreativeTab(TabSkyrimItems);
	public static final Item leatherStrips = new BaseItem(11009).setUnlocalizedName("LeatherStrip").setCreativeTab(TabSkyrimItems);
	public static final Item dragonScale = new BaseItem(11010).setUnlocalizedName("DragonScale").setCreativeTab(TabSkyrimItems);
	public static final Item dragonBone = new BaseItem(11011).setUnlocalizedName("DragonBones").setCreativeTab(TabSkyrimItems);

	public static final BlockOre oreCorundum = new BlockBase(190, 0, Material.rock, 4.0F, "CorundumOre");
	public static final BlockOre oreEbony = new BlockBase(191, 0, Material.rock, 6.0F, "EbonyOre");
	public static final BlockOre oreOrichalcum = new BlockBase(192, 0, Material.rock, 3.0F, "OrichalcumOre");
	public static final BlockOre oreQuicksilver = new BlockBase(193, 0, Material.rock, 3.0F, "QuicksilverOre");
	public static final BlockOre oreMalachite = new BlockBase(194, 0, Material.rock, 5.0F, "MalachiteOre");
	public static final BlockOre oreMoonstone = new BlockBase(195, 0, Material.rock, 5.0F, "MoonstoneOre");
	public static final BlockOre oreSilver = new BlockBase(196, 0, Material.rock, 4.0F, "SilverOre");

	public static final Block smelterIdle = new BlockSmelter(197, false).setUnlocalizedName("SmelterIdle").setCreativeTab(TabSkyrimBlocks);
	public static final Block smelterActive = new BlockSmelter(198, true).setUnlocalizedName("SmelterActive");
	public static final Block chestSkyrim = new BlockSkyrimChest(199, Material.wood).setUnlocalizedName("SkyrimChest").setCreativeTab(TabSkyrimBlocks);
	public static final Block grindstoneIdle = new BlockGrindstone(200, false).setUnlocalizedName("GrindstoneIdle").setCreativeTab(TabSkyrimBlocks);
	public static final Block grindstoneActive = new BlockGrindstone(201, true).setUnlocalizedName("GrindstoneActive");

	public static final Item daggerEbony = new BaseSword(11012, 10, 1).setUnlocalizedName("EbonyDagger");
	public static final Item warhammerEbony = new BaseSword(11013, 25, -3).setUnlocalizedName("EbonyWarhammer");
	public static final Item warAxeEbony = new BaseSword(11014, 17, -1).setUnlocalizedName("EbonyWarAxe");
	public static final Item swordEbony = new BaseSword(11015, 13, 0).setUnlocalizedName("EbonySword");
	public static final Item greatSwordEbony = new BaseSword(11016, 22, -2).setUnlocalizedName("EbonyGreatsword");
	public static final Item maceEbony = new BaseSword(11017, 16, -1).setUnlocalizedName("EbonyMace");
	public static final Item battleAxeEbony = new BaseSword(11018, 26, -3).setUnlocalizedName("EbonyBattleaxe");

	public static final Item daggerGlass = new BaseSword(11019, 9, 1).setUnlocalizedName("GlassDagger");
	public static final Item warhammerGlass = new BaseSword(11020, 27, -3).setUnlocalizedName("GlassWarhammer");
	public static final Item warAxeGlass = new BaseSword(11021, 17, -1).setUnlocalizedName("GlassWarAxe");
	public static final Item swordGlass = new BaseSword(11022, 12, 0).setUnlocalizedName("GlassSword");
	public static final Item greatSwordGlass = new BaseSword(11023, 24, -2).setUnlocalizedName("GlassGreatsword");
	public static final Item maceGlass = new BaseSword(11024, 14, -1).setUnlocalizedName("GlassMace");
	public static final Item battleAxeGlass = new BaseSword(11025, 25, -3).setUnlocalizedName("GlassBattleaxe");

	public static final Item daggerDaedric = new BaseSword(11026, 11, 1).setUnlocalizedName("DaedricDagger");
	public static final Item warhammerDaedric = new BaseSword(11027, 27, -3).setUnlocalizedName("DaedricWarhammer");
	public static final Item warAxeDaedric = new BaseSword(11028, 15, -1).setUnlocalizedName("DaedricWarAxe");
	public static final Item swordDaedric = new BaseSword(11029, 14, 0).setUnlocalizedName("DaedricSword");
	public static final Item greatSwordDaedric = new BaseSword(11030, 24, -2).setUnlocalizedName("DaedricGreatsword");
	public static final Item maceDaedric = new BaseSword(11031, 16, -1).setUnlocalizedName("DaedricMace");
	public static final Item battleAxeDaedric = new BaseSword(11032, 25, -3).setUnlocalizedName("DaedricBattleaxe");

	public static final Item firewood = new BaseItem(11033).setUnlocalizedName("Firewood");
	public static final Item daedraHeart = new BaseItem(11034).setUnlocalizedName("DaedraHeart");

	public static final Item helmDwarf = new BaseArmor(11035, DWARVEN, 1, 0, "Heavy", "/blfngl/skyrim/textures/DwarvenArmor.png").setUnlocalizedName("DwarfHelm");
	public static final Item chestDwarf = new BaseArmor(11036, DWARVEN, 1, 1, "Heavy", "/blfngl/skyrim/textures/DwarvenArmor.png").setUnlocalizedName("DwarfChest");
	public static final Item gauntletsDwarf = new BaseArmor(11037, DWARVEN, 1, 2, "Heavy", "/blfngl/skyrim/textures/DwarvenArmor.png").setUnlocalizedName("DwarfGauntlets");
	public static final Item bootsDwarf = new BaseArmor(11038, DWARVEN, 1, 3, "Heavy", "/blfngl/skyrim/textures/DwarvenArmor.png").setUnlocalizedName("DwarfBoots");

	public static final Item helmDaedric = new BaseArmor(11039, DAEDRIC, 1, 0, "Heavy", "/blfngl/skyrim/textures/DaedricArmor.png").setUnlocalizedName("DaedricHelm");
	public static final Item chestDaedric = new BaseArmor(11040, DAEDRIC, 1, 1, "Heavy", "/blfngl/skyrim/textures/DaedricArmor.png").setUnlocalizedName("DaedricChest");
	public static final Item gauntletsDaedric = new BaseArmor(11041, DAEDRIC, 1, 2, "Heavy", "/blfngl/skyrim/textures/DaedricArmor.png").setUnlocalizedName("DaedricGauntlets");
	public static final Item bootsDaedric = new BaseArmor(11042, DAEDRIC, 1, 3, "Heavy", "/blfngl/skyrim/textures/DaedricArmor.png").setUnlocalizedName("DaedricBoots");

	public static final Item helmGlass = new BaseArmor(11043, GLASS, 1, 0, "Light", "/blfngl/skyrim/textures/GlassArmor.png").setUnlocalizedName("GlassHelm");
	public static final Item chestGlass = new BaseArmor(11044, GLASS, 1, 1, "Light", "/blfngl/skyrim/textures/GlassArmor.png").setUnlocalizedName("GlassChest");
	public static final Item gauntletsGlass = new BaseArmor(11045, GLASS, 1, 2, "Light", "/blfngl/skyrim/textures/GlassArmor.png").setUnlocalizedName("GlassGauntlets");
	public static final Item bootsGlass = new BaseArmor(11046, GLASS, 1, 3, "Light", "/blfngl/skyrim/textures/GlassArmor.png").setUnlocalizedName("GlassBoots");

	public static final Item helmEbony = new BaseArmor(11047, EBONY, 1, 0, "Heavy", "/blfngl/skyrim/textures/EbonyArmor.png").setUnlocalizedName("EbonyHelm");
	public static final Item chestEbony = new BaseArmor(11048, EBONY, 1, 1, "Heavy","/blfngl/skyrim/textures/EbonyArmor.png").setUnlocalizedName("EbonyChest");
	public static final Item gauntletsEbony = new BaseArmor(11049, EBONY, 1, 2, "Heavy", "/blfngl/skyrim/textures/EbonyArmor.png").setUnlocalizedName("EbonyGauntlets");
	public static final Item bootsEbony = new BaseArmor(11050, EBONY, 1, 3, "Heavy", "/blfngl/skyrim/textures/EbonyArmor.png").setUnlocalizedName("EbonyBoots");

	public static final Item dwemmerBentScrap = new BaseItem(11051).setUnlocalizedName("DwemmerBentScrap");
	public static final Item dwemmerLargePlate = new BaseItem(11052).setUnlocalizedName("DwemmerLargePlate");
	public static final Item dwemmerSmallPlate = new BaseItem(11053).setUnlocalizedName("DwemmerSmallPlate");
	public static final Item dwemmerMetal = new BaseItem(11054).setUnlocalizedName("DwemmerMetal");
	public static final Item dwemmerStrut = new BaseItem(11055).setUnlocalizedName("DwemmerStrut");

	public static final Item bowDaedric = new ItemSkyrimBow(11056).setUnlocalizedName("DaedricBow");
	public static final Item arrowDaedric = new BaseItem(11057).setUnlocalizedName("DaedricArrow");
	public static final Item arrowGlass = new BaseItem(11058).setUnlocalizedName("GlassArrow");
	public static final Item arrowIron = new BaseItem(11059).setUnlocalizedName("IronArrow");
	public static final Item arrowDragonbone = new BaseItem(11060).setUnlocalizedName("DragonboneArrow");
	public static final Item arrowDwarven = new BaseItem(11061).setUnlocalizedName("DwarvenArrow");

	public static final Item saltPile = new BaseItem(11062).setUnlocalizedName("SaltPile").setCreativeTab(TabSkyrimFood);
	public static final Item butter = new BaseItem(11063).setUnlocalizedName("Butter").setCreativeTab(TabSkyrimFood);
	public static final Item garlic = new BaseItem(11064).setUnlocalizedName("Garlic").setCreativeTab(TabSkyrimFood);
	public static final Item leek = new BaseItem(11065).setUnlocalizedName("Leek").setCreativeTab(TabSkyrimFood);
	public static final Item sack = new BaseItem(11066).setUnlocalizedName("Sack").setCreativeTab(TabSkyrimItems);
	public static final Item sackFlour = new BaseItem(11067).setUnlocalizedName("FlourSack").setCreativeTab(TabSkyrimItems);

	public static final ItemFood foodCabbage = (ItemFood) new BaseFood(11068, 1, 0.5F, false).setUnlocalizedName("Cabbage");
	public static final ItemFood foodApplePie = (ItemFood) new BaseFood(11069, 5, 2.0F, false).setUnlocalizedName("ApplePie");
	public static final ItemFood foodAppleCabbageStew = (ItemFood) new BaseFood(11070, 7, 0.5F, false).setUnlocalizedName("AppleCabbageStew");
	public static final ItemFood foodBeefStew = (ItemFood) new BaseFood(11071, 10, 0.5F, false).setUnlocalizedName("BeefStew");
	public static final ItemFood foodCabbagePotatoSoup = (ItemFood) new BaseFood(11072, 7, 0.5F, false).setUnlocalizedName("CabbagePotatoSoup");

	public static final Item daggerOrc = new BaseSword(11073, 7, 1).setUnlocalizedName("OrcishDagger");
	public static final Item warhammerOrc = new BaseSword(11074, 21, -3).setUnlocalizedName("OrcishWarhammer");
	public static final Item warAxeOrc = new BaseSword(11075, 11, -1).setUnlocalizedName("OrcishWarAxe");
	public static final Item swordOrc = new BaseSword(11076, 10, 0).setUnlocalizedName("OrcishSword");
	public static final Item greatSwordOrc = new BaseSword(11077, 18, -2).setUnlocalizedName("OrcishGreatsword");
	public static final Item maceOrc = new BaseSword(11078, 12, -1).setUnlocalizedName("OrcishMace");
	public static final Item battleAxeOrc = new BaseSword(11079, 19, -3).setUnlocalizedName("OrcishBattleaxe");

	public static final Item helmOrc = new BaseArmor(11080, ORCISH, 1, 0, "Heavy", "/blfngl/skyrim/textures/OrcishArmor.png").setUnlocalizedName("OrcishHelm");
	public static final Item chestOrc = new BaseArmor(11081, ORCISH, 1, 1, "Heavy", "/blfngl/skyrim/textures/OrcishArmor.png").setUnlocalizedName("OrcishChest");
	public static final Item gauntletsOrc = new BaseArmor(11082, ORCISH, 1, 2, "Heavy", "/blfngl/skyrim/textures/OrcishArmor.png").setUnlocalizedName("OrcishGauntlets");
	public static final Item bootsOrc = new BaseArmor(11083, ORCISH, 1, 3, "Heavy", "/blfngl/skyrim/textures/OrcishArmor.png").setUnlocalizedName("OrcishBoots");

	//public static final Item wabbajack = new ItemWabbajack(11084).setUnlocalizedName("Wabbajack");
	//public static final Item shoutFus = new ItemShout(11085).setUnlocalizedName("Shout");

	public static final Item helmSteel = new BaseArmor(11086, STEEL, 1, 0, "Heavy", "/blfngl/skyrim/textures/SteelArmor.png").setUnlocalizedName("SteelHelm");
	public static final Item chestSteel = new BaseArmor(11087, STEEL, 1, 1, "Heavy", "/blfngl/skyrim/textures/SteelArmor.png").setUnlocalizedName("SteelChest");
	public static final Item gauntletsSteel = new BaseArmor(11088, STEEL, 1, 2, "Heavy", "/blfngl/skyrim/textures/SteelArmor.png").setUnlocalizedName("SteelGauntlets");
	public static final Item bootsSteel = new BaseArmor(11089, STEEL, 1, 3, "Heavy", "/blfngl/skyrim/textures/SteelArmor.png").setUnlocalizedName("SteelBoots");

	public static final Item daggerSteel = new BaseSword(11090, 5, 1).setUnlocalizedName("SteelDagger");
	public static final Item warhammerSteel = new BaseSword(11091, 22, -3).setUnlocalizedName("SteelWarhammer");
	public static final Item warAxeSteel = new BaseSword(11092, 9, -1).setUnlocalizedName("SteelWarAxe");
	public static final Item swordSteel = new BaseSword(11093, 9, 0).setUnlocalizedName("SteelSword");
	public static final Item greatSwordSteel = new BaseSword(11094, 17, -2).setUnlocalizedName("SteelGreatsword");
	public static final Item maceSteel = new BaseSword(11095, 11, -1).setUnlocalizedName("SteelMace");
	public static final Item battleAxeSteel = new BaseSword(11096, 18, -3).setUnlocalizedName("SteelBattleaxe");

	//TODO Stalhrim armor creds
	//http://www.planetminecraft.com/skin/stalhrim-2204798/
	public static final Item helmStalhrim = new BaseArmor(11097, STALHRIM, 1, 0, "Heavy", "/blfngl/skyrim/textures/StalhrimArmor.png").setUnlocalizedName("StalhrimHelm");
	public static final Item chestStalhrim = new BaseArmor(11098, STALHRIM, 1, 1, "Heavy", "/blfngl/skyrim/textures/StalhrimArmor.png").setUnlocalizedName("StalhrimChest");
	public static final Item gauntletsStalhrim = new BaseArmor(11099, STALHRIM, 1, 2, "Heavy", "/blfngl/skyrim/textures/StalhrimArmor.png").setUnlocalizedName("StalhrimGauntlets");
	public static final Item bootsStalhrim = new BaseArmor(11100, STALHRIM, 1, 3, "Heavy", "/blfngl/skyrim/textures/StalhrimArmor.png").setUnlocalizedName("StalhrimBoots");

	public static final Item daggerStalhrim = new BaseSword(11101, 10, 1).setUnlocalizedName("StalhrimDagger");
	public static final Item warhammerStalhrim = new BaseSword(11102, 22, -3).setUnlocalizedName("StalhrimWarhammer");
	public static final Item warAxeStalhrim = new BaseSword(11103, 15, -1).setUnlocalizedName("StalhrimWarAxe");
	public static final Item swordStalhrim = new BaseSword(11104, 13, 0).setUnlocalizedName("StalhrimSword");
	public static final Item greatSwordStalhrim = new BaseSword(11105, 23, -2).setUnlocalizedName("StalhrimGreatsword");
	public static final Item maceStalhrim = new BaseSword(11106, 16, -1).setUnlocalizedName("StalhrimMace");
	public static final Item battleAxeStalhrim = new BaseSword(11107, 26, -3).setUnlocalizedName("StalhrimBattleAxe");

	public static final Item ancientPick = new BasePick(11108, STALHRIMTOOL).setUnlocalizedName("AncientPick").setCreativeTab(TabSkyrimItems);

	public static final BlockOre oreStalhrim = new BlockBase(202, 0, Material.rock, 7.0F, "StalhrimOre");

	public static final Item stalhrim = new BaseItem(11109).setUnlocalizedName("Stalhrim").setCreativeTab(TabSkyrimItems);

	public static final Item daggerNordic = new BaseSword(11110, 8, 1).setUnlocalizedName("NordicDagger");
	public static final Item warhammerNordic = new BaseSword(11111, 23, -3).setUnlocalizedName("NordicWarhammer");
	public static final Item warAxeNordic = new BaseSword(11112, 12, -1).setUnlocalizedName("NordicWarAxe");
	public static final Item swordNordic = new BaseSword(11113, 11, 0).setUnlocalizedName("NordicSword");
	public static final Item greatSwordNordic = new BaseSword(11114, 20, -2).setUnlocalizedName("NordicGreatsword");
	public static final Item maceNordic = new BaseSword(11115, 13, -1).setUnlocalizedName("NordicMace");
	public static final Item battleAxeNordic = new BaseSword(11116, 21, -3).setUnlocalizedName("NordicBattleaxe");

	public static final Item helmNordic = new BaseArmor(11117, EBONY, 1, 0, "Heavy", "/blfngl/skyrim/textures/NordicArmor.png").setUnlocalizedName("NordicHelm");
	public static final Item chestNordic = new BaseArmor(11118, EBONY, 1, 1, "Heavy", "/blfngl/skyrim/textures/NordicArmor.png").setUnlocalizedName("NordicChest");
	public static final Item gauntletsNordic = new BaseArmor(11119, EBONY, 1, 2, "Heavy", "/blfngl/skyrim/textures/NordicArmor.png").setUnlocalizedName("NordicGauntlets");
	public static final Item bootsNordic = new BaseArmor(11120, EBONY, 1, 3, "Heavy", "/blfngl/skyrim/textures/NordicArmor.png").setUnlocalizedName("NordicBoots");

	public static final Item helmElven = new BaseArmor(11121, ELVEN, 1, 0, "Light", "/blfngl/skyrim/textures/ElvenArmor.png").setUnlocalizedName("ElvenHelm");
	public static final Item chestElven = new BaseArmor(11122, ELVEN, 1, 1, "Light", "/blfngl/skyrim/textures/ElvenArmor.png").setUnlocalizedName("ElvenChest");
	public static final Item gauntletsElven = new BaseArmor(11123, ELVEN, 1, 2, "Light", "/blfngl/skyrim/textures/ElvenArmor.png").setUnlocalizedName("ElvenGauntlets");
	public static final Item bootsElven = new BaseArmor(11124, ELVEN, 1, 3, "Light", "/blfngl/skyrim/textures/ElvenArmor.png").setUnlocalizedName("ElvenBoots");
	public static final Item chestElvenGilded = new BaseArmor(11125, ELVENGILDED, 1, 1, "Light", "/blfngl/skyrim/textures/ElvenArmor.png").setUnlocalizedName("ElvenChestGilded");

	//TODO Ancient Nord armor creds
	//http://www.planetminecraft.com/skin/ancient-nordic-armor-from-skyrim3d-horns/
	public static final Item helmAncientNord = new BaseArmor(11126, ANCIENTNORD, 1, 0, "Heavy", "/blfngl/skyrim/textures/AncientNordArmor.png").setUnlocalizedName("AncientNordHelm");
	public static final Item chestAncientNord = new BaseArmor(11127, ANCIENTNORD, 1, 1, "Heavy", "/blfngl/skyrim/textures/AncientNordArmor.png").setUnlocalizedName("AncientNordChest");
	public static final Item gauntletsAncientNord = new BaseArmor(11128, ANCIENTNORD, 1, 2, "Heavy", "/blfngl/skyrim/textures/AncientNordArmor.png").setUnlocalizedName("AncientNordGauntlets");
	public static final Item bootsAncientNord = new BaseArmor(11129, ANCIENTNORD, 1, 3, "Heavy", "/blfngl/skyrim/textures/AncientNordArmor.png").setUnlocalizedName("AncientNordBoots");

	public static final Item helmStalhrimLight = new BaseArmor(11130, STALHRIM, 1, 0, "Heavy", "/blfngl/skyrim/textures/StalhrimArmor.png").setUnlocalizedName("StalhrimHelm");
	public static final Item chestStalhrimLight = new BaseArmor(11131, STALHRIM, 1, 1, "Heavy", "/blfngl/skyrim/textures/StalhrimArmor.png").setUnlocalizedName("StalhrimChest");
	public static final Item gauntletsStalhrimLight = new BaseArmor(11132, STALHRIM, 1, 2, "Heavy", "/blfngl/skyrim/textures/StalhrimArmor.png").setUnlocalizedName("StalhrimGauntlets");
	public static final Item bootsStalhrimLight = new BaseArmor(11133, STALHRIM, 1, 3, "Heavy", "/blfngl/skyrim/textures/StalhrimArmor.png").setUnlocalizedName("StalhrimBoots");

	public static final Item helmSteelI = new BaseArmor(11134, ANCIENTNORD, 1, 0, "Heavy", "/blfngl/skyrim/textures/SteelArmor.png").setUnlocalizedName("SteelImperialHelm");
	public static final Item gauntletsSteelI = new BaseArmor(11135, ANCIENTNORD, 1, 2, "Heavy", "/blfngl/skyrim/textures/SteelArmor.png").setUnlocalizedName("SteelImperialGauntlets");
	public static final Item bootsSteelI = new BaseArmor(11136, ANCIENTNORD, 1, 3, "Heavy", "/blfngl/skyrim/textures/SteelArmor.png").setUnlocalizedName("SteelImperialBoots");

	public static final Item dragonKiller = new BaseSword(11200, 9999, -3).setUnlocalizedName("DragonKiller");

	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		NetworkRegistry.instance().registerGuiHandler(this, this.proxy);
		instance = this;

		proxy.registerSoundHandler();
		MinecraftForge.EVENT_BUS.register(new SkryrimVanillaDrops());

		ModMetadata var2 = event.getModMetadata();
		var2.authorList = Arrays.asList(new String[] {"Blfngl"});
		var2.autogenerated = false;
		var2.modId = "skyrim";
		var2.name = "The Skyrim Mod";
		var2.description = "Created a while back, but another one was already out. " +
				"Now that the other has gone down, I've decided to release mine as a mediocre replacement. " +
				"I could never match the fan base/epicness of the old one, and this is dedicated to its creator.";
		var2.version = "1.0.5";
		var2.credits = "Mojang, MinecraftForge and everyone that uses this mod :)";
		var2.logoFile = "/blfngl/skyrim/textures/blflogo.png";
		var2.url = "http://www.minecraftforum.net/topic/1812302-";
		System.out.println("Blfngl's Skyrim Mod Loaded. BY AKATOSH YES.");
	}

	@Init
	public void init(FMLInitializationEvent event)
	{
		Languages.init();
		Recipes.init();
		Blocks.init();
		WorldHandler.init();
		EntityHandler.init();

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ancientPick), 1, 1, 10));

		proxy.registerTileEntities();
		proxy.registerServerTickHandler();
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);

		GameRegistry.registerTileEntity(TileEntitySmelter.class, "Smelter");
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, "Grindstone");
	}

	@PostInit
	public static void postInit(FMLPostInitializationEvent event)
	{

	}
}