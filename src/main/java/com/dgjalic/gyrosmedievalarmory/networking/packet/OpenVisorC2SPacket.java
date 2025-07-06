package com.dgjalic.gyrosmedievalarmory.networking.packet;

import com.dgjalic.gyrosmedievalarmory.item.armor.LegacyOpenableHelmet;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class OpenVisorC2SPacket {

    public OpenVisorC2SPacket() {
    }
    public OpenVisorC2SPacket(FriendlyByteBuf buf) {
    }

    public void toBytes(FriendlyByteBuf buf) {
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            if (player != null) {
                ServerLevel level = player.serverLevel();
                ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

                if (helmet.getItem() instanceof LegacyOpenableHelmet legacyOpenableHelmet) {
                    legacyOpenableHelmet.changeHelmetStyle(helmet, level, player);
                }
            }
        });
        return true;
    }
}