package items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;

public class ModItems {
	
	public static Item rubySword;
	public static Item ironRubySword;
	public static Item ruby;
	public static Item ironAmethystSword;
	public static Item amethyst;
	public static Item ironSaphireSword;
	public static Item saphire;
	public static Item ironEmeraldSword;
	public static Item ironDiamondSword;
	public static Item ironAmethytAxe;
	public static Item ironEmeraldAxe;
	public static Item woodEmeraldBow;
	public static Item ironDiamondPickaxe;
	public static Item ametystRubySword;
	public static Item busterSword;
	public static Item moonSilverBlade;
	public static Item ironSaphireSpade;
	
	
	public static void init() {
		
		rubySword = new RubySword(Item.ToolMaterial.IRON);
		
		ruby = new Ruby();
		
		amethyst = new Amethyst();
		
		saphire = new Saphire();
		ironRubySword = new RubyIronSword(Item.ToolMaterial.EMERALD);
		ironSaphireSword = new SaphireIronSword(Item.ToolMaterial.EMERALD);
		ironAmethystSword = new AmethystIronSword(Item.ToolMaterial.EMERALD);
		ironEmeraldSword = new EmeraldIronSword(Item.ToolMaterial.EMERALD);
		ironDiamondSword = new DiamondIronSword(Item.ToolMaterial.EMERALD);
		ametystRubySword = new AmethystRubySword(Item.ToolMaterial.EMERALD);
		
		ironAmethytAxe = new AmethystIronAxe(Item.ToolMaterial.IRON);
		ironEmeraldAxe = new EmeraldIronAxe(Item.ToolMaterial.IRON);
		
		woodEmeraldBow = new EmeraldWoodBow();
		
		ironDiamondPickaxe = new DiamondIronPick(Item.ToolMaterial.IRON);
		
		ironSaphireSpade = new SaphireIronSpade(Item.ToolMaterial.IRON);
		
		busterSword= new BusterSword(Item.ToolMaterial.EMERALD);
		moonSilverBlade = new MoonSilverBlade(Item.ToolMaterial.EMERALD);
	}

}
