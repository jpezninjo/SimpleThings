package joopez1.tutorial.ModEvents;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SampleSheepDropEvent {

	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(LivingDropsEvent event)
	{
	    if (event.entity instanceof EntitySheep)
	    {
	        // DEBUG
	        System.out.println("EntitySheep drops event");
	        event.drops.clear();
	        ItemStack itemStackToDrop = new ItemStack(Items.apple, 5);
	        event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, 
	              event.entity.posY, event.entity.posZ, itemStackToDrop));
	    }
	} 
	
}
