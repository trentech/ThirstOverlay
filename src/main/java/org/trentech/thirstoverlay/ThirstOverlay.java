package org.trentech.thirstoverlay;

import org.trentech.thirstoverlay.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ThirstOverlay.MODID, version = ThirstOverlay.VERSION, name = ThirstOverlay.NAME)
public class ThirstOverlay {
    public static final String MODID = "thirstoverlay";
    public static final String VERSION = "1.0";
    public static final String NAME = "Thirst Overlay";

    @SidedProxy(clientSide = "org.trentech.thirstoverlay.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static ThirstOverlay instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new GuiOverlay());
        proxy.postInit(event);
    }
}
