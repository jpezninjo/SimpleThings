package joopez1.tutorial;


import joopez1.tutorial.ModEvents.ItemTossEventHandler;
import joopez1.tutorial.ModEvents.JumpEventHandler;
import joopez1.tutorial.ModEvents.LeafDropSticksEventHandler;
import joopez1.tutorial.ModEvents.SampleSheepDropEvent;
import joopez1.tutorial.init.ModBlocks;
import joopez1.tutorial.init.ModItems;
import joopez1.tutorial.init.ModRecipes;
import joopez1.tutorial.init.TileEntities;
import joopez1.tutorial.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class TutorialMod {

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final ModTab tab = new ModTab("modTab");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ModItems.init();
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
		
		TileEntities.register();
		
		ModRecipes.register();
	
	
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		proxy.registerRenders();
	
//	    MinecraftForge.EVENT_BUS.register(new JumpEventHandler());
	    MinecraftForge.EVENT_BUS.register(new ItemTossEventHandler());
//	    MinecraftForge.EVENT_BUS.register(new SampleSheepDropEvent());
	    MinecraftForge.EVENT_BUS.register(new LeafDropSticksEventHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
