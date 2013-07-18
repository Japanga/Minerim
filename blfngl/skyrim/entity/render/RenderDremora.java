package blfngl.skyrim.entity.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import blfngl.skyrim.entity.EntityDremora;

public class RenderDremora extends RenderBiped
{
	public RenderDremora(ModelBiped par1ModelBiped, float par2)
	{
		super(par1ModelBiped, par2);
	}

	private static final ResourceLocation resourceLocation = new ResourceLocation("skyrim:assets/skyrim/mob/Dremora.png");

	protected ResourceLocation func_110886_a(EntityDremora par1Entity)
	{
		return resourceLocation;
	}
	protected ResourceLocation func_110775_a(Entity par1Entity)
	{
		return this.func_110886_a((EntityDremora) par1Entity);
	}
}