package mithrandirr.khemi.common.block;

import javax.annotation.Nonnull;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockShowGlobe extends BlockModeled {
	
    private static final AxisAlignedBB AABB = new AxisAlignedBB(.25, .125, .25, 0.75, 1, 0.75);

	public BlockShowGlobe() {
		super(Material.GLASS, "showGlobe");
		setLightLevel(15F);
	}

    @Nonnull
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return AABB;
    }

}
