// Todo: Make recipe for Saphire Iron Spade

package chris.modproject;

import world.CGLWorld;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import items.ModItems;
import Mobs.EntityMobs;
import blocks.ModBlocks;
import lib.Constants;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import creativeTabs.Tabs;

@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = Constants.VERSION)

public class FirstMod {
	@SidedProxy(clientSide = "chris.modproject.ClientProxy", serverSide = "chris.modproject.ServerProxy")
	public static ServerProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.registerRenderThings();
		ModBlocks.init();
		ModItems.init();
		Tabs.init();
		EntityMobs.mainRegistry();
		CGLWorld.mainRegistry();
		
		craftingRecipes();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@Mod.EventHandler 
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	public static void craftingRecipes() {
		//ruby iron sword
		GameRegistry.addRecipe(new ItemStack(ModItems.ironRubySword), new Object[] {
			"A",
			"B",
			"C",
			'A', Items.iron_ingot, 'B', ModItems.ruby, 'C', Items.stick
		});
		//amethyst iron sword
		GameRegistry.addRecipe(new ItemStack(ModItems.ironAmethystSword), new Object[] {
			"A",
			"B",
			"C",
			'A', Items.iron_ingot, 'B', ModItems.amethyst, 'C', Items.stick
		});
		//saphire iron sword
		GameRegistry.addRecipe(new ItemStack(ModItems.ironSaphireSword), new Object[] {
			"A",
			"B",
			"C",
			'A', Items.iron_ingot, 'B', ModItems.saphire, 'C', Items.stick
		});
		//emerald iron sword
		GameRegistry.addRecipe(new ItemStack(ModItems.ironEmeraldSword), new Object[] {
			"A",
			"B",
			"C",
			'A', Items.iron_ingot, 'B', Items.emerald, 'C', Items.stick
		});
		
		//diamond iron sword
		GameRegistry.addRecipe(new ItemStack(ModItems.ironEmeraldSword), new Object[] {
			"A",
			"B",
			"C",
			'A', Items.iron_ingot, 'B', Items.diamond, 'C', Items.stick
		});
		//amethyst iron axe
		GameRegistry.addRecipe(new ItemStack(ModItems.ironAmethytAxe), new Object[] {
			"AB ",
			"AC ",
			" C ",
			'A', Items.iron_ingot, 'B', ModItems.amethyst, 'C', Items.stick
		});
		//alt recipe
		GameRegistry.addRecipe(new ItemStack(ModItems.ironAmethytAxe), new Object[] {
			" BA",
			" CA",
			" C ",
			'A', Items.iron_ingot, 'B', ModItems.amethyst, 'C', Items.stick
		});
		
		//Ruby amethyst sword
		GameRegistry.addRecipe(new ItemStack(ModItems.ametystRubySword), new Object[] {
			"A",
			"B",
			"C",
			'A', ModItems.amethyst, 'B', ModItems.ruby, 'C', Items.stick
		});
		//Ruby Block
		GameRegistry.addRecipe(new ItemStack(ModBlocks.rubyBlock), new Object[] {
			"AAA",
			"AAA",
			"AAA",
			'A', ModItems.ruby
		});
		//Amethyst Block
		GameRegistry.addRecipe(new ItemStack(ModBlocks.amethystBlock), new Object[] {
			"AAA",
			"AAA",
			"AAA",
			'A', ModItems.amethyst
		});
		//Saphire Block
		GameRegistry.addRecipe(new ItemStack(ModBlocks.saphireBlock), new Object[] {
			"AAA",
			"AAA",
			"AAA",
			'A', ModItems.saphire
		});
	}
}
