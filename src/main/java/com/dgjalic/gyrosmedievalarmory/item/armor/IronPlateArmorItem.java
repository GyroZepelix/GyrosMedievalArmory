package com.dgjalic.gyrosmedievalarmory.item.armor;

import com.dgjalic.gyrosmedievalarmory.GyrosMedievalArmory;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.IronPlateArmorModel;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.provider.ArmorModelProvider;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.provider.SimpleModelProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class IronPlateArmorItem extends AbstractArmorItem implements LegacyOpenableHelmet {
    private ResourceLocation TEXTURE_LOCATION = makeCustomTextureLocation(GyrosMedievalArmory.MODID, "iron_plate_armor");
    public IronPlateArmorItem(Type pType) {
        super(ModArmorMaterials.IRON_PLATE, pType, new Properties());
    }

    public IronPlateArmorItem(Type pType, String textureLocation) {
        super(ModArmorMaterials.IRON_PLATE, pType, new Properties());
        TEXTURE_LOCATION = makeCustomTextureLocation(GyrosMedievalArmory.MODID, textureLocation);
    }

    @Override
    protected boolean withCustomModel() {
        return true;
    }

    @Override
    public ArmorModelProvider createModelProvider() {
        return new SimpleModelProvider(
                IronPlateArmorModel::createBodyLayer,
                IronPlateArmorModel::new,
                TEXTURE_LOCATION
        );
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return TEXTURE_LOCATION.toString();
    }
}
