package mithrandirr.khemi.common.block.tile;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileMortar extends TileEntity {

	private ItemStack stack;
	
	public ItemStack getStack() {
		return stack;
	}
	
	public void setStack(ItemStack stack) {
		this.stack = stack;
		System.out.println(this.stack);
	}

}
