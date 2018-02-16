package mithrandirr.khemi.api.mortar;

import net.minecraft.item.Item;

public class GrindablePair {
	
	Item itemIn;
	Item itemOut;
	
	public GrindablePair(Item itemIn, Item itemOut) {
		this.itemIn = itemIn;
		this.itemOut = itemOut;
	}
	
	public Item getItemStackIn() {
		return itemIn;
	}
	
	public Item getItemStackOut() {
		return itemOut;
	}

}
