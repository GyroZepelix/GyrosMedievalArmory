package com.dgjalic.gyrosmedievalarmory.item.armor;

import com.dgjalic.gyrosmedievalarmory.animation.Animatable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

//TODO: Refactor so animation state is stored locally
public interface OpenableHelmet extends Animatable {
    default boolean changeOpened(ItemStack openableHelmetStack, Level level, Player player) {
        final String IS_OPENED_KEY = "Opened";

        CompoundTag compoundTag = openableHelmetStack.getOrCreateTag();
        if (!compoundTag.contains(IS_OPENED_KEY)) {
            compoundTag.putBoolean(IS_OPENED_KEY, false);
        }

        boolean currentState = compoundTag.getBoolean(IS_OPENED_KEY);
        boolean toChange = !currentState;
        compoundTag.putBoolean(IS_OPENED_KEY, toChange);

        level.playSound(null, player.blockPosition(), getHelmetOpenSoundEvent(), SoundSource.PLAYERS, 0.8f, 1.3f);
        return toChange;
    };

    default SoundEvent getHelmetOpenSoundEvent() {
        return SoundEvents.ARMOR_EQUIP_NETHERITE;
    }

    default void setOpened(ItemStack openableHelmetStack, Level level, Player player, boolean opened) {
        final String IS_OPENED_KEY = "Opened";

        CompoundTag compoundTag = openableHelmetStack.getOrCreateTag();
        if (!compoundTag.contains(IS_OPENED_KEY)) {
            compoundTag.putBoolean(IS_OPENED_KEY, false);
        }

        compoundTag.putBoolean(IS_OPENED_KEY, opened);

        level.playSound(null, player.blockPosition(), getHelmetOpenSoundEvent(), SoundSource.PLAYERS, 0.5f, 1.3f);
    }

    default boolean isOpened(ItemStack openableHelmetStack) {
        final String IS_OPENED_KEY = "Opened";

        CompoundTag compoundTag = openableHelmetStack.getTag();
        if (compoundTag == null || !compoundTag.contains(IS_OPENED_KEY)) {
            return false;
        }

        return compoundTag.getBoolean(IS_OPENED_KEY);
    }

}
