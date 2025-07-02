package com.dgjalic.gyrosmedievalarmory.client;

import com.dgjalic.gyrosmedievalarmory.GyrosMedievalArmory;
import com.dgjalic.gyrosmedievalarmory.item.armor.LegacyOpenableHelmet;
import com.dgjalic.gyrosmedievalarmory.networking.ModPackets;
import com.dgjalic.gyrosmedievalarmory.networking.packet.OpenVisorC2SPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = GyrosMedievalArmory.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (!KeyBinding.OPEN_VISOR_KEY.consumeClick()) {
                return;
            }
            assert Minecraft.getInstance().player != null;
            ItemStack helmet = Minecraft.getInstance().player.getItemBySlot(EquipmentSlot.HEAD);

            if (!(helmet.getItem() instanceof LegacyOpenableHelmet openableHelmet)) {
                return;
            }

            ModPackets.sendToServer(new OpenVisorC2SPacket());
        }

//        @SubscribeEvent
//        public static void onKeyInput(InputEvent.Key event) {
//            if (!KeyBinding.OPEN_VISOR_KEY.consumeClick()) {
//                return;
//            }
//            assert Minecraft.getInstance().player != null;
//            ItemStack helmet = Minecraft.getInstance().player.getItemBySlot(EquipmentSlot.HEAD);
//
//            if (!(helmet.getItem() instanceof OpenableHelmet openableHelmet)) {
//                return;
//            }
//
//            AnimationState animationState = openableHelmet.getAnimationStatus(helmet);
//
//            if (AnimationState.IDLE != animationState) {
//                return;
//            }
//            boolean isOpened = openableHelmet.isOpened(helmet);
//            float timestamp = openableHelmet.getTimestamp(helmet);
//
//            ModPackets.sendToServer(new SetHelmetAnimationState(isOpened, AnimationState.QUEUED, timestamp));
//        }
    }

    @Mod.EventBusSubscriber(modid = GyrosMedievalArmory.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.OPEN_VISOR_KEY);
        }
    }
}
