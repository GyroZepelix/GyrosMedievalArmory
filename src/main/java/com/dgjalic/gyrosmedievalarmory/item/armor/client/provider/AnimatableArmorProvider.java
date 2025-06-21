package com.dgjalic.gyrosmedievalarmory.item.armor.client.provider;

import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.ArmorModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.function.Function;
import java.util.function.Supplier;

public class AnimatableArmorProvider implements ArmorModelProvider{
    private final ArmorModel model;

    public AnimatableArmorProvider(
            Supplier<LayerDefinition> definitionSupplier,
            Function<ModelPart, ArmorModel> model
    ) {
        this.model = model.apply(definitionSupplier.get().bakeRoot());
    }

    @Override
    public ArmorModel getModel(LivingEntity living, ItemStack itemStack, EquipmentSlot slot) {
        return model;
    }

    @Override
    public void applyOffsets(ArmorModel model, LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot) {
        model.body.yScale = 2f;
    }
}
