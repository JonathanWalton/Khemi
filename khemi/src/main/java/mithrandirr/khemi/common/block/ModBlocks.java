package mithrandirr.khemi.common.block;

import mithrandirr.khemi.common.block.tile.ModTiles;
import mithrandirr.khemi.common.item.block.ItemBlockMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class ModBlocks {
	
	public static Block aludel = new BlockAludel();
	public static Block athanor = new BlockAthanor();
	public static Block crucible = new BlockCrucible();
	public static Block enchanter = new BlockEnchanter();
	public static Block mortar = new BlockMortar();
	public static Block phiale = new BlockPhiale();
	public static Block retort = new BlockRetort();
	public static Block showGlobe = new BlockShowGlobe();

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> evt) {
		registerBlock(aludel, evt);
		registerBlock(athanor, evt);
		registerBlock(crucible, evt);
		registerBlock(enchanter, evt);
		registerBlock(mortar, evt);
		registerBlock(phiale, evt);
		registerBlock(retort, evt);
		registerBlock(showGlobe, evt);
		
		ModTiles.init();
	}

	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> evt) {
		registerBlockItem(aludel, evt);
		registerBlockItem(athanor, evt);
		registerBlockItem(crucible, evt);
		registerBlockItem(enchanter, evt);
		registerBlockItem(mortar, evt);
		registerBlockItem(phiale, evt);
		registerBlockItem(retort, evt);
		registerBlockItem(showGlobe, evt);
	}

    private static void registerBlock(Block block, RegistryEvent.Register<Block> evt) {
        IForgeRegistry<Block> r = evt.getRegistry();

        r.register(block);
    }

    private static void registerBlockItem(Block block, RegistryEvent.Register<Item> evt) {
        IForgeRegistry<Item> r = evt.getRegistry();

        r.register(new ItemBlockMod(block).setRegistryName(block.getRegistryName()));
    }
	
}