package joopez1.tutorial.ModEvents;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class JumpEventHandler {

	@SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
	public void onEvent(LivingJumpEvent event) {
		// DEBUG
		if (event.entity instanceof EntityPlayer) {
			if (event.entity.worldObj.isRemote)
				System.out.println("Boing");
		}

	}
}
