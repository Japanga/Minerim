package blfngl.skyrim.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import blfngl.skyrim.inventory.ContainerGrindstone;
import blfngl.skyrim.inventory.ContainerSmelter;
import blfngl.skyrim.tileentity.TileEntityGrindstone;
import blfngl.skyrim.tileentity.TileEntitySmelter;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy implements IGuiHandler
{
	public void registerRenderers()
	{

	}

	public void registerSoundHandler()
	{

	}

	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntitySmelter.class, "furnaceDoubleGui");
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, "GrindstoneTile");
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{ 
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

		if(tileEntity != null)
		{
			switch(ID)
			{
			case 0: return new ContainerSmelter(player.inventory, (TileEntitySmelter)tileEntity);
			case 1: return new ContainerChest(player.inventory, (TileEntityChest)tileEntity);
			case 2: return new ContainerGrindstone(player.inventory, (TileEntityGrindstone)tileEntity);
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	public void registerServerTickHandler()
	{
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
	}
}