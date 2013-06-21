package blfngl.skyrim.handler;

import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import blfngl.skyrim.inventory.ContainerForge;
import blfngl.skyrim.inventory.ContainerGrindstone;
import blfngl.skyrim.inventory.ContainerSmelter;
import blfngl.skyrim.inventory.GuiForge;
import blfngl.skyrim.inventory.GuiGrindstone;
import blfngl.skyrim.inventory.GuiLevelUp;
import blfngl.skyrim.inventory.GuiSmelter;
import blfngl.skyrim.tileentity.TileEntityGrindstone;
import blfngl.skyrim.tileentity.TileEntitySmelter;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{

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
		
		if (ID == 3){return new ContainerForge(player.inventory, world, x, y, z);}

		return null;
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
		
		if (ID == 3){return new GuiForge(player.inventory, world, x, y, z);}
		if (ID == 4){return new GuiLevelUp(player);}
		
		return null;
	}
}
