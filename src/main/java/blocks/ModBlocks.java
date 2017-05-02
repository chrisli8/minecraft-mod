package blocks;

import net.minecraft.block.Block;

public final class ModBlocks {
	public static Block rubyOre;
	public static Block amethystOre;
	public static Block saphireOre;
	public static Block crystalColumnBlock;
	public static Block testBlock;
	public static Block rubyBlock;
	public static Block saphireBlock;
	public static Block amethystBlock;
	public static Block greenBlock;
	
	public static Block quartzRail;
	public static Block stoneRail;
	
	public static Block diamondGlimer;
	
	public static void init() {
		rubyOre = new RubyOre().setHardness(3.0F).setResistance(5.0F);
		amethystOre = new AmethystOre().setHardness(3.0F).setResistance(5.0F);
		saphireOre = new SaphireOre().setHardness(3.0F).setResistance(5.0F);
		
		rubyBlock = new RubyBlock().setHardness(3.0F).setResistance(5.0F);
		saphireBlock = new SaphireBlock().setHardness(3.0F).setResistance(5.0F);
		amethystBlock = new AmethystBlock().setHardness(3.0F).setResistance(5.0F);
		
		crystalColumnBlock = new CrystalColumnBlock().setHardness(3.0F).setResistance(5.0F);
		testBlock = new TestBlock().setHardness(3.0F).setResistance(5.0F);
		greenBlock = new GreenBlock().setHardness(3.0F).setResistance(5.0F).setLightLevel(1F);
		
		quartzRail = new QuartzRail().setHardness(3.0F).setResistance(5.0F);
		stoneRail = new StoneRail().setHardness(3.0F).setResistance(5.0F);
		
		diamondGlimer = new DiamondGlimer().setLightLevel(1F);
	}
}
