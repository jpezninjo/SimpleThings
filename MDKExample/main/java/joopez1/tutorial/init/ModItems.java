package joopez1.tutorial.init;

import joopez1.tutorial.Reference;
import joopez1.tutorial.TutorialMod;
import joopez1.tutorial.ModItems.DarkIngot;
import joopez1.tutorial.ModItems.FishingTrophy;
import joopez1.tutorial.ModItems.ItemGooeyBlazeRod;
import joopez1.tutorial.ModItems.foodstuff.ItemMelonHalf;
import joopez1.tutorial.ModItems.foodstuff.JeweledApple;
import joopez1.tutorial.ModItems.foodstuff.ShinyFish;
import joopez1.tutorial.ModItems.tools.NetherHoe;
import joopez1.tutorial.ModItems.tools.NetherPickaxe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item dark_ingot;
	public static Item jump_rod;
	public static ItemMelonHalf melon_half;
	public static ShinyFish fish_shiny;
	public static JeweledApple apple_jeweled;
	public static FishingTrophy fishing_trophy;
	
	public static NetherPickaxe pickaxe_nether;
	public static NetherHoe hoe_nether;
	public static ItemGooeyBlazeRod sticky_rod;
	
	
	public static void init(){
		dark_ingot = new Item().setUnlocalizedName("dark_ingot").setCreativeTab(TutorialMod.tab);
		jump_rod = new DarkIngot().setUnlocalizedName("jump_rod");
		melon_half = new ItemMelonHalf("melon_chunk");
		fish_shiny = new ShinyFish("fish_shiny");
		apple_jeweled = new JeweledApple("apple_jeweled");
		fishing_trophy = new FishingTrophy("fishing_trophy");
		pickaxe_nether = new NetherPickaxe("pickaxe_nether");
		hoe_nether = new NetherHoe("hoe_nether");
		sticky_rod = new ItemGooeyBlazeRod("blaze_rod_sticky");

	}
	
	public static void register(){
		registerHelped(dark_ingot);
		registerHelped(jump_rod);
		registerHelped(melon_half);	
		registerHelped(fish_shiny);
		registerHelped(apple_jeweled);
		registerHelped(fishing_trophy);
		registerHelped(pickaxe_nether);
		registerHelped(hoe_nether);
		registerHelped(sticky_rod);
	}
	
	public static void registerHelped(Item item){
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders(){
		registerRender(dark_ingot);
		registerRender(jump_rod);
		registerRender(melon_half);
		registerRender(fish_shiny);
		registerRender(apple_jeweled);
		registerRender(pickaxe_nether);
		registerRender(hoe_nether);
		registerRender(sticky_rod);
	}
	
	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
}
