package blfngl.skyrim.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import blfngl.skyrim.Skyrim;

public class BaseArmor extends ItemArmor implements IArmorTextureProvider
{
	public String type;

	public BaseArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String par5)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		setCreativeTab(Skyrim.TabSkyrimArmor);
		type = par5;
	}

	public void func_94581_a(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	public String getArmorTextureFile(ItemStack par1)
	{
		if (par1.itemID == Skyrim.helmDaedric.itemID||par1.itemID == Skyrim.chestDaedric.itemID||par1.itemID == Skyrim.gauntletsDaedric.itemID
				||par1.itemID == Skyrim.bootsDaedric.itemID)
		{
			return "/blfngl/skyrim/textures/DaedricArmor.png";
		}

		if (par1.itemID == Skyrim.helmGlass.itemID||par1.itemID == Skyrim.chestGlass.itemID||par1.itemID == Skyrim.gauntletsGlass.itemID
				||par1.itemID == Skyrim.bootsGlass.itemID)
		{
			return "/blfngl/skyrim/textures/GlassArmor.png";
		}

		if (par1.itemID == Skyrim.helmOrc.itemID||par1.itemID == Skyrim.chestOrc.itemID||par1.itemID == Skyrim.gauntletsOrc.itemID
				||par1.itemID == Skyrim.bootsOrc.itemID)
		{
			return "/blfngl/skyrim/textures/OrcishArmor.png";
		}

		if (par1.itemID == Skyrim.helmDwarf.itemID||par1.itemID == Skyrim.chestDwarf.itemID||par1.itemID == Skyrim.gauntletsDwarf.itemID
				||par1.itemID == Skyrim.bootsDwarf.itemID)
		{
			return "/blfngl/skyrim/textures/DwarvenArmor.png";
		}

		if (par1.itemID == Skyrim.helmDaedric.itemID||par1.itemID == Skyrim.chestDaedric.itemID||par1.itemID == Skyrim.gauntletsDaedric.itemID
				||par1.itemID == Skyrim.bootsDaedric.itemID)
		{
			return "/blfngl/skyrim/textures/DaedricArmor.png";
		}

		if (par1.itemID == Skyrim.helmEbony.itemID||par1.itemID == Skyrim.chestEbony.itemID||par1.itemID == Skyrim.gauntletsEbony.itemID
				||par1.itemID == Skyrim.bootsEbony.itemID)
		{
			return "/blfngl/skyrim/textures/EbonyArmor.png";
		}

		if (par1.itemID == Skyrim.helmSteel.itemID||par1.itemID == Skyrim.chestSteel.itemID||par1.itemID == Skyrim.gauntletsSteel.itemID
				||par1.itemID == Skyrim.bootsSteel.itemID)
		{
			return "/blfngl/skyrim/textures/SteelArmor.png";
		}

		if (par1.itemID == Skyrim.helmStalhrim.itemID||par1.itemID == Skyrim.chestStalhrim.itemID||par1.itemID == Skyrim.gauntletsStalhrim.itemID
				||par1.itemID == Skyrim.bootsStalhrim.itemID)
		{
			return "/blfngl/skyrim/textures/StalhrimArmor.png";
		}

		if (par1.itemID == Skyrim.helmElven.itemID||par1.itemID == Skyrim.chestElven.itemID||par1.itemID == Skyrim.gauntletsElven.itemID
				||par1.itemID == Skyrim.bootsElven.itemID)
		{
			return "/blfngl/skyrim/textures/ElvenArmor.png";
		}

		return "/lol.png";
	}

	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		var3.add(type + " Armor");
	}
}