package joopez1.tutorial.ModItems.foodstuff;

import joopez1.tutorial.TutorialMod;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ShinyFish extends ItemSword {

	private boolean bool;

	public ShinyFish(String unlocalizedName) {
		super(ToolMaterial.WOOD);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(TutorialMod.tab);
		this.setMaxStackSize(1);
		bool = true;
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}

	@Override
	public String getHighlightTip(ItemStack item, String displayName) {
		return displayName;
	}

	public float getDamageVsEntity() {
		return 10.0f;
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (this.bool == true) {
			stack.addEnchantment(Enchantment.knockback, 2);
			bool = false;
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
}
