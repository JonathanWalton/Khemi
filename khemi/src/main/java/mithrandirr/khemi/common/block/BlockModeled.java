package mithrandirr.khemi.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockModeled extends BlockMod {

	public BlockModeled(Material par2Material, String name) {
		super(par2Material, name);
	}
	
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

}
