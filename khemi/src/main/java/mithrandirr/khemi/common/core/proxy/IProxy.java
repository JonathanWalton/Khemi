package mithrandirr.khemi.common.core.proxy;

import mithrandirr.khemi.common.core.helper.Vector3;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy {
	
	void preInit(FMLPreInitializationEvent event);

	void init(FMLInitializationEvent event);

	void postInit(FMLPostInitializationEvent event);

	long getWorldElapsedTicks();

	void setSparkleFXNoClip(boolean noclip);

	void setSparkleFXCorrupt(boolean corrupt);

	default void sparkleFX(double x, double y, double z, float r, float g, float b, float size, int m) {
		sparkleFX(x, y, z, r, g, b, size, m, false);
	}

	void sparkleFX(double x, double y, double z, float r, float g, float b, float size, int m, boolean fake);

	void setWispFXDistanceLimit(boolean limit);

	void setWispFXDepthTest(boolean depth);

	default void wispFX(double x, double y, double z, float r, float g, float b, float size) {
		wispFX(x, y, z, r, g, b, size, 0F);
	}

	default void wispFX(double x, double y, double z, float r, float g, float b, float size, float gravity) {
		wispFX(x, y, z, r, g, b, size, gravity, 1F);
	}

	default void wispFX(double x, double y, double z, float r, float g, float b, float size, float gravity, float maxAgeMul) {
		wispFX(x, y, z, r, g, b, size, 0, -gravity, 0, maxAgeMul);
	}

	default void wispFX(double x, double y, double z, float r, float g, float b, float size, float motionx, float motiony, float motionz) {
		wispFX(x, y, z, r, g, b, size, motionx, motiony, motionz, 1F);
	}

	void wispFX(double x, double y, double z, float r, float g, float b, float size, float motionx, float motiony, float motionz, float maxAgeMul);

	default void lightningFX(Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, int colorOuter, int colorInner) {
		lightningFX(vectorStart, vectorEnd, ticksPerMeter, System.nanoTime(), colorOuter, colorInner);
	}

	void lightningFX(Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, long seed, int colorOuter, int colorInner);

}
