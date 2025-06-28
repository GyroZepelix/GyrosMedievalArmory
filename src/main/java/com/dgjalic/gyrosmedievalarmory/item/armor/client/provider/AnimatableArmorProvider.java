package com.dgjalic.gyrosmedievalarmory.item.armor.client.provider;

import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.ArmorModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AnimatableArmorProvider implements ArmorModelProvider{
    private final ArmorModel model;
    private final Map<String, ModelPart> animatableModelParts;
    private final Consumer<AnimationProviderDTO> animationProvider;

    public AnimatableArmorProvider(
            Supplier<LayerDefinition> definitionSupplier,
            Function<ModelPart, ArmorModel> model,
            Set<String> animatableHatParts,
            Consumer<AnimationProviderDTO> animationProvider
    ) {
        this.model = model.apply(definitionSupplier.get().bakeRoot());
        this.animatableModelParts = getAnimatableModelParts(animatableHatParts);
        this.animationProvider = animationProvider;
    }

    @Override
    public ArmorModel getModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot slot) {
        return model;
    }

    @Override
    public void applyAnimations(ArmorModel model, LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot) {
        AnimationProviderDTO animationProviderDTO = new AnimationProviderDTO(animatableModelParts, livingEntity, itemStack, equipmentSlot);
        animationProvider.accept(animationProviderDTO);
    }

    private Map<String, ModelPart> getAnimatableModelParts(Set<String> parts) {
        return parts.stream().collect(Collectors.toMap((part) -> part, model.hat::getChild));
    }
}