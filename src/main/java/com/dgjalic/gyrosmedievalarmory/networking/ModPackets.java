package com.dgjalic.gyrosmedievalarmory.networking;

import com.dgjalic.gyrosmedievalarmory.GyrosMedievalArmory;
import com.dgjalic.gyrosmedievalarmory.networking.packet.OpenVisorC2SPacket;
import com.dgjalic.gyrosmedievalarmory.networking.packet.VisorOpenedSyncS2CPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModPackets {
    private static SimpleChannel INSTANCE;
    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        INSTANCE = NetworkRegistry.ChannelBuilder
                .named(ResourceLocation.fromNamespaceAndPath(GyrosMedievalArmory.MODID, "packets"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE.messageBuilder(OpenVisorC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(OpenVisorC2SPacket::new)
                .encoder(OpenVisorC2SPacket::toBytes)
                .consumerMainThread(OpenVisorC2SPacket::handle)
                .add();

        INSTANCE.messageBuilder(VisorOpenedSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(VisorOpenedSyncS2CPacket::new)
                .encoder(VisorOpenedSyncS2CPacket::toBytes)
                .consumerMainThread(VisorOpenedSyncS2CPacket::handle)
                .add();
    }

    public static <T> void sendToServer(T message) {
        INSTANCE.sendToServer(message);
    }

    public static <T> void sendToPlayer(T message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
