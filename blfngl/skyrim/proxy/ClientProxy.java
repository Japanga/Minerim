package blfngl.skyrim.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.common.MinecraftForge;
import blfngl.skyrim.entity.EntityDremora;
import blfngl.skyrim.entity.EntitySkyrimArrow;
import blfngl.skyrim.entity.render.RenderDaedricArrow;
import blfngl.skyrim.entity.render.RenderDremora;
import blfngl.skyrim.handler.SoundHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDremora.class, new RenderDremora(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkyrimArrow.class, new RenderDaedricArrow());
		super.registerTileEntities();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerSoundHandler()
	{
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
	}
}