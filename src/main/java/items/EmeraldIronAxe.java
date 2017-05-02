package items;

import java.util.ArrayList;

import lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import creativeTabs.Tabs;

public class EmeraldIronAxe extends ItemAxe {
	public String name = "hatchetIronEmerald";
	
	public EmeraldIronAxe(Item.ToolMaterial material) {
		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Tabs.gemsTab);
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack p_150894_1_, World world, Block block, int x, int y, int z, EntityLivingBase player)
    {
//		world.setBlock(x, y, z, Blocks.obsidian);
//		ArrayList <Integer> list = new ArrayList();
//		if(block.isWood(world, x, y, z)) { //can kill more than one tree if they are touching
//			list.addAll(treeCheck(world, block, x, y, z));
//			for(int i = 0; i < list.size(); i += 3) {
//				world.setBlock(list.get(i), list.get(i + 1), list.get(i + 2), Blocks.obsidian, 0, 3);
//			}
//			//world.setBlock(x, y, z, Blocks.obsidian);
//        }
		treeCheck(world, block, x, y ,z);
		
        if ((double)block.getBlockHardness(world, x, y, z) != 0.0D)
        {
            p_150894_1_.damageItem(1, player); //list.size() / 3
        }
        
        return true;
    }
	
	private ArrayList treeCheck(World world, Block block, int x, int y, int z) {
		ArrayList list = new ArrayList();;
		if(block.isWood(world, x, y, z) || block.isLeaves(world, x, y, z)) {
			list.addAll(treeCheck(world, world.getBlock(x, y + 1, z), x, y + 1, z));
			list.addAll(treeCheck(world, world.getBlock(x + 1, y, z), x + 1, y, z));
			list.addAll(treeCheck(world, world.getBlock(x, y, z + 1), x, y, z + 1));
			
			//list.addAll(treeCheck(world, world.getBlock(x + 1, y, z + 1), x + 1, y, z + 1));
			//list.addAll(treeCheck(world, world.getBlock(x + 1, y, z - 1), x + 1, y, z + 1));
			
			if(block.isWood(world, x, y, z)) {
				list.add(x);
				list.add(y);
				list.add(z);
				getDrop(world, x, y ,z, false);
				world.setBlock(x, y, z, Blocks.obsidian);
			} else {
				getDrop(world, x, y, z, false);
				world.setBlock(x, y, z, Blocks.glowstone);
			}
			
			list.addAll(treeCheck(world, world.getBlock(x, y - 1, z), x, y - 1, z)); 
			list.addAll(treeCheck(world, world.getBlock(x - 1, y, z), x - 1, y, z));
			list.addAll(treeCheck(world, world.getBlock(x, y, z -1), x, y ,z - 1));
			
			//list.addAll(treeCheck(world, world.getBlock(x - 1, y, z + 1), x + 1, y, z + 1));
			//list.addAll(treeCheck(world, world.getBlock(x - 1, y, z - 1), x + 1, y, z + 1));
		}
		return list;
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
