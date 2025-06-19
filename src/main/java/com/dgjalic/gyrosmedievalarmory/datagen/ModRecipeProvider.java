package com.dgjalic.gyrosmedievalarmory.datagen;

import com.dgjalic.gyrosmedievalarmory.item.ItemRegistry;
import com.dgjalic.gyrosmedievalarmory.item.armor.AbstractArmorItem;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        helmetItem(pWriter, ItemRegistry.CHAINMAIL_COIF.get(), Items.CHAIN, Items.CHAIN);
        chestplateItem(pWriter, ItemRegistry.CHAINMAIL_SLEEVELESS_TUNIC.get(), Items.CHAIN, Items.CHAIN);
        chestplateWithSleevesItem(pWriter, ItemRegistry.CHAINMAIL_TUNIC.get(), ItemRegistry.CHAINMAIL_SLEEVELESS_TUNIC.get(), Items.CHAIN, Items.CHAIN);
        leggingsItem(pWriter, ItemRegistry.CHAINMAIL_LEGGINGS.get(), Items.CHAIN, Items.CHAIN);
        bootsItem(pWriter, ItemRegistry.CHAINMAIL_BOOTS.get(), Items.CHAIN, Items.CHAIN);
    }

    protected static void helmetItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, ItemLike ingredient, ItemLike unlockedBy) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                .pattern("XXX")
                .pattern("X X")
                .define('X', ingredient)
                .unlockedBy(getHasName(unlockedBy), has(Items.CHAIN))
                .save(pFinishedRecipeConsumer);
    }
    protected static void chestplateItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, ItemLike ingredient, ItemLike unlockedBy) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ingredient)
                .unlockedBy(getHasName(unlockedBy), has(Items.CHAIN))
                .save(pFinishedRecipeConsumer);
    }
    protected static void chestplateWithSleevesItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, AbstractArmorItem ingredientArmor, ItemLike ingredient, ItemLike unlockedBy) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                .pattern("XAX")
                .define('X', ingredient)
                .define('A', ingredientArmor)
                .unlockedBy(getHasName(unlockedBy), has(Items.CHAIN))
                .save(pFinishedRecipeConsumer);
    }
    protected static void leggingsItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, ItemLike ingredient, ItemLike unlockedBy) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', ingredient)
                .unlockedBy(getHasName(unlockedBy), has(Items.CHAIN))
                .save(pFinishedRecipeConsumer);
    }
    protected static void bootsItem(Consumer<FinishedRecipe> pFinishedRecipeConsumer, AbstractArmorItem armorItem, ItemLike ingredient, ItemLike unlockedBy) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItem)
                .pattern("X X")
                .pattern("X X")
                .define('X', ingredient)
                .unlockedBy(getHasName(unlockedBy), has(Items.CHAIN))
                .save(pFinishedRecipeConsumer);
    }
}
