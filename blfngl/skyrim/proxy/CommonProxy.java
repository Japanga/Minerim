package blfngl.skyrim.proxy;

import blfngl.skyrim.tileentity.TileEntityGrindstone;
import blfngl.skyrim.tileentity.TileEntitySmelter;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy
{
	public void registerRenderers(){}
	public void registerSoundHandler(){}

	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntitySmelter.class, "furnaceDoubleGui");
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, "GrindstoneTile");
	}

	public void registerServerTickHandler()
	{
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
	}
}