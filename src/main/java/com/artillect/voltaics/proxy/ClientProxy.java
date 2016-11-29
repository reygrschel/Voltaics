package com.artillect.voltaics.proxy;

import com.artillect.voltaics.RegistryManager;
import com.artillect.voltaics.client.BakedModelLoader;

import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event){
		super.preInit(event);
		RegistryManager.registerRendering();
        ModelLoaderRegistry.registerLoader(new BakedModelLoader());
	}
}
