package items;

import cpw.mods.fml.common.registry.GameRegistry;
import creativeTabs.Tabs;
import lib.Constants;
import net.minecraft.item.Item;

public class Saphire extends Item {
	public String name = "saphire";
	
	public Saphire() {
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Tabs.gemsTab);
	}
}	
