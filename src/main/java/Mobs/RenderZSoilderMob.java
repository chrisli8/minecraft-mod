package Mobs;

import java.util.UUID;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.model.ModelZombieVillager;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;

//public class RenderZSoilderMob extends RenderBiped {
	//name of texture still needed
//	private static final ResourceLocation mobTextures = new ResourceLocation(Constants.MODID + ":textures/entity/");
//	
//	public RenderZSoilderMob(ModelBase par1ModelBase, float par2) {
//		super(par1ModelBase, par2);
//	}
//	
//	
//	protected ResourceLocation getEntityTextue(EntityZSoilderMob entity) {
//		return mobTextures;
//	}

@SideOnly(Side.CLIENT)
public class RenderZSoilderMob extends RenderBiped
{
    private static final ResourceLocation mobTextures = new ResourceLocation(Constants.MODID + ":textures/entity/zombie.png");
    private static final String __OBFID = "CL_00000984";

    public RenderZSoilderMob(ModelBase p_i1253_1_, float p_i1253_2_)
    {
        super((ModelBiped) p_i1253_1_, p_i1253_2_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityZSoilderMob p_110775_1_)
    {
        return mobTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityZSoilderMob)p_110775_1_);
    }
    
}