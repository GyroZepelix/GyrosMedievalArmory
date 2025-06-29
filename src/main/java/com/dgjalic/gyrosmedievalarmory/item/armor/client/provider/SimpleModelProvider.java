package com.dgjalic.gyrosmedievalarmory.item.armor.client.provider;

import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.ArmorModel;
import com.mojang.datafixers.types.Func;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.function.Function;
import java.util.function.Supplier;

public class SimpleModelProvider implements ArmorModelProvider{
    private final ArmorModel model;
    private final ResourceLocation texture;

    public SimpleModelProvider(Supplier<LayerDefinition> definitionSupplier, Function<ModelPart, ArmorModel> model, ResourceLocation texture) {
        this.model = model.apply(definitionSupplier.get().bakeRoot());
        this.texture = texture;
    }

    @Override
    public ArmorModel getModel(LivingEntity living, ItemStack itemStack, EquipmentSlot slot) {
        return model;
    }

    @Override
    public ResourceLocation getTexture() {
        return texture;
    }
}
