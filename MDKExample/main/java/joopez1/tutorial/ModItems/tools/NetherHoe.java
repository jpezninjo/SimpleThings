package joopez1.tutorial.ModItems.tools;

import joopez1.tutorial.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

public class NetherHoe extends ItemHoe {

	public NetherHoe(String unlocalizedName) {
		super(ToolMaterial.STONE);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(TutorialMod.tab);
	}

	@SuppressWarnings("incomplete-switch")
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		if (!playerIn.canPlayerEdit(pos.offset(side), side, stack)) {
			return false;
		} else {
			int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos);
			if (hook != 0)
				return hook > 0;

			IBlockState iblockstate = worldIn.getBlockState(pos);
			Block block = iblockstate.getBlock();

			if (playerIn.dimension == -1) {
				if (side != EnumFacing.DOWN && worldIn.isAirBlock(pos.up())) {
					if (block == Blocks.sand || block == Blocks.soul_sand) {
						return this.useHoe(stack, playerIn, worldIn, pos, Blocks.soul_sand.getDefaultState());
					}
				}
			}
		}
		return super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
	}

	@Override
	protected boolean useHoe(ItemStack stack, EntityPlayer player, World worldIn, BlockPos target,
			IBlockState newState) {
		worldIn.playSoundEffect((double) ((float) target.getX() + 0.5F), (double) ((float) target.getY() + 0.5F),
				(double) ((float) target.getZ() + 0.5F), newState.getBlock().stepSound.getStepSound(),
				(newState.getBlock().stepSound.getVolume() + 1.0F) / 2.0F,
				newState.getBlock().stepSound.getFrequency() * 0.8F);

		if (worldIn.isRemote) {
			return true;
		} else {
			worldIn.setBlockState(target, newState);
			stack.damageItem(0, player);
			return true;
		}
	}

}