package items;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import creativeTabs.Tabs;
import lib.Constants;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class MoonSilverBlade extends ItemSword {
	private boolean itemCharge = false;
	private boolean chargeUsed = true;
	public String name = "swordMoon";
	public static final String[] stageStringArray = new String[] {"0", "1" };
	@SideOnly(Side.CLIENT)
	public IIcon[] iconArray;
	
	public MoonSilverBlade(Item.ToolMaterial material) {
		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Tabs.gemsTab);
	}
	
	@Override
	public boolean hitEntity(ItemStack sword, EntityLivingBase target, EntityLivingBase player) {
		//not seeing particles
		Random rand = new Random();
		if(!player.worldObj.isRemote) {
			for(int i = 0; i < 30; i++) {
				double motionX = rand.nextGaussian() * 0.02D;
			    double motionY = rand.nextGaussian() * 0.02D;
			    double motionZ = rand.nextGaussian() * 0.02D;
			    target.worldObj.spawnParticle(
			          "happyVillager", 
			          target.posX + rand.nextFloat() * target.width * 2.0F - target.width, 
			          target.posY + 0.5D + rand.nextFloat() * target.height, 
			          target.posZ + rand.nextFloat() * target.width * 2.0F - target.width, 
			          motionX, 
			          motionY, 
			          motionZ);
			}
		}
		sword.damageItem(1, player);
		return true;
	}
	
	/**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
	@Override
    public void onPlayerStoppedUsing(ItemStack item, World world, EntityPlayer player, int p_77615_4_)
    {
		if(itemCharge && !world.isRemote) {
			chargeUsed = true;
			itemCharge = false;
			AxisAlignedBB axisalignedbb = player.boundingBox.expand(8.0D, 8.0D, 8.0D);
	        List list1 = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
	    	if(list1 != null && !list1.isEmpty()) {
	    		Iterator iterator = list1.iterator();
	    		while (iterator.hasNext())
	            {
	                EntityLivingBase entitylivingbase = (EntityLivingBase)iterator.next();
	                double d0 = player.getDistanceSqToEntity(entitylivingbase);
	
	                if (d0 < 64.0D && (entitylivingbase != player))
	                {
	                	double x = entitylivingbase.posX;
	                	double y = entitylivingbase.posY;
	                	double z = entitylivingbase.posZ;
	                	
	                	double xp = player.posX;
	                	double yp = player.posY;
	                	double zp = player.posZ;
	                	
	                	//pulls mobs towards, switch xp, x etc. for push away
	                    entitylivingbase.addVelocity((xp - x) / 2.5, (yp - y) /2.5 + 0.2, (zp - z) / 2.5);
	                    entitylivingbase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 2));
	                    entitylivingbase.attackEntityFrom(new EntityDamageSource("player", player), 5.0F);
	                }
	            }
	    		
	    	}
		} else if(chargeUsed && !world.isRemote) {
			//buggy fire balls fly everywhere
			//EntitySmallFireball entitysmallfireball = new EntitySmallFireball(world, player, player.getLookVec().xCoord, player.getLookVec().yCoord, player.getLookVec().zCoord);
            //entitysmallfireball.posY = player.posY + (double)(player.height / 4.0F) + 0.5D;
            //player.worldObj.spawnEntityInWorld(entitysmallfireball);
			
			//fire potion instant damage
			EntityPotion entitypotion = new EntityPotion(player.worldObj, player, 1);
			entitypotion.setPotionDamage(32684);
			entitypotion.setThrowableHeading(player.getLookVec().xCoord, player.getLookVec().yCoord, player.getLookVec().zCoord, 1.6F, 12.0F);
			player.playSound("random.bow", 1.0F, 1.0F / (player.getRNG().nextFloat() * 0.4F + 0.8F));
	        player.worldObj.spawnEntityInWorld(entitypotion);
			
//			EntitySnowball entitysnowball = new EntitySnowball(player.worldObj, player);
//	        double d0 = player.posX - player.posX;
//	        double d1 = player.posY + (double)player.getEyeHeight() - 1.100000023841858D - entitysnowball.posY;
//	        double d2 = player.posZ - player.posZ;
//	        float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
//	        entitysnowball.setThrowableHeading(player.getLookVec().xCoord, player.getLookVec().yCoord, player.getLookVec().zCoord, 1.6F, 12.0F);
//	        player.playSound("random.bow", 1.0F, 1.0F / (player.getRNG().nextFloat() * 0.4F + 0.8F));
//	        player.worldObj.spawnEntityInWorld(entitysnowball);
		}
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
        if (ticksInUse > 11 && ticksInUse % 3 == 0) {
        	return iconArray[1];
        } else if (ticksInUse > 11) { //alt condition => ticksInuse % 2 == 1
        	itemCharge = true;
        	chargeUsed= false;
        	return iconArray[0];
        } else {
            return itemIcon;
        }
    }
}
