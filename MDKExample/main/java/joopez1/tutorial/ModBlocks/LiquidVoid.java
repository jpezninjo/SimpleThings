package joopez1.tutorial.ModBlocks;

import java.util.Random;

import joopez1.tutorial.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class LiquidVoid extends BlockDirt {

	private boolean isWaiting;
	private boolean isDoingTask;
	private int counter;

	public LiquidVoid(String unlocalizedName) {
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(TutorialMod.tab);
	}
	
    public Block setHardness(float hardness)
    {
        this.blockHardness = 50.0f;

        if (this.blockResistance < hardness * 5.0F)
        {
            this.blockResistance = hardness * 5.0F;
        }

        return this;
    }

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
		if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).getBlock().getMaterial()
				.isLiquid()) {
			worldIn.setBlockToAir(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()));
		}
		if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).getBlock().getMaterial()
				.isLiquid()) {
			worldIn.setBlockToAir(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()));
		}
		if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock().getMaterial()
				.isLiquid()) {
			worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
		}
		if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock().getMaterial()
				.isLiquid()) {
			worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()));
		}
		if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).getBlock().getMaterial()
				.isLiquid()) {
			worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1));
		}
		if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).getBlock().getMaterial()
				.isLiquid()) {
			worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1));
		}
	}
	
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		if (worldIn.isRemote) {
			playerIn.addChatMessage(new ChatComponentText("hi"));
			if(this.isWaiting == true){
				return;
			}
			this.isWaiting = true;
			while(isWaiting != false){
			}
			
		}
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (isWaiting == true) {
			if (counter++ == 20) {
				counter = 0;
				this.isWaiting = false;
			}
		}
	}
	
//	public void readFromNBT(NBTTagCompound compound)
//	{
//		super.readFromNBT(compound);
//		
//		teleports = new ArrayList<CoordEntry>();
//		
//		NBTTagList entryList = (NBTTagList) compound.getTag("teleports");
//		for(int i = 0; i < entryList.tagCount(); i++)
//		{
//			NBTTagCompound entryCompound = entryList.getCompoundTagAt(i);
//			CoordEntry entry = CoordEntry.readEntryFromNBT(entryCompound);
//			teleports.add(entry);
//		}
//	}
//	
//	public void writeToNBT(NBTTagCompound compound)
//	{
//		super.writeToNBT(compound);
//		
//		NBTTagList entryList = new NBTTagList();
//		for(CoordEntry entry : teleports)
//		{
//			NBTTagCompound entryCompound = new NBTTagCompound();
//			entry.writeEntryToNBT(entryCompound);
//			entryList.appendTag(entryCompound);
//		}
//		
//		compound.setTag("teleports", entryList);
//	}
}
