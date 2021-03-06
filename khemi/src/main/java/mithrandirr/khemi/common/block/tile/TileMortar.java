package mithrandirr.khemi.common.block.tile;

import mithrandirr.khemi.common.recipe.RecipesMortar;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileMortar extends TileMod {

	private ItemStack stack = ItemStack.EMPTY;
	private static final String TAG_ITEM = "item";
	
	public ItemStack getStack() {
		sync();
		return stack;
	}
	
	public void setStack(ItemStack stack) {
		this.stack = stack;
		sync();
	}

	public void writePacketNBT(NBTTagCompound cmp) {
		NBTTagCompound itemCmp = new NBTTagCompound();
		if(!stack.isEmpty())
			itemCmp = stack.writeToNBT(itemCmp);
		cmp.setTag(TAG_ITEM, itemCmp);
	}

	public void readPacketNBT(NBTTagCompound cmp) {
		NBTTagCompound itemCmp = cmp.getCompoundTag(TAG_ITEM);
		stack = new ItemStack(itemCmp);
	}

	public void pestle(Item itemIn) {
		if(RecipesMortar.hasResult(itemIn)) {
			setStack(RecipesMortar.getResult(itemIn));
		}
	}
	
}
