package com.mbl111.theatrics.common.item;

import com.mbl111.theatrics.common.TheatricsMod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCable extends Item {

	public ItemCable(int par1) {
		super(par1);
		setUnlocalizedName("itemcable");
		setCreativeTab(CreativeTabs.tabRedstone);
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int x, int y, int z, int side, float a, float b, float c) {
		int bid = world.getBlockId(x, y, z);
		
		if (world.getBlockId(x, y, z) != 0 && !Block.blocksList[bid].isBlockReplaceable(world, x, y, z) && bid != Block.tallGrass.blockID) {
			switch (side) {
			case 0:
				y--;
				break;
			case 1:
				y++;
				break;
			case 2:
				z--;
				break;
			case 3:
				z++;
				break;
			case 4:
				x--;
				break;
			case 5:
				x++;
			}

		}

		if (!par2EntityPlayer.capabilities.isCreativeMode)
			par1ItemStack.stackSize -= 1;
		world.setBlock(x, y, z, TheatricsMod.blockPowerCable.blockID);
		return true;
	}
	
}
