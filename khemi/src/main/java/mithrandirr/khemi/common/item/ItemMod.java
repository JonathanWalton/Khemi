package mithrandirr.khemi.common.item;

import javax.annotation.Nonnull;

import mithrandirr.khemi.client.lib.LibResources;
import mithrandirr.khemi.client.model.IModelRegister;
import mithrandirr.khemi.common.lib.LibMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMod extends Item implements IModelRegister {

	public ItemMod(String name) {
		setCreativeTab(CreativeTabs.MISC);
		setRegistryName(new ResourceLocation(LibMod.MOD_ID, name));
		setUnlocalizedName(name);
	}

	@Nonnull
	@Override
	public String getUnlocalizedNameInefficiently(@Nonnull ItemStack par1ItemStack) {
		return super.getUnlocalizedNameInefficiently(par1ItemStack).replaceAll("item\\.", "item." + LibResources.PREFIX_MOD);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}