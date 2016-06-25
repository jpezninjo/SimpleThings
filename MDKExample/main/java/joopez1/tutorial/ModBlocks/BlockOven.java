package joopez1.tutorial.ModBlocks;

import joopez1.tutorial.Reference;
import joopez1.tutorial.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;

public class BlockOven extends BlockFurnace{

	public BlockOven(boolean materialIn) {
		super(materialIn);
		this.setUnlocalizedName("oven_block");
	    this.setCreativeTab(TutorialMod.tab);
	    this.setHardness(2.0F);
	    this.setResistance(6.0F);
	    this.setStepSound(soundTypeGravel);
	    // TODO Auto-generated constructor stub
	}

}
