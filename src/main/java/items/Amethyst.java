package items;

import cpw.mods.fml.common.registry.GameRegistry;
import creativeTabs.Tabs;
import net.minecraft.item.Item;
import lib.Constants;

public class Amethyst extends Item {
	public String name = "amethyst";
	
	public Amethyst() {
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Tabs.gemsTab);
	}

}
