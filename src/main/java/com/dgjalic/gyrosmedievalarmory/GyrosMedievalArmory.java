package com.dgjalic.gyrosmedievalarmory;

import com.dgjalic.gyrosmedievalarmory.block.BlockRegistry;
import com.dgjalic.gyrosmedievalarmory.item.CreativeTabRegistry;
import com.dgjalic.gyrosmedievalarmory.item.ItemRegistry;
import com.dgjalic.gyrosmedievalarmory.networking.ModPackets;
import com.mojang.logging.LogUtils;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(GyrosMedievalArmory.MODID)
public class GyrosMedievalArmory
{
    public static final String MODID = "gyrosmedievalarmory";
    private static final Logger LOGGER = LogUtils.getLogger();

    public GyrosMedievalArmory(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ItemRegistry.REGISTRY.register(modEventBus);
        BlockRegistry.REGISTRY.register(modEventBus);
        CreativeTabRegistry.REGISTRY.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {});
        ModPackets.register();
    }
}
