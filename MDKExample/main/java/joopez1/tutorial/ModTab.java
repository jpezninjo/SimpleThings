package joopez1.tutorial;

import joopez1.tutorial.init.ModBlocks;
import joopez1.tutorial.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModTab extends CreativeTabs{

	public ModTab(String label) {
		super(label);
		//this.setBackgroundImageName("modTab.png");
	}

	@Override
	public Item getTabIconItem() {
		return ModItems.dark_ingot;
	}

}
