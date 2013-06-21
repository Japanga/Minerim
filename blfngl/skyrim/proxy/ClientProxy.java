package blfngl.skyrim.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraftforge.common.MinecraftForge;
import blfngl.skyrim.entity.EntityDaedricArrow;
import blfngl.skyrim.entity.EntityMerchant;
import blfngl.skyrim.entity.render.RenderDaedricArrow;
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
		RenderingRegistry.registerEntityRenderingHandler(EntityDaedricArrow.class, new RenderDaedricArrow());
		//RenderingRegistry.registerEntityRenderingHandler(EntityMerchant.class, new RenderBiped(new ModelBiped, 0.5F));
		super.registerTileEntities();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerSoundHandler()
	{
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
	}
}