package creativeTabs;

import items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Tabs {
	
	public static CreativeTabs gemsTab = new CreativeTabs("gemsTab") {
		@Override
		public Item getTabIconItem() {
			return ModItems.ruby;
		}
	};
	
	public static void init() {
		
	}
	
}
