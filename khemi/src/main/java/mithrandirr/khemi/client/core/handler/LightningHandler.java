package mithrandirr.khemi.client.core.handler;

import java.util.ArrayDeque;
import java.util.Deque;

import org.lwjgl.opengl.GL11;

import mithrandirr.khemi.client.fx.FXLightning;
import mithrandirr.khemi.client.fx.ParticleRenderDispatcher;
import mithrandirr.khemi.client.lib.LibResources;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.profiler.Profiler;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class LightningHandler {

	private LightningHandler() {}

	private static final int BATCH_THRESHOLD = 200;
	private static final ResourceLocation outsideResource = new ResourceLocation(LibResources.MISC_WISP_LARGE);
	private static final ResourceLocation insideResource = new ResourceLocation(LibResources.MISC_WISP_SMALL);
	public static final Deque<FXLightning> queuedLightningBolts = new ArrayDeque<>();

	@SubscribeEvent
	public static void onRenderWorldLast(RenderWorldLastEvent event) {
		Profiler profiler = Minecraft.getMinecraft().mcProfiler;

		profiler.startSection("botania-particles");
		ParticleRenderDispatcher.dispatch();
		profiler.endStartSection("lightning");

		float frame = event.getPartialTicks();
		Entity entity = Minecraft.getMinecraft().player;
		TextureManager render = Minecraft.getMinecraft().renderEngine;

		double interpPosX = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * frame;
		double interpPosY = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * frame;
		double interpPosZ = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * frame;

		GlStateManager.pushMatrix();
		GlStateManager.translate(-interpPosX, -interpPosY, -interpPosZ);

		Tessellator tessellator = Tessellator.getInstance();

		GlStateManager.depthMask(false);
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		ParticleRenderDispatcher.lightningCount = 0;

		render.bindTexture(outsideResource);
		int counter = 0;

		tessellator.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
		for (FXLightning bolt : queuedLightningBolts) {
			bolt.renderBolt(0, false);
			if(counter % BATCH_THRESHOLD == BATCH_THRESHOLD - 1) {
				tessellator.draw();
				tessellator.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
			}
			counter++;
		}
		tessellator.draw();

		render.bindTexture(insideResource);
		counter = 0;

		tessellator.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
		for (FXLightning bolt : queuedLightningBolts) {
			bolt.renderBolt(1, true);
			if(counter % BATCH_THRESHOLD == BATCH_THRESHOLD - 1) {
				tessellator.draw();
				tessellator.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
			}
			counter++;
		}
		tessellator.draw();

		queuedLightningBolts.clear();

		GlStateManager.disableBlend();
		GlStateManager.depthMask(true);

		GlStateManager.translate(interpPosX, interpPosY, interpPosZ);
		GlStateManager.popMatrix();

		profiler.endSection();
		profiler.endSection();

	}
}