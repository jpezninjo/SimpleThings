package joopez1.tutorial.ModItems;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DarkIngot extends Item {

    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ){
    	playerIn.experienceLevel += 1;
    	return true;
    }
    
//    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
//    	playerIn.experienceLevel += 1;
//    	if(playerIn.isAirBorne){
////    		playerIn.addVelocity(0, 1, 0);
//    	}
//    	itemStackIn.stackSize--;
//    	
//    	
//    	
//        MovingObjectPosition lastPosition = playerIn.rayTrace(100, 1.0F);
//        double x = lastPosition.hitVec.xCoord;
//        double y= lastPosition.hitVec.yCoord;
//        double z = lastPosition.hitVec.zCoord;
////        playerIn.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "Position [ X: " + lastPosition.hitVec.xCoord + " Y: " + lastPosition.hitVec.yCoord + 1 + " Z: " + lastPosition.hitVec.zCoord + " ]"));
//        for(int i = 0; i < 100; i += 2){
//        	Vec3 newVec = new Vec3(x + i, y + 1, z);
//        	worldIn.setBlockState(new BlockPos(newVec), Blocks.tnt.getDefaultState());
//        	Vec3 newVec2 = new Vec3(x, y, z);
//        	worldIn.setBlockState(new BlockPos(newVec2), Blocks.redstone_block.getDefaultState());
//        }
//    	return itemStackIn;
//    	
//    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) {
		toolTip.add("(WIP <Tag>NoUse</Tag>");

	}
   
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return stack.isItemEnchanted();
    }
    
    @Override
    public int getEntityLifespan(ItemStack itemStack, World world)
    {
        return 6000 * 2;
    }
    
}
