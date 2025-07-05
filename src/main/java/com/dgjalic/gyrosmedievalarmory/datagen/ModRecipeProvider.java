package com.dgjalic.gyrosmedievalarmory.datagen;

import com.dgjalic.gyrosmedievalarmory.item.ItemRegistry;
import com.dgjalic.gyrosmedievalarmory.item.armor.AbstractArmorItem;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static com.dgjalic.gyrosmedievalarmory.datagen.ModRecipeProvider.ArmorRecipeBuilders.*;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        helmetWithToolItem(pWriter, ItemRegistry.LEATHER_CAP.get(), Items.LEATHER, Items.STRING);
        chestplateWithToolItem(pWriter, ItemRegistry.LEATHER_JACKET.get(), Items.LEATHER, Items.STRING);
        leggingsWithToolItem(pWriter, ItemRegistry.LEATHER_HOSE.get(), Items.LEATHER, Items.STRING);
        bootsWithToolItem(pWriter, ItemRegistry.LEATHER_BOOTS.get(), Items.LEATHER, Items.STRING);

        helmetItem(pWriter, ItemRegistry.CHAINMAIL_COIF.get(), Items.CHAIN);
        chestplateItem(pWriter, ItemRegistry.CHAINMAIL_SLEEVELESS_TUNIC.get(), Items.CHAIN);
        chestplateWithSleevesItem(pWriter, ItemRegistry.CHAINMAIL_TUNIC.get(), ItemRegistry.CHAINMAIL_SLEEVELESS_TUNIC.get(), Items.CHAIN);
        leggingsItem(pWriter, ItemRegistry.CHAINMAIL_LEGGINGS.get(), Items.CHAIN);
        bootsItem(pWriter, ItemRegistry.CHAINMAIL_BOOTS.get(), Items.CHAIN);

        // Simplified recipes for MVP
//        helmetWithToolItem(pWriter, ItemRegistry.PLATE_HELMET.get(), Items.IRON_INGOT, ItemRegistry.IRON_HAMMER.get());
//        chestplateWithToolItem(pWriter, ItemRegistry.PLATE_CHESTPLATE.get(), Items.IRON_INGOT, ItemRegistry.IRON_HAMMER.get());
//        leggingsWithToolItem(pWriter, ItemRegistry.PLATE_LEGGINGS.get(), Items.IRON_INGOT, ItemRegistry.IRON_HAMMER.get());
//        bootsWithToolItem(pWriter, ItemRegistry.PLATE_BOOTS.get(), Items.IRON_INGOT, ItemRegistry.IRON_HAMMER.get());
        helmetItem(pWriter, ItemRegistry.PLATE_HELMET.get(), Items.IRON_INGOT);
        chestplateItem(pWriter, ItemRegistry.PLATE_CHESTPLATE.get(), Items.IRON_INGOT);
        leggingsItem(pWriter, ItemRegistry.PLATE_LEGGINGS.get(), Items.IRON_INGOT);
        bootsItem(pWriter, ItemRegistry.PLATE_BOOTS.get(), Items.IRON_INGOT);

        helmetItem(pWriter, ItemRegistry.CRUDE_COPPER_HELMET.get(), Items.COPPER_INGOT);
        chestplateItem(pWriter, ItemRegistry.CRUDE_COPPER_CHESTPLATE.get(), Items.COPPER_INGOT);
        leggingsItem(pWriter, ItemRegistry.CRUDE_COPPER_LEGGINGS.get(), Items.COPPER_INGOT);
        bootsItem(pWriter, ItemRegistry.CRUDE_COPPER_BOOTS.get(), Items.COPPER_INGOT);

        // Simplified recipes for MVP
