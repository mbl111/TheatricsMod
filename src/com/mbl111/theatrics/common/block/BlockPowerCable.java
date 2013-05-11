package com.mbl111.theatrics.common.block;

import java.util.ArrayList;

import com.mbl111.theatrics.common.TheatricsMod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPowerCable extends Block {

	public BlockPowerCable(int par1, Material par2Material) {
		super(par1, par2Material);
		setUnlocalizedName("powercable");
		setHardness(0.02F);
		setStepSound(soundClothFootstep);
		
	}

	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		items.add(new ItemStack(TheatricsMod.ItemPowerCable));
		return items;
	}
	
	@Override
	public int isProvidingStrongPower(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) {
		return 15;
	}
	
	@Override
	public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5) {
		//TODO The % of data set to 1 :D
		return 12;
	}
	
	@Override
	public boolean hasComparatorInputOverride() {
		return true;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	private boolean hasDataSourceOnCableFromBlock(World world, int x, int y, int z) {
		int u = world.getBlockId(x, y + 1, z);
		int d = world.getBlockId(x, y - 1, z);
		int n = world.getBlockId(x + 1, y, z);
		int s = world.getBlockId(x - 1, y, z);
		int e = world.getBlockId(x, y, z + 1);
		int w = world.getBlockId(x, y, z - 1);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int bId) {
		if (bId == this.blockID){
			if (connected){
				
			}else{
				
			}
		}else if (false){
			//Controller broken
		}
		
	}
	
	// public static int renderId =
	// RenderingRegistry.getNextAvailableRenderId();
	//BlockRedstoneWire
	
	
}
