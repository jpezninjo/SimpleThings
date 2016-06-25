package joopez1.tutorial.ModItems.foodstuff;

import java.util.Iterator;
import java.util.List;

import joopez1.tutorial.TutorialMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class JeweledApple extends ItemFood {

	public JeweledApple(String unlocalizedName) {
		super(4, 1.0f, false);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(TutorialMod.tab);
		this.setAlwaysEdible();
		this.setMaxStackSize(16);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onFoodEaten(stack, world, player);
		int n = 20 * 12;
		if (!world.isRemote) {
			player.addPotionEffect(new PotionEffect(Potion.jump.id, n, 1));
			player.addPotionEffect(new PotionEffect(Potion.absorption.id, n, 0));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) {
		toolTip.add("Useful for pranks and jumping off cliffs");
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (entity.getName().toLowerCase().contains("spider")){

			if (!entity.isInvisible()) {
				entity.setInvisible(true);
				if (!player.getEntityWorld().isRemote) {
					player.addChatMessage(new ChatComponentText("a myserious voice whispers to you: \"You fool\""));
				}
			} else {
				entity.setInvisible(false);
				if (!player.getEntityWorld().isRemote) {
					player.addChatMessage(new ChatComponentText("a myserious voice whispers to you: \"it is undone\""));
				}
			}
            if (!player.capabilities.isCreativeMode)
            {
                --stack.stackSize;
            }

            if (stack.stackSize <= 0)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
            }
		}else{
			if (!player.getEntityWorld().isRemote) {
				player.addChatMessage(new ChatComponentText(entity.getName()));
			}
		}
		return true;
	}

}