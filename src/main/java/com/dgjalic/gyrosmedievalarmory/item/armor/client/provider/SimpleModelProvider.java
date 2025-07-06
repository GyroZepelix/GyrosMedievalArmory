package com.dgjalic.gyrosmedievalarmory.item.armor.client.provider;

import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.ArmorModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;

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
    public ArmorModel getModel() {
        return model;
    }

    @Override
    public ResourceLocation getTexture() {
        return texture;
    }
}
