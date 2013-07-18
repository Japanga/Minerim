package blfngl.skyrim.inventory;

import java.util.Random;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class GuiArcaneEnchanter extends GuiContainer
{
	private Random rand = new Random();
	private static final ResourceLocation resourceLocation = new ResourceLocation("skyrim:Enchanter");
	private ContainerArcaneEnchanter containerSpiritTable;

	public int field_74214_o;
	public float field_74213_p;
	public float field_74212_q;
	public float field_74211_r;
	public float field_74210_s;
	public float field_74209_t;
	public float field_74208_u;
	ItemStack theItemStack;

	public GuiArcaneEnchanter(InventoryPlayer inventory, World world, int par3, int par4, int par5)
	{
		super(new ContainerArcaneEnchanter(inventory, world, par3, par4, par5));
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		this.fontRenderer.drawString(StatCollector.translateToLocal("container.enchant"), 12, 6, 4210752);
		this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	public void updateScreen()
	{
		super.updateScreen();
	}

	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.func_110577_a(resourceLocation); //("/mods/skyrim/art/GuiEnchanter.png");
		int var5 = (this.width - this.xSize) / 2;
		int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
	}
}