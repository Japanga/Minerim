package blfngl.skyrim.inventory;

import java.util.Random;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.util.glu.GLU;

public class GuiArcaneEnchanter extends GuiContainer
{
	/** The book model used on the GUI. */
	private static ModelBook bookModel = new ModelBook();
	private Random rand = new Random();

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
		this.mc.renderEngine.bindTexture("/mods/skyrim/art/GuiEnchanter.png");
		int var5 = (this.width - this.xSize) / 2;
		int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
		GL11.glPushMatrix();
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		ScaledResolution var7 = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
		GL11.glViewport((var7.getScaledWidth() - 320) / 2 * var7.getScaleFactor(), (var7.getScaledHeight() - 240) / 2 * var7.getScaleFactor(), 320 * var7.getScaleFactor(), 240 * var7.getScaleFactor());
		GL11.glTranslatef(-0.34F, 0.23F, 0.0F);
		GLU.gluPerspective(90.0F, 1.3333334F, 9.0F, 80.0F);
		float var8 = 1.0F;
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		RenderHelper.enableStandardItemLighting();
		GL11.glTranslatef(0.0F, 3.3F, -16.0F);
		GL11.glScalef(var8, var8, var8);
		float var9 = 5.0F;
		GL11.glScalef(var9, var9, var9);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		this.mc.renderEngine.bindTexture("/mods/MTJT/textures/gui/book.png");
		GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
		float var10 = this.field_74208_u + (this.field_74209_t - this.field_74208_u) * par1;
		GL11.glTranslatef((1.0F - var10) * 0.2F, (1.0F - var10) * 0.1F, (1.0F - var10) * 0.25F);
		GL11.glRotatef(-(1.0F - var10) * 90.0F - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		float var11 = this.field_74212_q + (this.field_74213_p - this.field_74212_q) * par1 + 0.25F;
		float var12 = this.field_74212_q + (this.field_74213_p - this.field_74212_q) * par1 + 0.75F;
		var11 = (var11 - (float)MathHelper.truncateDoubleToInt((double)var11)) * 1.6F - 0.3F;
		var12 = (var12 - (float)MathHelper.truncateDoubleToInt((double)var12)) * 1.6F - 0.3F;

		if (var11 < 0.0F)
		{
			var11 = 0.0F;
		}

		if (var12 < 0.0F)
		{
			var12 = 0.0F;
		}

		if (var11 > 1.0F)
		{
			var11 = 1.0F;
		}

		if (var12 > 1.0F)
		{
			var12 = 1.0F;
		}

		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		bookModel.render((Entity)null, 0.0F, var11, var12, var10, 0.0F, 0.0625F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		RenderHelper.disableStandardItemLighting();
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
		GL11.glPopMatrix();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture("/textures/gui/enchant.png");
	}
}