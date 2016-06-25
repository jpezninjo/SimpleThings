package joopez1.tutorial.proxy;

import joopez1.tutorial.init.ModBlocks;
import joopez1.tutorial.init.ModItems;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenders(){
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}
	
}
