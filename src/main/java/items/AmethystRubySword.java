package items;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import creativeTabs.Tabs;
import lib.Constants;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class AmethystRubySword extends ItemSword {
	private boolean itemCharge = false;
	private boolean crushCharge = false;
	public String name = "swordAmethystRuby";
	public static final String[] stageStringArray = new String[] {"0", "1", "2", "3" };
	@SideOnly(Side.CLIENT)
	public IIcon[] iconArray;

	public AmethystRubySword(Item.ToolMaterial material) {
		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Tabs.gemsTab);
	}
	
	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
	@Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World world, EntityPlayer player)
    {
		Random rand = new Random();
		double x = player.getLookVec().xCoord;
		double z = player.getLookVec().zCoord;
		//System.out.println(x + " " + z);
		//double x = player.
		player.addVelocity(x * 2.0, 0.75D, z * 2.0);
		crushCharge = true;
//		if(player.onGround && crushCharge) {
//			world.playSoundEffect(player.posX, player.posY, player.posZ, "random.explode", 2.0F, 0.5F + rand.nextFloat() * 0.2F);
//			world.createExplosion(player, player.posX, player.posY, player.posZ, (float)1.5, true);
//		}
		
        player.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        return p_77659_1_;
    }
	
	/**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
	@Override
    public void onPlayerStoppedUsing(ItemStack item, World world, EntityPlayer player, int p_77615_4_)
    {
		if(crushCharge && itemCharge && !world.isRemote) {
			world.createExplosion(player, player.posX, player.posY + 2, player.posZ, (float)3.0, true);
			crushCharge = false;
			itemCharge = false;
		}
    }
	
	@Override
	public void onUpdate(ItemStack p_77663_1_, World world, Entity player, int p_77663_4_, boolean p_77663_5_) {
//		if(player.onGround && crushCharge && player.isSneaking()) {
//			crushCharge = false;
//			Random rand = new Random();
//			world.playSoundEffect(player.posX + 1, player.posY + 1, player.posZ + 1, "random.explode", 2.0F, 0.5F + rand.nextFloat() * 0.2F);
//			world.playSoundAtEntity(player, "random.explode", 2.0F, 0.5F + rand.nextFloat() * 0.2F);
//			world.createExplosion(player, player.posX, player.posY - 1, player.posZ, (float)3.0, true);
//		} else if(player.onGround) {
//			crushCharge = false;
//		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister p_94581_1_)
    {
        this.itemIcon = p_94581_1_.registerIcon(Constants.MODID + ":" + name);
        this.iconArray = new IIcon[stageStringArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = p_94581_1_.registerIcon(Constants.MODID + ":" + name + "_" + stageStringArray[i]);
        }
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        if (usingItem == null) { 
        	return itemIcon; 
    	}
        int ticksInUse = stack.getMaxItemUseDuration() - useRemaining;
        //0, 14, 18
        if (ticksInUse > 11 && ticksInUse % 2 == 0) {
        	return iconArray[3];
        } else if (ticksInUse > 11) { //alt condition => ticksInuse % 2 == 1
        	itemCharge = true;
        	return iconArray[2];
        } else if (ticksInUse > 9) {
            return iconArray[2];
        } else if (ticksInUse > 7) {
            return iconArray[1];
        } else if (ticksInUse > 0) {
            return iconArray[0];
        } else {
            return itemIcon;
        }
    }

}
