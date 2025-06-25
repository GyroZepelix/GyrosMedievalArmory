package com.dgjalic.gyrosmedievalarmory.client;

import com.dgjalic.gyrosmedievalarmory.GyrosMedievalArmory;
import com.dgjalic.gyrosmedievalarmory.networking.ModPackets;
import com.dgjalic.gyrosmedievalarmory.networking.packet.OpenVisorC2SPacket;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = GyrosMedievalArmory.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.OPEN_VISOR_KEY.consumeClick()) {
                ModPackets.sendToServer(new OpenVisorC2SPacket());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = GyrosMedievalArmory.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.OPEN_VISOR_KEY);
        }
    }
}
