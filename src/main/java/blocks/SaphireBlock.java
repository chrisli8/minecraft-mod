package blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import creativeTabs.Tabs;
import lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SaphireBlock extends Block {
	
	public String name = "blockSaphire";
	public SaphireBlock() {
		
		super(Material.rock);
		setBlockName(Constants.MODID + "_" + name); //MODID_BOCKNAME
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(Tabs.gemsTab);
		GameRegistry.registerBlock(this, name);
	}
}
