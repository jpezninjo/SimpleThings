package joopez1.tutorial.ModItems;

import joopez1.tutorial.TutorialMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemGooeyBlazeRod extends Item{

	public ItemGooeyBlazeRod(String unlocalizedName){
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(TutorialMod.tab);
	}
	
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
    	target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20 * 1));
        return true;
    }
}
