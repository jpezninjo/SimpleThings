package joopez1.tutorial.ModEvents;

import joopez1.tutorial.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemTossEventHandler {

	@SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
	public void onEvent(ItemTossEvent event) {
		// DEBUG
		int x = MathHelper.floor_double((double)(event.player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		String y = (x == 0 ? "south" : x == 1 ? "west" : x == 2 ? "north" : "east");
		if (event.entityItem.getEntityItem().getUnlocalizedName().equals("tile.door_bell")) {
			System.out.println("Boing");
		}else{
			System.out.println("Player dropped " + event.entityItem.getEntityItem().getUnlocalizedName());
			System.out.println("Player was facing " + y);
		}

	}
}
