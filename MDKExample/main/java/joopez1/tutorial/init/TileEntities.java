package joopez1.tutorial.init;

import joopez1.tutorial.ModEvents.SampleSheepDropEvent;
import joopez1.tutorial.TileEntities.TileEntityOven;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntities {

	public static void register(){
		GameRegistry.registerTileEntity(TileEntityOven.class, "tmOvenTileEntity");
	}
}
