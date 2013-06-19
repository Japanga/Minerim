package blfngl.skyrim.proxy;

import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import blfngl.skyrim.entity.EntityDaedricArrow;
import blfngl.skyrim.handler.SoundHandler;
import blfngl.skyrim.inventory.GuiGrindstone;
import blfngl.skyrim.inventory.GuiSmelter;
import blfngl.skyrim.tileentity.TileEntityGrindstone;
import blfngl.skyrim.tileentity.TileEntitySmelter;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDaedricArrow.class, new RenderArrow());
		super.registerTileEntities();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerSoundHandler()
	{
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

		if (tileEntity != null)
		{
			switch(ID)
			{
			case 0: return new GuiSmelter(player.inventory, (TileEntitySmelter)tileEntity);
			case 1: return new GuiChest(player.inventory, (TileEntityChest)tileEntity);
			case 2: return new GuiGrindstone(player.inventory, (TileEntityGrindstone)tileEntity);
			}
		}
		return null;
	}
}