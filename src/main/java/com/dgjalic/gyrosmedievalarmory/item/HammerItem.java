package com.dgjalic.gyrosmedievalarmory.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class HammerItem extends PickaxeItem {
    public HammerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return stack.getDamageValue() < stack.getMaxDamage() - 1;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        stack.setDamageValue(itemStack.getDamageValue() + 1);
        return stack;
    }
}
