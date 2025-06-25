package com.dgjalic.gyrosmedievalarmory.item.armor.client.provider;

import com.dgjalic.gyrosmedievalarmory.item.armor.OpenableHelmet;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.ArmorModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.function.Function;
import java.util.function.Supplier;

public class TwoStateArmorProvider implements ArmorModelProvider{
    private final ArmorModel model;
    private final ArmorModel endStateModel;

    public TwoStateArmorProvider(
            Supplier<LayerDefinition> definitionSupplier,
            Supplier<LayerDefinition> endStateDefinitionSupplier,
            Function<ModelPart, ArmorModel> model
    ) {
        this.model = model.apply(definitionSupplier.get().bakeRoot());
        this.endStateModel = model.apply(endStateDefinitionSupplier.get().bakeRoot());
    }

    @Override
    public ArmorModel getModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot slot) {
        if (livingEntity instanceof Player player) {
            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
            if (helmet.getItem() instanceof OpenableHelmet openableHelmet && openableHelmet.isOpened(helmet)) {
                return endStateModel;
            }
        }

        return model;

//        if (itemStack.getItem() instanceof OpenableHelmet openableHelmet && openableHelmet.isOpened(itemStack)) {
//            return endStateModel;
//        }
//        return model;
    }
}