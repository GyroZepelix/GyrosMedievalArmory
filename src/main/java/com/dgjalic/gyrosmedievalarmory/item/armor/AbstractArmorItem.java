package com.dgjalic.gyrosmedievalarmory.item.armor;

import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.ArmorModel;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.provider.ArmorModelProvider;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.*;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class AbstractArmorItem extends ArmorItem {
    public AbstractArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    public boolean isFullSetActive(LivingEntity living) {
        return isFullSetActive(living, this.getMaterial());
    }

    public static boolean isFullSetActive(LivingEntity living, ArmorMaterial materials) {
        if (living == null) {
            return false;
        }
        ArmorItem head = living.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof ArmorItem armorItem ? armorItem : null;
        Item chestPlate = living.getItemBySlot(EquipmentSlot.CHEST).getItem();
        ArmorItem chest;
        if (chestPlate instanceof ElytraItem || chestPlate instanceof AirItem) {
            return false;
        } else {
            chest = (ArmorItem) living.getItemBySlot(EquipmentSlot.CHEST).getItem();
        }
        ArmorItem legs = living.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof ArmorItem armorItem ? armorItem : null;
        ArmorItem feet = living.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof ArmorItem armorItem ? armorItem : null;
        return (head != null && legs != null && feet != null) && (head.getMaterial() == materials && chest.getMaterial() == materials && legs.getMaterial() == materials && feet.getMaterial() == materials);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeMods(EquipmentSlot slot) {return null;}

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@NotNull EquipmentSlot slot) {
        HashMultimap<Attribute, AttributeModifier> builder = HashMultimap.create();
        builder.putAll(super.getDefaultAttributeModifiers(slot));
        if (this.getAttributeMods(slot) != null) {
            builder.putAll(this.getAttributeMods(slot));
        }
        return builder;
    }

    protected boolean withCustomModel() { return false; }

    protected ArmorModelProvider createModelProvider() { return null;}

    @Override
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        if (!withCustomModel()) return;
        consumer.accept(new IClientItemExtensions() {
            private final ArmorModelProvider provider = createModelProvider();

            @Override
            public @NotNull ArmorModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> original) {
                ArmorModel armorModel = provider.getModel(living, stack, slot);
                armorModel.partVisible(slot);
                armorModel.crouching = original.crouching;
                armorModel.riding = original.riding;
                armorModel.young = original.young;
                return armorModel;
            }

            @Override
            public @NotNull Model getGenericArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                //fixes visibility bug because forge pain
                ArmorModel model = getHumanoidArmorModel(livingEntity, itemStack, equipmentSlot, original);
                copyModelProperties(original, model);
                provider.applyOffsets(model, livingEntity, itemStack, equipmentSlot);
                return model;
            }

            @SuppressWarnings("unchecked")
            private <T extends LivingEntity> void copyModelProperties(HumanoidModel<T> original, ArmorModel replacement) {
                original.copyPropertiesTo((HumanoidModel<T>) replacement);
                replacement.rightBoot.copyFrom(original.rightLeg);
                replacement.leftBoot.copyFrom(original.leftLeg);
            }
        });
    }

    public static String makeCustomTextureLocation(String nameSpace, String id) {
        return ResourceLocation.fromNamespaceAndPath(nameSpace, "textures/models/armor/custom/" + id + ".png").toString();
    }
}
