package blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import creativeTabs.Tabs;
import lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class RubyBlock extends Block {
	
	public String name = "blockRuby";
	public RubyBlock() {
		
		super(Material.rock);
		setBlockName(Constants.MODID + "_" + name); //MODID_BOCKNAME
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(Tabs.gemsTab);
		GameRegistry.registerBlock(this, name);
	}
}
