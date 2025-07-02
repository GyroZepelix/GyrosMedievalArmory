package com.dgjalic.gyrosmedievalarmory.item;

import com.dgjalic.gyrosmedievalarmory.GyrosMedievalArmory;
import com.dgjalic.gyrosmedievalarmory.item.armor.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
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

    public static final RegistryObject<SimpleIronPlateHelmetItem> PLATE_HELMET = REGISTRY.register("plate_helmet", () -> new SimpleIronPlateHelmetItem(ArmorItem.Type.HELMET));
    public static final RegistryObject<IronPlateArmorItem> PLATE_BASCINET = REGISTRY.register("plate_bascinet", () -> new IronPlateArmorItem(ArmorItem.Type.HELMET));
    public static final RegistryObject<IronPlateArmorItem> PLATE_CHESTPLATE = REGISTRY.register("plate_chestplate", () -> new IronPlateArmorItem(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<IronPlateArmorItem> PLATE_LEGGINGS = REGISTRY.register("plate_leggings", () -> new IronPlateArmorItem(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<IronPlateArmorItem> PLATE_BOOTS = REGISTRY.register("plate_boots", () -> new IronPlateArmorItem(ArmorItem.Type.BOOTS));

    public static final RegistryObject<CrudeCopperArmorItem> CRUDE_COPPER_HELMET = REGISTRY.register("crude_copper_helmet", () -> new CrudeCopperArmorItem(ArmorItem.Type.HELMET));
    public static final RegistryObject<CrudeCopperArmorItem> CRUDE_COPPER_CHESTPLATE = REGISTRY.register("crude_copper_chestplate", () -> new CrudeCopperArmorItem(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<CrudeCopperArmorItem> CRUDE_COPPER_LEGGINGS = REGISTRY.register("crude_copper_leggings", () -> new CrudeCopperArmorItem(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<CrudeCopperArmorItem> CRUDE_COPPER_BOOTS = REGISTRY.register("crude_copper_boots", () -> new CrudeCopperArmorItem(ArmorItem.Type.BOOTS));

    public static final RegistryObject<CopperArmorItem> DECORATED_COPPER_HELMET = REGISTRY.register("decorated_copper_helmet", () -> new CopperArmorItem(ArmorItem.Type.HELMET, "decorated_copper_armor"));
    public static final RegistryObject<CopperArmorItem> COPPER_HELMET = REGISTRY.register("copper_helmet", () -> new CopperArmorItem(ArmorItem.Type.HELMET));
    public static final RegistryObject<CopperArmorItem> COPPER_CHESTPLATE = REGISTRY.register("copper_chestplate", () -> new CopperArmorItem(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<CopperArmorItem> COPPER_LEGGINGS = REGISTRY.register("copper_leggings", () -> new CopperArmorItem(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<CopperArmorItem> COPPER_BOOTS = REGISTRY.register("copper_boots", () -> new CopperArmorItem(ArmorItem.Type.BOOTS));


    public static final RegistryObject<HammerItem> WOODEN_HAMMER = REGISTRY.register("wooden_hammer", () -> new HammerItem(Tiers.WOOD, 6, -3.2F, new Item.Properties()));
    public static final RegistryObject<HammerItem> IRON_HAMMER = REGISTRY.register("iron_hammer", () -> new HammerItem(Tiers.IRON, 6, -3.1F, new Item.Properties()));
}