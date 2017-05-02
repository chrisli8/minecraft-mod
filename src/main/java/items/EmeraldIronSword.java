package items;

import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import creativeTabs.Tabs;
import lib.Constants;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;

public class EmeraldIronSword extends ItemSword {
	public String name = "swordIronEmerald";
	
	public EmeraldIronSword(Item.ToolMaterial material) {
		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Tabs.gemsTab);
	}
	
	@Override
	public boolean hitEntity(ItemStack sword, EntityLivingBase target, EntityLivingBase player)
    {
		//search area around target (4,2,4) blocks and get's entites
    	AxisAlignedBB axisalignedbb = target.boundingBox.expand(4.0D, 2.0D, 4.0D);
        List list1 = target.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
    	if(list1 != null && !list1.isEmpty()) {
    		Iterator iterator = list1.iterator();
    		while (iterator.hasNext())
            {
                EntityLivingBase entitylivingbase = (EntityLivingBase)iterator.next();
                double d0 = target.getDistanceSqToEntity(entitylivingbase);

                if (d0 < 16.0D && (entitylivingbase != player))
                {
                    entitylivingbase.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 2));
                    entitylivingbase.addPotionEffect(new PotionEffect(Potion.wither.id, 200));
                    entitylivingbase.addPotionEffect(new PotionEffect(Potion.hunger.id, 200, 2));
                }
            }
    	}
    	
		sword.damageItem(1, player);
        return true;
    }
}
