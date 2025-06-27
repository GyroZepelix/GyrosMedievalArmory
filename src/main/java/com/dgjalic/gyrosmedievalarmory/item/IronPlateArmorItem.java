package com.dgjalic.gyrosmedievalarmory.item;

import com.dgjalic.gyrosmedievalarmory.GyrosMedievalArmory;
import com.dgjalic.gyrosmedievalarmory.item.armor.AbstractArmorItem;
import com.dgjalic.gyrosmedievalarmory.item.armor.OpenableHelmet;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.IronPlateArmorModel;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.provider.TwoStateArmorProvider;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.provider.ArmorModelProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

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

    @Override
    protected ArmorModelProvider createModelProvider() {
        return new TwoStateArmorProvider(IronPlateArmorModel::createBodyLayer, IronPlateArmorModel::createVariantBodyLayer, IronPlateArmorModel::new);
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return TEXTURE_LOCATION;
    }
}
