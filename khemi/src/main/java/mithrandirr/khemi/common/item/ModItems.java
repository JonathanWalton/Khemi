package mithrandirr.khemi.common.item;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class ModItems {
	
	public static Item pestle = new ItemPestle("pestle");
	public static Item dustIron = new ItemMod("dustIron");
	public static Item dustGold = new ItemMod("dustGold");

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> evt) {
		IForgeRegistry<Item> r = evt.getRegistry();
		
		r.register(pestle);
		r.register(dustIron);
		r.register(dustGold);

		registerOreDictionary();
	}
	
	private static void registerOreDictionary() {
		OreDictionary.registerOre("dustIron", dustIron);
		OreDictionary.registerOre("dustGold", dustGold);
	}

}
