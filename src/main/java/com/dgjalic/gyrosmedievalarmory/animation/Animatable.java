package com.dgjalic.gyrosmedievalarmory.animation;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

//TODO: Refactor so animation state is stored locally
public interface Animatable {
    default float getTimestamp(ItemStack animatableStack) {
        final String TIMESTAMP = "AnimTimestamp";

        CompoundTag compoundTag = animatableStack.getTag();
        if (compoundTag == null || !compoundTag.contains(TIMESTAMP)) {
            return 0f;
        }

        return compoundTag.getFloat(TIMESTAMP);
    }

    default void setTimestamp(ItemStack openableHelmetStack, Level level, Player player, float timestampInTicks) {
        final String TIMESTAMP = "AnimTimestamp";

        CompoundTag compoundTag = openableHelmetStack.getOrCreateTag();
        compoundTag.putFloat(TIMESTAMP, timestampInTicks);
    }

    default void setAnimationStatus(ItemStack animatableHelmet, Level level, Player player, AnimationState animationState) {
        final String ANIMATION_STATE = "AnimState";

        CompoundTag compoundTag = animatableHelmet.getOrCreateTag();
        compoundTag.putByte(ANIMATION_STATE, animationState.toByte());

        level.playSound(null, player.blockPosition(), SoundEvents.ARMOR_EQUIP_NETHERITE, SoundSource.PLAYERS, 0.5f, 1.3f);
    }

    default AnimationState getAnimationStatus(ItemStack animatableHelmet) {
        final String ANIMATION_STATE = "AnimState";

        CompoundTag compoundTag = animatableHelmet.getTag();
        if (compoundTag == null || !compoundTag.contains(ANIMATION_STATE)) {
            return AnimationState.IDLE;
        }

        return AnimationState.fromByte(compoundTag.getByte(ANIMATION_STATE));
    }
}
