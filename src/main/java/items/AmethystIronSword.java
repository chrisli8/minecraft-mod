package items;

import java.util.Random;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import creativeTabs.Tabs;
import lib.Constants;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class AmethystIronSword extends ItemSword {
	public String name = "swordIronAmethyst";
	
	public AmethystIronSword(Item.ToolMaterial material) {
		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Tabs.gemsTab);
	}
	
	@Override
	public boolean hitEntity(ItemStack sword, EntityLivingBase target, EntityLivingBase player)
    {
		((EntityPlayer) player).getFoodStats().addStats(1, 0.5F);;
		Random rand = new Random();
		for (int i = 0; i < 32; ++i)
        {
            target.worldObj.spawnParticle("portal", target.posX, target.posY + rand.nextDouble() * 2.0D, target.posZ, rand.nextGaussian(), 0.0D, rand.nextGaussian());
        }
		target.addPotionEffect(new PotionEffect(Potion.blindness.id, 200));
		target.addPotionEffect(new PotionEffect(Potion.weakness.id, 200));
		sword.damageItem(1, player);
        return true;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
		p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!p_77659_2_.isRemote)
        {
            p_77659_2_.spawnEntityInWorld(new EntityEnderPearl(p_77659_2_, p_77659_3_));
        }
        p_77659_1_.damageItem(20, p_77659_3_);
        
        p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        return p_77659_1_;
    }
}
