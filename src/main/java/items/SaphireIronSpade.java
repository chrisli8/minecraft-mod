package items;

import java.util.Random;

import lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import creativeTabs.Tabs;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SaphireIronSpade extends ItemSpade{
	public String name = "spadeIronSaphire";
	
	public SaphireIronSpade(Item.ToolMaterial p_i45353_1_) {
		super(p_i45353_1_);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Tabs.gemsTab);
	}
	
	public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_)
    {
		super.onBlockDestroyed(p_150894_1_, p_150894_2_, p_150894_3_, p_150894_4_, p_150894_5_, p_150894_6_, p_150894_7_);
		Random rand = new Random();
		//random gem drop
		if(rand.nextInt(5) > 3) {
			if(!p_150894_2_.isRemote) {
				switch (rand.nextInt(5))
		        {
		            case 0:
		            	p_150894_7_.dropItem(Items.diamond, 1);
		                break;
		            case 1:
		            	p_150894_7_.dropItem(Items.emerald, 1);
		                break;
		            case 2:
		            	p_150894_7_.dropItem(ModItems.amethyst, 1);
		                break;
		            case 3:
		            	p_150894_7_.dropItem(ModItems.ruby, 1);
		            	break;
		            case 4:
		            	p_150894_7_.dropItem(ModItems.saphire, 1);
		            	break;
		        }
			}
		}
		return true;
    }
}
