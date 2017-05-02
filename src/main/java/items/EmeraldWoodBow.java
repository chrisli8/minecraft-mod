package items;


import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import creativeTabs.Tabs;
import lib.Constants;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class EmeraldWoodBow extends ItemBow{
	public String name = "bowEmerald";
	public static final String[] bowPullIconNameArray = new String[] {"pull_0", "pull_1", "pull_2"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
    private static final String __OBFID = "CL_00001777";
	
	public EmeraldWoodBow() {
		super();
		setUnlocalizedName(Constants.MODID + "_" + name);
		//setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Tabs.gemsTab);
		
	}
	
	/**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
	@Override
    public void onPlayerStoppedUsing(ItemStack item, World world, EntityPlayer player, int p_77615_4_)
    {
        int j = (this.getMaxItemUseDuration(item) - p_77615_4_) * 2;

        ArrowLooseEvent event = new ArrowLooseEvent(player, item, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, item) > 0;

        if (flag || player.inventory.hasItem(Items.arrow))
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityArrow entityarrow = new EntityArrow(world, player, f * 2.0F);
            EntityArrow entityarrow2 = new EntityArrow(world, player, f * 3.0F);
            EntityArrow entityarrow3 = new EntityArrow(world, player, f * 1.0F);

            if (f == 1.0F)
            {
                entityarrow.setIsCritical(true);
                entityarrow2.setIsCritical(true);
                entityarrow3.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, item);

            if (k > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
                entityarrow2.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
                entityarrow3.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, item);

            if (l > 0)
            {
                entityarrow.setKnockbackStrength(l);
                entityarrow2.setKnockbackStrength(l);
                entityarrow3.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, item) > 0)
            {
                entityarrow.setFire(100);
                entityarrow2.setFire(100);
                entityarrow3.setFire(100);
            }

            item.damageItem(1, player);
            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag)
            {
                entityarrow.canBePickedUp = 2;
                entityarrow2.canBePickedUp = 2;
                entityarrow3.canBePickedUp = 2;
            }
            else
            {
                player.inventory.consumeInventoryItem(Items.arrow);
            }

            if (!world.isRemote)
            {
                world.spawnEntityInWorld(entityarrow);
//                world.spawnEntityInWorld(entityarrow2);
//                world.spawnEntityInWorld(entityarrow3);
            }
        }
    }
	
	/**
     * Returns True is the item is renderer in full 3D when hold.
     */
	@Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        this.itemIcon = p_94581_1_.registerIcon(Constants.MODID + ":" + name);
        this.iconArray = new IIcon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = p_94581_1_.registerIcon(Constants.MODID + ":" + name + "_" + bowPullIconNameArray[i]);
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
        if (ticksInUse > 9) {
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
