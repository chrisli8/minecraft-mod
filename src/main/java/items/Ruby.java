package items;

import lib.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import creativeTabs.Tabs;

public class Ruby extends Item{
	public String name = "ruby";
	
	public Ruby() {
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Tabs.gemsTab);
	}
}
