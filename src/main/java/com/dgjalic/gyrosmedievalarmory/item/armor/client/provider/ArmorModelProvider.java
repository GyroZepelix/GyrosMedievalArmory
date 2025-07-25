package com.dgjalic.gyrosmedievalarmory.item.armor.client.provider;

import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.ArmorModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public interface ArmorModelProvider {
    ArmorModel getModel();

    ResourceLocation getTexture();

    default void applyAnimations(ArmorModel model, LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot) {}
}
