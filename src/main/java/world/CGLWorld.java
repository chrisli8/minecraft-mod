package world;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class CGLWorld {
	public static void mainRegistry() {
		initWorldGen();
	}
	
	public static void initWorldGen() {
		registerWorldGen(new CGLWorldGenOre(), 1);
		
	}
	
	public static void registerWorldGen(IWorldGenerator worldGenClass, int weightedProbability) {
		GameRegistry.registerWorldGenerator(worldGenClass, 1);
	}
}
