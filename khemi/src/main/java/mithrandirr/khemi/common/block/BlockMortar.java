package mithrandirr.khemi.common.block;

import javax.annotation.Nonnull;

import org.lwjgl.input.Keyboard;

import mithrandirr.khemi.api.mortar.Mortar;
import mithrandirr.khemi.common.block.tile.TileMortar;
import mithrandirr.khemi.common.item.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

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

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	
    		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
    			if(!world.isRemote) {
	        		if(world.getTileEntity(pos) instanceof TileMortar) {
	        			TileMortar mortar = (TileMortar) world.getTileEntity(pos);
	        			
	        			if(player.getHeldItem(hand).getItem() != ModItems.pestle) {
		        			if(mortar.getStack() != null && !mortar.getStack().isEmpty()) {
		        				if(player.getHeldItem(hand).getItem() == mortar.getStack().getItem())
		                			player.setHeldItem(hand, new ItemStack(player.getHeldItem(hand).getItem(), player.getHeldItem(hand).getCount() + 1));
		        				else {
		        					if(player.getHeldItem(hand) == ItemStack.EMPTY)
		        						player.setHeldItem(hand, mortar.getStack());
		        					else
		        						player.dropItem(mortar.getStack(), false);
		        				}
		            			mortar.setStack(ItemStack.EMPTY);
		            			mortar.sync();
		        			}
	        			}
	        		}
    			}
    		} else {
    			if(!world.isRemote) {
	        		if(world.getTileEntity(pos) instanceof TileMortar) {
	        			TileMortar mortar = (TileMortar) world.getTileEntity(pos);
	        			
	        			if(player.getHeldItem(hand).getItem() != ModItems.pestle) {
		        			ItemStack stack = mortar.getStack();
		        			ItemStack tempStack;
		        			
		        			if(!player.getHeldItem(hand).isEmpty()) {
		        				if(stack.isEmpty()) {
		                			mortar.setStack(new ItemStack(player.getHeldItem(hand).getItem(), 1));
		                			if(player.getHeldItem(hand).getCount() == 1)
		                				player.setHeldItem(hand, ItemStack.EMPTY);
		                			else
		                				player.setHeldItem(hand, new ItemStack(player.getHeldItem(hand).getItem(), player.getHeldItem(hand).getCount() - 1));
		                			mortar.sync();
		        				} else {
		        					if(stack.getItem() != player.getHeldItem(hand).getItem()) {
		            					tempStack = stack;
		                    			mortar.setStack(new ItemStack(player.getHeldItem(hand).getItem(), 1));
		        						if(player.getHeldItem(hand).getCount() > 1) {
		                    				player.setHeldItem(hand, new ItemStack(player.getHeldItem(hand).getItem(), player.getHeldItem(hand).getCount() - 1));
		            						//player.dropItem(tempStack, false);
		            						world.spawnEntity(new EntityItem(world, player.posX, player.posY, player.posZ, tempStack));
		        						} else if(player.getHeldItem(hand).getCount() == 1) {
		            						player.setHeldItem(hand, tempStack);
		        						}
		                    			tempStack = ItemStack.EMPTY;
		                    			mortar.sync();
		        					}
		        				}
		        			}
	        			} else if(player.getHeldItem(hand).getItem() == ModItems.pestle) {
	        				if(mortar.getStack() != ItemStack.EMPTY) {
	        					mortar.pestle(mortar.getStack().getItem());
	        					System.out.println(Mortar.returnGrindablesLength());
	        					System.out.println(mortar.getStack());
	        				}
	        			}
	        		}
    			}
    		}
    	
    		return true;
    }

}
