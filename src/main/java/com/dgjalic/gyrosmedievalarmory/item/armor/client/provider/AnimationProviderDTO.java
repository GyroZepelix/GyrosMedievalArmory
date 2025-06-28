package com.dgjalic.gyrosmedievalarmory.item.armor.client.provider;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public record AnimationProviderDTO(java.util.Map<String, net.minecraft.client.model.geom.ModelPart> model, LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot) {
}
