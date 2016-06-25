package joopez1.tutorial.init;

import joopez1.tutorial.Reference;
import joopez1.tutorial.TutorialMod;
import joopez1.tutorial.ModBlocks.BlockDoorBell;
import joopez1.tutorial.ModBlocks.BlockOven;
import joopez1.tutorial.ModBlocks.BlockPressureCarpet;
import joopez1.tutorial.ModBlocks.LiquidVoid;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static BlockOven oven_block;
	public static BlockDoorBell door_bell;
	public static BlockPressureCarpet pressure_carpet;
	public static LiquidVoid voidblock;
	
	public static void init(){
		oven_block = new BlockOven(true);
		door_bell = new BlockDoorBell("door_bell");
		pressure_carpet = new BlockPressureCarpet("pressure_carpet");
		voidblock = new LiquidVoid("void_block");
	}
	
	public static void register(){
		registerHelper(oven_block);
		registerHelper(door_bell);
		registerHelper(pressure_carpet);
		registerHelper(voidblock);
	}
	
	public static void registerHelper(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders(){
		registerRender(oven_block);
		registerRender(door_bell);
		registerRender(pressure_carpet);
		registerRender(voidblock);
	}
	
	public static void registerRender(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

}
