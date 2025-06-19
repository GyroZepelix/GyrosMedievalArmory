package com.dgjalic.gyrosmedievalarmory;

import com.dgjalic.gyrosmedievalarmory.block.BlockRegistry;
import com.dgjalic.gyrosmedievalarmory.item.ItemRegistry;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GyrosMedievalArmory.MODID)
public class GyrosMedievalArmory
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "gyrosmedievalarmory";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public GyrosMedievalArmory(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ItemRegistry.REGISTRY.register(modEventBus);
        BlockRegistry.REGISTRY.register(modEventBus);
//        MinecraftForge.EVENT_BUS.register(this);

//        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

//    @SubscribeEvent
//    public void onServerStarting(ServerStartingEvent event)
//    {
//        // Do something when the server starts
//        LOGGER.info("HELLO from server starting");
//    }
//
//    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
//    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
//    public static class ClientModEvents
//    {
//        @SubscribeEvent
//        public static void onClientSetup(FMLClientSetupEvent event)
//        {
//            // Some client setup code
//            LOGGER.info("HELLO FROM CLIENT SETUP");
//            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
//        }
//    }
}
