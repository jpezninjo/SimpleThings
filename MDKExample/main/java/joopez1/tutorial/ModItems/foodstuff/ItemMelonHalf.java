package joopez1.tutorial.ModItems.foodstuff;

import java.util.List;

import joopez1.tutorial.TutorialMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.util.Random;

public class ItemMelonHalf extends ItemFood {

	public ItemMelonHalf(String unlocalizedName) {
		super(7, 0.6f, false);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(TutorialMod.tab);
		this.setMaxStackSize(16);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {

		int effectTime = 10;
		Random random = null;

		super.onFoodEaten(stack, world, player);
		if (!world.isRemote) {
			random = new Random();
			if(random.nextInt(3) == 1){
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, (int) 20 * effectTime, 1));
			}
			if(random.nextInt(3) == 1){
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, (int) 20 * effectTime, 4));
			}
			if(random.nextInt(4) == 1){
				player.addPotionEffect(new PotionEffect(Potion.absorption.id, (int) 20 * effectTime, 5));
			}
			if(random.nextInt(4) == 1){
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, (int) 20 * 2, 1));
			}
		}
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return (int) (32 * 1.75);
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) {
		toolTip.add("Side effects may vary");

	}

}