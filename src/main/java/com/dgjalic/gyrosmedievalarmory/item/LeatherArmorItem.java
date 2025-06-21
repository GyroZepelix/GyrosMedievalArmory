package com.dgjalic.gyrosmedievalarmory.item;

import com.dgjalic.gyrosmedievalarmory.GyrosMedievalArmory;
import com.dgjalic.gyrosmedievalarmory.item.armor.AbstractArmorItem;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.ChainmailArmorModel;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.LeatherArmorModel;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.provider.AnimatableArmorProvider;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.provider.ArmorModelProvider;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.provider.SimpleModelProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class LeatherArmorItem extends AbstractArmorItem {
    private String TEXTURE_LOCATION = makeCustomTextureLocation(GyrosMedievalArmory.MODID, "leather_armor");
    public LeatherArmorItem(Type pType) {
        super(ArmorMaterials.LEATHER, pType, new Properties());
    }

    public LeatherArmorItem(Type pType, String textureLocation) {
        super(ArmorMaterials.CHAIN, pType, new Properties());
        TEXTURE_LOCATION = makeCustomTextureLocation(GyrosMedievalArmory.MODID, textureLocation);
    }

    @Override
    protected boolean withCustomModel() {
        return true;
    }

    @Override
    protected ArmorModelProvider createModelProvider() {
        return new AnimatableArmorProvider(LeatherArmorModel::createBodyLayer, LeatherArmorModel::new);
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return TEXTURE_LOCATION;
    }
}
