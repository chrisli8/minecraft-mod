package items;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import creativeTabs.Tabs;
import lib.Constants;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class DiamondIronSword extends ItemSword {
	public String name = "swordIronDiamond";
	
	public DiamondIronSword(Item.ToolMaterial material) {
		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Tabs.gemsTab);
	}
	
	@Override
	public boolean hitEntity(ItemStack sword, EntityLivingBase target, EntityLivingBase player) {
		
		Random rand = new Random();
    	EntityLightningBolt bolt = new EntityLightningBolt(target.worldObj, 5.0F, 5.0F, 5.0F); //F params angle?
    	target.worldObj.playSoundEffect(target.posX, target.posY, target.posZ, "ambient.weather.thunder", 10000.0F, 0.8F + rand.nextFloat() * 0.2F);
    	target.worldObj.playSoundEffect(target.posX, target.posY, target.posZ, "random.explode", 2.0F, 0.5F + rand.nextFloat() * 0.2F);
    	target.worldObj.createExplosion(target, target.posX, target.posY, target.posZ, (float)1.5, true);
    	target.onStruckByLightning(bolt);
		
		sword.damageItem(1, player);
		return true;
	}
}
