package com.dgjalic.gyrosmedievalarmory.item;

import com.dgjalic.gyrosmedievalarmory.GyrosMedievalArmory;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, GyrosMedievalArmory.MODID);

    public static final RegistryObject<ChainmailArmorItem> CHAINMAIL_COIF = REGISTRY.register("chainmail_coif", () -> new ChainmailArmorItem(ArmorItem.Type.HELMET));
    public static final RegistryObject<ChainmailArmorItem> CHAINMAIL_TUNIC = REGISTRY.register("chainmail_tunic", () -> new ChainmailArmorItem(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<ChainmailArmorItem> CHAINMAIL_SLEEVELESS_TUNIC = REGISTRY.register("chainmail_sleeveless_tunic", () -> new ChainmailArmorItem(ArmorItem.Type.CHESTPLATE, "chainmail_armor_no_sleeves"));
    public static final RegistryObject<ChainmailArmorItem> CHAINMAIL_LEGGINGS = REGISTRY.register("chainmail_leggings", () -> new ChainmailArmorItem(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<ChainmailArmorItem> CHAINMAIL_BOOTS = REGISTRY.register("chainmail_boots", () -> new ChainmailArmorItem(ArmorItem.Type.BOOTS));

    public static final RegistryObject<LeatherArmorItem> LEATHER_CAP = REGISTRY.register("leather_cap", () -> new LeatherArmorItem(ArmorItem.Type.HELMET));
    public static final RegistryObject<LeatherArmorItem> LEATHER_JACKET = REGISTRY.register("leather_jacket", () -> new LeatherArmorItem(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<LeatherArmorItem> LEATHER_SLEEVELESS_JACKET = REGISTRY.register("leather_sleeveless_jacket", () -> new LeatherArmorItem(ArmorItem.Type.CHESTPLATE, "leather_armor_no_sleeves"));
    public static final RegistryObject<LeatherArmorItem> LEATHER_HOSE = REGISTRY.register("leather_hose", () -> new LeatherArmorItem(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<LeatherArmorItem> LEATHER_BOOTS = REGISTRY.register("leather_boots", () -> new LeatherArmorItem(ArmorItem.Type.BOOTS));
}