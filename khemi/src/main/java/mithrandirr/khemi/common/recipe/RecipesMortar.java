package mithrandirr.khemi.common.recipe;

import mithrandirr.khemi.api.mortar.Mortar;
import mithrandirr.khemi.common.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesMortar {
	
	public static void init() {
		
		Mortar.addGrindPair(Item.getItemFromBlock(Blocks.IRON_ORE), ModItems.dustIron, 2);
		Mortar.addGrindPair(Item.getItemFromBlock(Blocks.GOLD_ORE), ModItems.dustGold, 2);
		
	}
	
	public static boolean hasResult(Item itemIn) {
		return Mortar.isIncluded(itemIn);
	}
	
	public static ItemStack getResult(Item itemIn) {
		return new ItemStack(Mortar.result(itemIn), Mortar.resultCount(itemIn));
	}
	
}