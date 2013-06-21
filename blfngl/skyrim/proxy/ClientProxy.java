package blfngl.skyrim.proxy;

import net.minecraftforge.common.MinecraftForge;
import blfngl.skyrim.entity.EntityDaedricArrow;
import blfngl.skyrim.handler.SoundHandler;
import blfngl.skyrim.render.RenderDaedricArrow;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDaedricArrow.class, new RenderDaedricArrow());
		super.registerTileEntities();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerSoundHandler()
	{
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
	}
}