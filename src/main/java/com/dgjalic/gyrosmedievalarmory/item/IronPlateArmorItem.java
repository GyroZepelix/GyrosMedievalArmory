package com.dgjalic.gyrosmedievalarmory.item;

import com.dgjalic.gyrosmedievalarmory.GyrosMedievalArmory;
import com.dgjalic.gyrosmedievalarmory.item.armor.AbstractArmorItem;
import com.dgjalic.gyrosmedievalarmory.item.armor.OpenableHelmet;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.IronPlateArmorModel;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.provider.AnimatableArmorProvider;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.provider.ArmorModelProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.Set;

public class IronPlateArmorItem extends AbstractArmorItem implements OpenableHelmet {
    private String TEXTURE_LOCATION = makeCustomTextureLocation(GyrosMedievalArmory.MODID, "iron_plate_armor");
    public IronPlateArmorItem(Type pType) {
        super(ArmorMaterials.LEATHER, pType, new Properties());
    }

    public IronPlateArmorItem(Type pType, String textureLocation) {
        super(ArmorMaterials.CHAIN, pType, new Properties());
        TEXTURE_LOCATION = makeCustomTextureLocation(GyrosMedievalArmory.MODID, textureLocation);
    }

    @Override
    protected boolean withCustomModel() {
        return true;
    }

    private static final float ANIMATION_SPEED = 0.1f;

    @Override
    protected ArmorModelProvider createModelProvider() {
        return new AnimatableArmorProvider(
                IronPlateArmorModel::createBodyLayer,
                IronPlateArmorModel::new,
                Set.of("visor", "visor_black"),
                dto -> {
                    if (dto.equipmentSlot() != EquipmentSlot.HEAD) {
                        return;
                    }

                    ItemStack helmet = dto.itemStack();
                    ItemStack helmetOnEntity = dto.livingEntity().getItemBySlot(dto.equipmentSlot());
                    if (helmetOnEntity != helmet) {
                        return;
                    }

                    if (helmet.getItem() instanceof OpenableHelmet openableHelmet) {
                        ModelPart visor = dto.model().get("visor");
                        ModelPart visor_black = dto.model().get("visor_black");
                        float currentXRot = visor.xRot;

                        if (openableHelmet.isOpened(helmet)) {
                            visor.xRot = Math.max(currentXRot - ANIMATION_SPEED, -1.5f);
                            visor_black.xScale = 0;
                            visor_black.yScale = 0;
                            visor_black.zScale = 0;
                            return;
                        }
                        visor.xRot = Math.min(currentXRot + ANIMATION_SPEED, 0f);
                        visor_black.xScale = 1;
                        visor_black.yScale = 1;
                        visor_black.zScale = 1;
                    }
                });
    }



    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return TEXTURE_LOCATION;
    }
}
