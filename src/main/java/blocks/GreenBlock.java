package blocks;

import lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import creativeTabs.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GreenBlock extends Block {
	public String name = "blockGreen";
	public GreenBlock() {
		
		super(Material.rock);
		setBlockName(Constants.MODID + "_" + name); //MODID_BOCKNAME
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(Tabs.gemsTab);
		GameRegistry.registerBlock(this, name);
	}
}
