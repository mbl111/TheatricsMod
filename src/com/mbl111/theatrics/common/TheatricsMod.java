package com.mbl111.theatrics.common;

import java.io.File;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.Configuration;

import com.mbl111.theatrics.common.block.BlockPowerCable;
import com.mbl111.theatrics.common.item.ItemCable;
import com.mbl111.theatrics.common.util.Constants;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.VERSION)
public class TheatricsMod {

	@Instance("Constants.MOD_ID")
	public static TheatricsMod instance;

	@SidedProxy(clientSide = Constants.CLIENT_PROXY_CLASS, serverSide = Constants.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	// Blocks
	public static ItemCable ItemPowerCable = new ItemCable(1024);
	public static BlockPowerCable blockPowerCable = new BlockPowerCable(1025, Material.cloth);

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {

		File configFile = event.getSuggestedConfigurationFile();

		Configuration config = new Configuration(configFile);
		config.load();
		config.save();
	}

	@Init
	public void load(FMLInitializationEvent event) {
		GameRegistry.registerBlock(blockPowerCable, "powercable");
		LanguageRegistry.addName(blockPowerCable, "powercable");
		LanguageRegistry.addName(ItemPowerCable, "Bundled Power Cable");
		proxy.registerRenderers();
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {

	}

}
