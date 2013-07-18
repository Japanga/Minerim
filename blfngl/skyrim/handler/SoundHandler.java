package blfngl.skyrim.handler;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import blfngl.skyrim.Skyrim;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoundHandler
{
	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		try 
		{
			event.manager.soundPoolSounds.addSound("skyrim:Alduin1.ogg");
			event.manager.soundPoolSounds.addSound("skyrim:Alduin2.ogg");
			event.manager.soundPoolSounds.addSound("skyrim:Alduin3.ogg");
			event.manager.soundPoolSounds.addSound("skyrim:Dragon.ogg");
		}

		catch (Exception e)
		{
			System.err.println("Skyrim: Failed to register one or more sounds.");
		}
	}
}