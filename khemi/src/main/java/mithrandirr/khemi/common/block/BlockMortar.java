package mithrandirr.khemi.common.block;

import javax.annotation.Nonnull;

import org.lwjgl.input.Keyboard;

import mithrandirr.khemi.common.block.tile.TileMortar;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMortar extends BlockModeled {

    private static final AxisAlignedBB AABB = new AxisAlignedBB(0.3125, 0, 0.3125, 0.6875, 0.1875, 0.6875);
    
	public BlockMortar() {
		super(Material.ROCK, "mortar");
	}

    @Nonnull
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return AABB;
    }

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Nonnull
	@Override
	public TileEntity createTileEntity(@Nonnull World world, @Nonnull IBlockState state) {
		return new TileMortar();
	}

	@SideOnly(Side.SERVER)
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	
    		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
        		if(world.getTileEntity(pos) instanceof TileMortar) {
        			TileMortar mortar = (TileMortar) world.getTileEntity(pos);
        			
        			if(mortar.getStack() != null && !mortar.getStack().isEmpty()) {
            			player.setHeldItem(hand, mortar.getStack());
            			mortar.setStack(null);
        			}
        		}
    		} else {
        		if(world.getTileEntity(pos) instanceof TileMortar) {
        			TileMortar mortar = (TileMortar) world.getTileEntity(pos);
        			
        			if(!player.getHeldItem(hand).isEmpty()) {
            			mortar.setStack(player.getHeldItem(hand));
            			player.setHeldItem(hand, new ItemStack(Blocks.AIR));
        			}
        		}
    		}
    		if(world.getTileEntity(pos) instanceof TileMortar) {
    			TileMortar mortar = (TileMortar) world.getTileEntity(pos);
    			
    			if(mortar.getStack() != null && !mortar.getStack().isEmpty()) {
    				System.out.println(mortar.getStack());
    			}
    		}
    	
    		return true;
    }

}
