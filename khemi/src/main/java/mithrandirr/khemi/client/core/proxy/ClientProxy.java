package mithrandirr.khemi.client.core.proxy;

import mithrandirr.khemi.client.core.handler.ClientTickHandler;
import mithrandirr.khemi.client.fx.FXLightning;
import mithrandirr.khemi.client.fx.FXSparkle;
import mithrandirr.khemi.client.fx.FXWisp;
import mithrandirr.khemi.client.render.RendererMortar;
import mithrandirr.khemi.common.block.tile.TileMortar;
import mithrandirr.khemi.common.core.helper.Vector3;
import mithrandirr.khemi.common.core.proxy.IProxy;
import mithrandirr.khemi.common.item.ModItems;
import mithrandirr.khemi.common.lib.LibMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ClientProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		initRenderers();
		OBJLoader.INSTANCE.addDomain(LibMod.MOD_ID);
		registerModel(ModItems.pestle);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}

	private void initRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileMortar.class, new RendererMortar());
	}

    public void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(LibMod.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

	@Override
	public long getWorldElapsedTicks() { return ClientTickHandler.ticksInGame; }

	private static boolean noclipEnabled = false;
	private static boolean corruptSparkle = false;

	@Override
	public void setSparkleFXNoClip(boolean noclip) {
		noclipEnabled = noclip;
	}

	@Override
	public void setSparkleFXCorrupt(boolean corrupt) {
		corruptSparkle = corrupt;
	}

	@Override
	public void sparkleFX(double x, double y, double z, float r, float g, float b, float size, int m, boolean fake) {
		if(!doParticle() && !fake)
			return;

		FXSparkle sparkle = new FXSparkle(Minecraft.getMinecraft().world, x, y, z, size, r, g, b, m);
		sparkle.fake = fake;
		sparkle.setCanCollide(!fake);
		if(noclipEnabled)
			sparkle.setCanCollide(false);
		if(corruptSparkle)
			sparkle.corrupt = true;
		Minecraft.getMinecraft().effectRenderer.addEffect(sparkle);
	}

	private static boolean distanceLimit = true;
	private static boolean depthTest = true;

	@Override
	public void setWispFXDistanceLimit(boolean limit) {
		distanceLimit = limit;
	}

	@Override
	public void setWispFXDepthTest(boolean test) {
		depthTest = test;
	}

	@Override
	public void wispFX(double x, double y, double z, float r, float g, float b, float size, float motionx, float motiony, float motionz, float maxAgeMul) {
		if(!doParticle())
			return;

		FXWisp wisp = new FXWisp(Minecraft.getMinecraft().world, x, y, z, size, r, g, b, distanceLimit, depthTest, maxAgeMul);
		wisp.setSpeed(motionx, motiony, motionz);
		Minecraft.getMinecraft().effectRenderer.addEffect(wisp);
	}

	private boolean doParticle() {
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
			return false;

		float chance = 1F;
		if(Minecraft.getMinecraft().gameSettings.particleSetting == 1)
			chance = 0.6F;
		else if(Minecraft.getMinecraft().gameSettings.particleSetting == 2)
			chance = 0.2F;

		return chance == 1F || Math.random() < chance;
	}

	@Override
	public void lightningFX(Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, long seed, int colorOuter, int colorInner) {
		Minecraft.getMinecraft().effectRenderer.addEffect(new FXLightning(Minecraft.getMinecraft().world, vectorStart, vectorEnd, ticksPerMeter, seed, colorOuter, colorInner));
	}

}
