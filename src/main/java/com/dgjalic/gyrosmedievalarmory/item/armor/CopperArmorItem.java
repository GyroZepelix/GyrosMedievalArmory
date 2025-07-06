package com.dgjalic.gyrosmedievalarmory.item.armor;

import com.dgjalic.gyrosmedievalarmory.GyrosMedievalArmory;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.CopperArmorModel;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.CrudeCopperArmorModel;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.provider.ArmorModelProvider;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.provider.SimpleModelProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class CopperArmorItem extends AbstractArmorItem implements LegacyOpenableHelmet {
    private ResourceLocation TEXTURE_LOCATION = makeCustomTextureLocation(GyrosMedievalArmory.MODID, "copper_armor");
    public CopperArmorItem(Type pType) {
        super(ModArmorMaterials.COPPER, pType, new Properties());
    }

    public CopperArmorItem(Type pType, String textureLocation) {
        super(ModArmorMaterials.COPPER, pType, new Properties());
        TEXTURE_LOCATION = makeCustomTextureLocation(GyrosMedievalArmory.MODID, textureLocation);
    }

    @Override
    protected boolean withCustomModel() {
        return true;
    }

    @Override
    public ArmorModelProvider createModelProvider() {
        return new SimpleModelProvider(
                CopperArmorModel::createBodyLayer,
                CopperArmorModel::new,
                TEXTURE_LOCATION
        );
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return TEXTURE_LOCATION.toString();
    }
}
