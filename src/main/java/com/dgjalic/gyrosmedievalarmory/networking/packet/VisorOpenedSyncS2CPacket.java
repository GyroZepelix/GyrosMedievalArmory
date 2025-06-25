package com.dgjalic.gyrosmedievalarmory.networking.packet;

import com.dgjalic.gyrosmedievalarmory.item.armor.OpenableHelmet;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class VisorOpenedSyncS2CPacket {
    private final boolean isOpened;

    public VisorOpenedSyncS2CPacket(boolean isOpened) {
        this.isOpened = isOpened;
    }
    public VisorOpenedSyncS2CPacket(FriendlyByteBuf buf) {
        this.isOpened = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(isOpened);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            Player player = Minecraft.getInstance().player;
            if (player != null) {
                ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
                if (helmet.getItem() instanceof OpenableHelmet openableHelmet) {
                    openableHelmet.setHelmetStyle(helmet, player.level(), player, isOpened);
                }
            }
        });
        return true;
    }
}