//        helmetWithToolItem(pWriter, ItemRegistry.COPPER_HELMET.get(), Items.COPPER_INGOT, ItemRegistry.WOODEN_HAMMER.get());
//        chestplateWithToolItem(pWriter, ItemRegistry.COPPER_CHESTPLATE.get(), Items.COPPER_INGOT, ItemRegistry.WOODEN_HAMMER.get());
//        leggingsWithToolItem(pWriter, ItemRegistry.COPPER_LEGGINGS.get(), Items.COPPER_INGOT, ItemRegistry.WOODEN_HAMMER.get());
//        bootsWithToolItem(pWriter, ItemRegistry.COPPER_BOOTS.get(), Items.COPPER_INGOT, ItemRegistry.WOODEN_HAMMER.get());
        helmetItem(pWriter, ItemRegistry.COPPER_HELMET.get(), Items.COPPER_INGOT);
        chestplateItem(pWriter, ItemRegistry.COPPER_CHESTPLATE.get(), Items.COPPER_INGOT);
        leggingsItem(pWriter, ItemRegistry.COPPER_LEGGINGS.get(), Items.COPPER_INGOT);
        bootsItem(pWriter, ItemRegistry.COPPER_BOOTS.get(), Items.COPPER_INGOT);

        hammerLikeItem(pWriter, ItemRegistry.IRON_HAMMER.get(), Items.IRON_INGOT);
        hammerLikeItem(pWriter, ItemRegistry.WOODEN_HAMMER.get(), ItemTags.LOGS);

    }

    protected static class ArmorRecipeBuilders {
        protected static void helmetItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, ItemLike ingredient) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                    .pattern("XXX")
                    .pattern("X X")
                    .define('X', ingredient)
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(pFinishedRecipeConsumer);
        }
        protected static void chestplateItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, ItemLike ingredient) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                    .pattern("X X")
                    .pattern("XXX")
                    .pattern("XXX")
                    .define('X', ingredient)
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(pFinishedRecipeConsumer);
        }
        protected static void chestplateWithSleevesItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, AbstractArmorItem ingredientArmor, ItemLike ingredient) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                    .pattern("XAX")
                    .define('X', ingredient)
                    .define('A', ingredientArmor)
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(pFinishedRecipeConsumer);
        }
        protected static void leggingsItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, ItemLike ingredient) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                    .pattern("XXX")
                    .pattern("X X")
                    .pattern("X X")
                    .define('X', ingredient)
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(pFinishedRecipeConsumer);
        }
        protected static void bootsItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, ItemLike ingredient) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                    .pattern("X X")
                    .pattern("X X")
                    .define('X', ingredient)
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(pFinishedRecipeConsumer);
        }

        protected static void helmetWithToolItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, ItemLike ingredient, ItemLike tool) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                    .pattern("XXX")
                    .pattern("XTX")
                    .define('X', ingredient)
                    .define('T', tool)
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(pFinishedRecipeConsumer);
        }
        protected static void chestplateWithToolItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, ItemLike ingredient, ItemLike tool) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                    .pattern("XTX")
                    .pattern("XXX")
                    .pattern("XXX")
                    .define('X', ingredient)
                    .define('T', tool)
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(pFinishedRecipeConsumer);
        }
        protected static void leggingsWithToolItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, ItemLike ingredient, ItemLike tool) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                    .pattern("XXX")
                    .pattern("XTX")
                    .pattern("X X")
                    .define('X', ingredient)
                    .define('T', tool)
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(pFinishedRecipeConsumer);
        }
        protected static void bootsWithToolItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, ItemLike ingredient, ItemLike tool) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                    .pattern("XTX")
                    .pattern("X X")
                    .define('X', ingredient)
                    .define('T', tool)
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(pFinishedRecipeConsumer);
        }
    }
    protected static void hammerLikeItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike hammerLikeItem, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hammerLikeItem)
                .pattern("XXX")
                .pattern("XSX")
                .pattern(" S ")
                .define('X', ingredient)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pFinishedRecipeConsumer);
    }

    protected static void hammerLikeItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike hammerLikeItem, TagKey<Item> ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hammerLikeItem)
                .pattern("XXX")
                .pattern("XSX")
                .pattern(" S ")
                .define('X', ItemTags.LOGS)
                .define('S', Items.STICK)
                .unlockedBy("has_logs", has(ingredient))
                .save(pFinishedRecipeConsumer);
    }
}
