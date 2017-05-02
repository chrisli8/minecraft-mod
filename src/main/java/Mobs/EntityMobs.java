package Mobs;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import lib.Constants;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.world.biome.BiomeGenBase;


public class EntityMobs {
	public static void mainRegistry() {
		registerEntity();
	}
	
	public static void registerEntity() {
		createEntity(EntityZSoilderMob.class, "Soilder Mob", 0x4A4A4A, 0xE9A3FF);
		// createEntity(EntityZombieCopy.class, "Zombie Copy", 0x4A4A4A, 0xE9A3FF);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) {
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, Constants.MODID, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, 2, 0, 5, EnumCreatureType.monster, BiomeGenBase.forest);
		
		createEgg(randomId, solidColor, spotColor);
	}
	
	private static void createEgg(int randomId, int solidColor, int spotColor) {
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
	}
}
