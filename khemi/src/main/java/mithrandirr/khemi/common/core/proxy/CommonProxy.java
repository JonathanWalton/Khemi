package mithrandirr.khemi.common.core.proxy;

import mithrandirr.khemi.common.core.helper.Vector3;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		
	}

	@Override
	public void init(FMLInitializationEvent event) {
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}

	@Override
	public long getWorldElapsedTicks() { return FMLCommonHandler.instance().getMinecraftServerInstance().worlds[0].getTotalWorldTime(); }

	@Override
	public void setSparkleFXNoClip(boolean noclip) { }

	@Override
	public void setSparkleFXCorrupt(boolean corrupt) { }

	@Override
	public void sparkleFX(double x, double y, double z, float r, float g, float b, float size, int m, boolean fake) { }

	@Override
	public void setWispFXDistanceLimit(boolean limit) { }

	@Override
	public void setWispFXDepthTest(boolean depth) { }

	@Override
	public void wispFX(double x, double y, double z, float r, float g, float b, float size, float motionx, float motiony, float motionz, float maxAgeMul) { }

	@Override
	public void lightningFX(Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, long seed, int colorOuter, int colorInner) { }

}
