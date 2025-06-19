package com.dgjalic.gyrosmedievalarmory.datagen;

import com.dgjalic.gyrosmedievalarmory.GyrosMedievalArmory;
import com.dgjalic.gyrosmedievalarmory.item.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GyrosMedievalArmory.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemRegistry.CHAINMAIL_COIF);
        simpleItem(ItemRegistry.CHAINMAIL_TUNIC);
        simpleItem(ItemRegistry.CHAINMAIL_SLEEVELESS_TUNIC);
        simpleItem(ItemRegistry.CHAINMAIL_LEGGINGS);
        simpleItem(ItemRegistry.CHAINMAIL_BOOTS);
    }

    private <T extends Item> ItemModelBuilder simpleItem(RegistryObject<T> item) {
        return withExistingParent(
                    item.getId().getPath(),
                    ResourceLocation.parse("item/generated")
                ).texture(
                    "layer0",
                    ResourceLocation.fromNamespaceAndPath(GyrosMedievalArmory.MODID, "item/" + item.getId().getPath())
                );
    }
}
