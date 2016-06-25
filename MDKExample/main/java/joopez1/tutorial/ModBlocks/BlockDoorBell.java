package joopez1.tutorial.ModBlocks;

import java.util.Random;

import joopez1.tutorial.TutorialMod;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDoorBell extends BlockButton{

	public BlockDoorBell(String unlocalizedName) {
		super(true);
		this.setCreativeTab(TutorialMod.tab);
		this.setUnlocalizedName(unlocalizedName);
	}
	
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (((Boolean)state.getValue(POWERED)).booleanValue())
        {
            return true;
        }
        else
        {
            worldIn.setBlockState(pos, state.withProperty(POWERED, Boolean.valueOf(true)), 3);
            worldIn.markBlockRangeForRenderUpdate(pos, pos);
            worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "tm:doorbell", 0.3F, 0.6F);
            this.notifyNeighbors(worldIn, pos, (EnumFacing)state.getValue(FACING));
            worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
            return true;
        }
    }
	
	private void notifyNeighbors(World worldIn, BlockPos pos, EnumFacing facing)
    {
        worldIn.notifyNeighborsOfStateChange(pos, this);
        worldIn.notifyNeighborsOfStateChange(pos.offset(facing.getOpposite()), this);
    }
	
	 @SideOnly(Side.CLIENT)
	    @SuppressWarnings("incomplete-switch")
	    public void dontrandomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	    {
	        {
	            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
	            double d0 = (double)pos.getX() + 0.5D;
	            double d1 = (double)pos.getY() + rand.nextDouble() * 6.0D / 16.0D;
	            double d2 = (double)pos.getZ() + 0.5D;
	            double d3 = 0.52D;
	            double d4 = rand.nextDouble() * 0.6D - 0.3D;

	            switch (enumfacing)
	            {
	                case WEST:
	                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
	                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 - d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
	                    break;
	                case EAST:
	                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
	                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
	                    break;
	                case NORTH:
	                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 - d3, 0.0D, 0.0D, 0.0D, new int[0]);
	                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 - d3, 0.0D, 0.0D, 0.0D, new int[0]);
	                    break;
	                case SOUTH:
	                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 + d3, 0.0D, 0.0D, 0.0D, new int[0]);
	                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 + d3, 0.0D, 0.0D, 0.0D, new int[0]);
	            }
	        }
	    }
	
	 private void generatePortal(World worldIn, BlockPos pos)
	    {
	        int i = 4;
	        double d0 = 12.25D;
	        double d1 = 6.25D;

	        for (int j = -1; j <= 32; ++j)
	        {
	            for (int k = -4; k <= 4; ++k)
	            {
	                for (int l = -4; l <= 4; ++l)
	                {
	                    double d2 = (double)(k * k + l * l);

	                    if (d2 <= 12.25D)
	                    {
	                        BlockPos blockpos = pos.add(k, j, l);

	                        if (j < 0)
	                        {
	                            if (d2 <= 6.25D)
	                            {
	                                worldIn.setBlockState(blockpos, Blocks.bedrock.getDefaultState());
	                            }
	                        }
	                        else if (j > 0)
	                        {
	                        	worldIn.setBlockState(blockpos, Blocks.air.getDefaultState());
	                        }
	                        else if (d2 > 6.25D)
	                        {
	                        	worldIn.setBlockState(blockpos, Blocks.bedrock.getDefaultState());
	                        }
	                        else
	                        {
	                        	worldIn.setBlockState(blockpos, Blocks.end_portal.getDefaultState());
	                        }
	                    }
	                }
	            }
	        }

	        worldIn.setBlockState(pos, Blocks.bedrock.getDefaultState());
	        worldIn.setBlockState(pos.up(), Blocks.bedrock.getDefaultState());
	        BlockPos blockpos1 = pos.up(2);
	        worldIn.setBlockState(blockpos1, Blocks.bedrock.getDefaultState());
	        worldIn.setBlockState(blockpos1.west(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.EAST));
	        worldIn.setBlockState(blockpos1.east(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.WEST));
	        worldIn.setBlockState(blockpos1.north(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.SOUTH));
	        worldIn.setBlockState(blockpos1.south(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.NORTH));
	        worldIn.setBlockState(pos.up(3), Blocks.bedrock.getDefaultState());
	        worldIn.setBlockState(pos.up(4), Blocks.dragon_egg.getDefaultState());
	    }

}
