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

        simpleItem(ItemRegistry.LEATHER_CAP);
        simpleItem(ItemRegistry.LEATHER_JACKET);
        simpleItem(ItemRegistry.LEATHER_SLEEVELESS_JACKET);
        simpleItem(ItemRegistry.LEATHER_HOSE);
        simpleItem(ItemRegistry.LEATHER_BOOTS);

        simpleItem(ItemRegistry.PLATE_HELMET);
        simpleItem(ItemRegistry.PLATE_BASCINET);
        simpleItem(ItemRegistry.PLATE_CHESTPLATE);
        simpleItem(ItemRegistry.PLATE_LEGGINGS);
        simpleItem(ItemRegistry.PLATE_BOOTS);

        simpleItem(ItemRegistry.CRUDE_COPPER_HELMET);
        simpleItem(ItemRegistry.CRUDE_COPPER_CHESTPLATE);
        simpleItem(ItemRegistry.CRUDE_COPPER_LEGGINGS);
        simpleItem(ItemRegistry.CRUDE_COPPER_BOOTS);

        simpleItem(ItemRegistry.COPPER_HELMET);
        simpleItem(ItemRegistry.DECORATED_COPPER_HELMET);
        simpleItem(ItemRegistry.COPPER_CHESTPLATE);
        simpleItem(ItemRegistry.COPPER_LEGGINGS);
        simpleItem(ItemRegistry.COPPER_BOOTS);
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
