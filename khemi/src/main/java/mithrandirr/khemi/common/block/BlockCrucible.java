package mithrandirr.khemi.common.block;

import javax.annotation.Nonnull;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCrucible extends BlockModeled {
	
    private static final AxisAlignedBB AABB = new AxisAlignedBB(0.1875, 0, 0.1875, 0.8125, 0.3125, 0.8125);

	public BlockCrucible() {
		super(Material.ROCK, "crucible");
	}

    @Nonnull
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return AABB;
    }
    
}
