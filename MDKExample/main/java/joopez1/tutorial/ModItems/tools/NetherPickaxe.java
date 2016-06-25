package joopez1.tutorial.ModItems.tools;

import java.util.Set;

import com.google.common.collect.Sets;

import joopez1.tutorial.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class NetherPickaxe extends ItemPickaxe {

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] { Blocks.nether_brick,
			Blocks.nether_brick_fence, Blocks.nether_brick_stairs, Blocks.netherrack });

	public NetherPickaxe(String unlocalizedName) {
		super(ToolMaterial.STONE);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(TutorialMod.tab);
	}

	public float getStrVsBlock(ItemStack stack, Block block) {
		if(block.getUnlocalizedName().contains("nether")){
			return 100.0F;
		}else{
			System.out.println(block.getUnlocalizedName());
			return 0.0F;
		}
	}
}