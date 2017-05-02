package items;

import cpw.mods.fml.common.registry.GameRegistry;
import creativeTabs.Tabs;
import lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class AmethystIronAxe extends ItemAxe {
	public String name = "hatchetIronAmethyst";
	
	public AmethystIronAxe(Item.ToolMaterial material) {
		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Tabs.gemsTab);
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack p_150894_1_, World world, Block block, int x, int y, int z, EntityLivingBase player)
    {
		int count = 1;
		if(block.isWood(world, x, y, z)) { //can kill more than one tree if they are touching
        	count += treeCheck(world, block, x, y, z);
        	//System.out.println(count);
        }
		
        if ((double)block.getBlockHardness(world, x, y, z) != 0.0D)
        {
            p_150894_1_.damageItem((count / 5), player);
        }
        
        return true;
    }
	
	private int treeCheck(World world, Block block, int x, int y, int z) {
		int count = 0;
		if(block.isWood(world, x, y, z) || block.isLeaves(world, x, y, z)) {
			count += 1 +
			treeCheck(world, world.getBlock(x, y + 1, z), x, y + 1, z) +
			treeCheck(world, world.getBlock(x + 1, y, z), x + 1, y, z) +
			treeCheck(world, world.getBlock(x, y, z + 1), x, y, z + 1);
			
			getDrop(world, x, y, z, true);
			
			count +=
			treeCheck(world, world.getBlock(x, y - 1, z), x, y - 1, z) + 
			treeCheck(world, world.getBlock(x - 1, y, z), x - 1, y, z) +
			treeCheck(world, world.getBlock(x, y, z -1), x, y ,z - 1);
		}
		return count;
	}
	
	//rewritten func_147480_a without sound effects (get drop from block)
	private boolean getDrop(World world,int x, int y, int z, boolean bool) {
		Block block1 = world.getBlock(x, y, z);

        if (block1.getMaterial() == Material.air)
        {
            return false;
        }
        else
        {
            int l = world.getBlockMetadata(x, y, z);

            if (bool)
            {
                block1.dropBlockAsItem(world, x, y, z, l, 0);
            }

            return world.setBlock(x, y, z, Blocks.air, 0, 3);
        }
	}
}
