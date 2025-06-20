package com.dgjalic.gyrosmedievalarmory.item;

import com.dgjalic.gyrosmedievalarmory.GyrosMedievalArmory;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> REGISTRY =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GyrosMedievalArmory.MODID);

    public static final RegistryObject<CreativeModeTab> ARMORY_TAB = REGISTRY.register("medieval_armory_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ItemRegistry.LEATHER_JACKET.get()))
                    .title(Component.translatable("creativetab.medieval_armory_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        for (RegistryObject<Item> item: ItemRegistry.REGISTRY.getEntries()) {
                            pOutput.accept(item.get());
                        }
                    })
                    .build()
    );
}
