package joopez1.tutorial.ModEvents;

import joopez1.tutorial.TutorialMod;
import joopez1.tutorial.init.ModItems;
import net.minecraft.block.BlockLeaves;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.util.Random;

public class LeafDropSticksEventHandler {

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEvent(BreakEvent event) {
		Random random = null;
		if (event.state.getBlock() instanceof BlockLeaves) {
			if (!event.world.isRemote) {
				random = new Random();
				if (event.getPlayer().getHeldItem().getItem() == ModItems.hoe_nether) {
					if (random.nextInt(12) == 9) {
						event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX() + 0.5,
								event.pos.getY() + 0.5, event.pos.getZ() + 0.5, new ItemStack(Items.stick, 1)));
					}
				}
				if (random.nextInt(72) == 69) {
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX() + 0.5,
							event.pos.getY() + 0.5, event.pos.getZ() + 0.5, new ItemStack(ModItems.apple_jeweled, 1)));
				}
			}
		}

	}
}
