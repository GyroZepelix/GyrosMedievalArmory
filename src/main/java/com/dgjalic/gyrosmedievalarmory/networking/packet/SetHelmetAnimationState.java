package com.dgjalic.gyrosmedievalarmory.networking.packet;

import com.dgjalic.gyrosmedievalarmory.item.armor.OpenableHelmet;
import com.dgjalic.gyrosmedievalarmory.animation.AnimationState;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.nio.ByteBuffer;
import java.util.function.Supplier;

public class SetHelmetAnimationState {
    private static final byte TRUE_BIT_MASK = (byte) 0b10000000;
    private static final byte FALSE_BIT_MASK = (byte) 0b00000000;

    private final boolean opened;
    private final AnimationState animationState;
    private final float timestamp;

    public SetHelmetAnimationState(boolean opened, AnimationState animationState, float timestamp) {
        this.opened = opened;
        this.animationState = animationState;
        this.timestamp = timestamp;
    }
    public SetHelmetAnimationState(FriendlyByteBuf buf) {
        ByteBuf bytes = buf.readBytes(5);

        byte animStateWithOpenedState = bytes.getByte(0);
        this.opened = (animStateWithOpenedState & TRUE_BIT_MASK) != 0;

        byte clearedAnimationState = (byte) (animStateWithOpenedState & (~TRUE_BIT_MASK));
        this.animationState = AnimationState.fromByte(clearedAnimationState);

        this.timestamp = bytes.getFloat(1);
    }

    public void toBytes(FriendlyByteBuf buf) {
        byte opened = this.opened ? TRUE_BIT_MASK : FALSE_BIT_MASK;

        // combines the animationState with the one bit for the boolean
        byte animStateWithOpenedState = (byte) (opened | animationState.toByte());

        byte[] bytes = ByteBuffer.allocate(5)
                        .put(animStateWithOpenedState)
                        .putFloat(timestamp)
                        .array();

        buf.writeBytes(bytes);
    }

    public void handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            if (player != null) {
                ServerLevel level = player.serverLevel();
                ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

                if (helmet.getItem() instanceof OpenableHelmet openableHelmet) {
                    switch (animationState) {
                        case IDLE, QUEUED -> {
                            openableHelmet.setOpened(helmet, level, player, opened);
                            openableHelmet.setAnimationStatus(helmet, level, player, animationState);
                        }
                        case PLAYING -> {
                            openableHelmet.setTimestamp(helmet, level, player, timestamp);
                            openableHelmet.setAnimationStatus(helmet, level, player, animationState);
                        }
                    }
                }
            }
        });
    }
}
