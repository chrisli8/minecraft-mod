package blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class CrystalColumnBlock extends Block {
	public String name = "crystalColumnBlock";
	private IIcon[] icons = new IIcon[6];
	
	public CrystalColumnBlock() {
		super(Material.rock);
		setBlockName(Constants.MODID + "_" + name);
		
		setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, name);
		setLightLevel(1.0F);
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		for(int i = 0; i < icons.length; i++) {
			if(i <= 1) {
				icons[i] = iconRegister.registerIcon(Constants.MODID + ":" + name + "Top");
			} else {
				icons[i] = iconRegister.registerIcon(Constants.MODID + ":" + name + "Side");
			}
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return icons[side];
	}

}
