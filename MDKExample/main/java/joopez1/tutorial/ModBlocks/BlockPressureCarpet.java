package joopez1.tutorial.ModBlocks;

import joopez1.tutorial.TutorialMod;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;

public class BlockPressureCarpet extends BlockPressurePlate{

	public BlockPressureCarpet(String unlocalizedName) {
		super(Material.wood, Sensitivity.EVERYTHING);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(TutorialMod.tab);
	}

}
