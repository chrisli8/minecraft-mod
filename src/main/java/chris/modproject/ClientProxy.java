package chris.modproject;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderZombie;
import Mobs.EntityZSoilderMob;
import Mobs.EntityZombieCopy;
import Mobs.RenderZSoilderMob;
import Mobs.RenderZombieCopy;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	public void registerRenderThings() {
		RenderingRegistry.registerEntityRenderingHandler(EntityZSoilderMob.class, new RenderZSoilderMob(new ModelZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieCopy.class, new RenderZombieCopy());
	}
}
