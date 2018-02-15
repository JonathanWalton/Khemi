package mithrandirr.khemi.common.block;

import mithrandirr.khemi.client.core.handler.ModelHandler;
import mithrandirr.khemi.client.model.IModelRegister;
import mithrandirr.khemi.common.lib.LibMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMod extends Block implements IModelRegister {

	public BlockMod(Material par2Material, String name) {
		super(par2Material);
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(LibMod.MOD_ID, name));
		setCreativeTab(CreativeTabs.MISC);
	}

	protected boolean registerInCreative() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() {
		if(Item.getItemFromBlock(this) != Items.AIR)
			ModelHandler.registerBlockToState(this, 0, getDefaultState());
	}

	@Override
	public boolean eventReceived(IBlockState state, World world, BlockPos pos, int id, int param) {
		super.eventReceived(state, world, pos, id, param);
		TileEntity tileentity = world.getTileEntity(pos);
		return tileentity != null ? tileentity.receiveClientEvent(id, param) : false;
	}

}