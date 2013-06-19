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
			event.manager.soundPoolSounds.addSound("blfngl/Alduin1.ogg", Skyrim.class.getResource("/blfngl/skyrim/sounds/Alduin1.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/Alduin2.ogg", Skyrim.class.getResource("/blfngl/skyrim/sounds/Alduin2.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/Alduin3.ogg", Skyrim.class.getResource("/blfngl/skyrim/sounds/Alduin3.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/Dragon.ogg", Skyrim.class.getResource("/blfngl/skyrim/sounds/Dragon.ogg"));
		}

		catch (Exception e)
		{
			System.err.println("Skyrim: Failed to register one or more sounds.");
		}
	}
}