package joopez1.tutorial.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void register(){
		GameRegistry.addRecipe(new ItemStack(Items.diamond), new Object[] {"# #", "###", "###", '#', ModItems.dark_ingot});
		GameRegistry.addRecipe(new ItemStack(ModItems.fish_shiny), new Object[] {"###", "#I#", "###", '#', Items.gold_nugget, 'I', Items.fish});
		GameRegistry.addRecipe(new ItemStack(ModItems.fishing_trophy), new Object[] {"III", " # ", "###", '#', Items.gold_ingot, 'I', ModItems.fish_shiny});

		GameRegistry.addRecipe(new ItemStack(ModItems.hoe_nether), new Object[] {
				"II ", " # ", " # ", '#', ModItems.sticky_rod, 'I', Items.netherbrick});
		GameRegistry.addRecipe(new ItemStack(ModItems.hoe_nether), new Object[] {
				" II", " # ", " # ", '#', ModItems.sticky_rod, 'I', Items.netherbrick});
		GameRegistry.addRecipe(new ItemStack(ModItems.pickaxe_nether), new Object[] {
				"III", " # ", " # ", '#', ModItems.sticky_rod, 'I', Items.netherbrick});
		
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.melon_half, 2), new Object[] {
				new ItemStack(Blocks.melon_block, 1)});
		GameRegistry.addRecipe(new ItemStack(ModItems.sticky_rod, 1), new Object[] {
				" #", "I ", '#', Items.blaze_rod, 'I', Items.slime_ball
		});
		
	}
	
}
