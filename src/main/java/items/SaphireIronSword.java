package items;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import creativeTabs.Tabs;
import lib.Constants;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class SaphireIronSword extends ItemSword {
	public String name = "swordIronSaphire";
	public static final String[] stageStringArray = new String[] {"G0", "1", "2", "3" };
	public IIcon[] iconArray;
	private boolean swordDrawn = true;
	
	public SaphireIronSword(Item.ToolMaterial material) {
		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" +name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Tabs.gemsTab);
	}
	
	
	/**
     * returns the action that specifies what animation to play when the items is being used
     */
	@Override
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
		swordDrawn = !swordDrawn;
        return EnumAction.block;
    }
	
	@Override
	public boolean hitEntity(ItemStack sword, EntityLivingBase target, EntityLivingBase player)
    {
		Random rand = new Random();
		//random gem drop
		if(rand.nextInt(5) > 3) {
			switch (rand.nextInt(5))
	        {
	            case 0:
	                target.dropItem(Items.diamond, 1);
	                break;
	            case 1:
	                target.dropItem(Items.emerald, 1);
	                break;
	            case 2:
	                target.dropItem(ModItems.amethyst, 1);
	                break;
	            case 3:
	            	target.dropItem(ModItems.ruby, 1);
	            	break;
	            case 4:
	            	target.dropItem(ModItems.saphire, 1);
	            	break;
	        }
		}
		
		target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200));
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 2));
		player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 200));
		sword.damageItem(1, player);
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		this.itemIcon = register.registerIcon(Constants.MODID + ":" + name);
		this.iconArray = new IIcon[stageStringArray.length];
		for(int i = 0; i < this.iconArray.length; i++) {
			this.iconArray[i] = register.registerIcon(Constants.MODID + ":" + name + "_" + stageStringArray[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem,int usesRemaining) {
		Random rand = new Random();
		if(usingItem == null && swordDrawn) {
			return iconArray[3];
		} else if(usingItem == null && !swordDrawn) {
			return iconArray[0];
		}
		
		int ticksInUse = stack.getMaxItemUseDuration() - usesRemaining; //not consistent change
																		//multiple switches per use
		int invert = 0;													//switch now used in item use method
		if(!swordDrawn) {
			invert = 3;
		}
		
		if(ticksInUse > 3 + invert) {
			return iconArray[Math.abs(3 - invert)];
		} else if (ticksInUse > 2 + invert) {
			return iconArray[Math.abs(2 - invert)];
		} else if (ticksInUse > 1 + invert) {
			return iconArray[Math.abs(1 - invert)];
		} else {
			return iconArray[Math.abs(0 - invert)];
		}
	}
	
	//play sound effect
//	@Override
//	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer player, World world) {
//		Random rand = new Random();
//		world.playSoundAtEntity(player, "random.anvil_land", 1000F, 0.8F + rand.nextFloat() * 0.2F); //volume & pitch
//		return true;
//	}
}
