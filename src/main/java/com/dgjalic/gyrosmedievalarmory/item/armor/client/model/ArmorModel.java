package com.dgjalic.gyrosmedievalarmory.item.armor.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class ArmorModel extends HumanoidModel<LivingEntity> {
    public final ModelPart leftBoot;
    public final ModelPart rightBoot;

    public ArmorModel(ModelPart pRoot) {
        super(pRoot);
        this.leftBoot = pRoot.getChild("left_boot");
        this.rightBoot = pRoot.getChild("right_boot");
    }

    public ArmorModel(ModelPart pRoot, Function<ResourceLocation, RenderType> pRenderType) {
        super(pRoot, pRenderType);
        this.leftBoot = pRoot.getChild("left_boot");
        this.rightBoot = pRoot.getChild("right_boot");
    }

    @Override
    public void setAllVisible(boolean pVisible) {
        super.setAllVisible(pVisible);
        this.leftBoot.visible = pVisible;
        this.rightBoot.visible = pVisible;
    }

    public void partVisible(EquipmentSlot slot) {
        this.setAllVisible(false);
        switch (slot) {
            case HEAD:
                this.head.visible = true;
                this.hat.visible = true;
                break;
            case CHEST:
                this.body.visible = true;
                this.rightArm.visible = true;
                this.leftArm.visible = true;
                break;
            case LEGS:
                this.leftLeg.visible = true;
                this.rightLeg.visible = true;
                break;
            case FEET:
                this.leftBoot.visible = true;
                this.rightBoot.visible = true;
        }
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack stack, @NotNull VertexConsumer consumer, int packedLight, int packedOverlay, float r, float g, float b, float a) {
        super.renderToBuffer(stack, consumer, packedLight, packedOverlay, r, g, b, a);
        this.leftBoot.render(stack, consumer, packedLight, packedOverlay, r, g, b, a);
        this.rightBoot.render(stack, consumer, packedLight, packedOverlay, r, g, b, a);
    }

    @Override
    protected @NotNull Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.body, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg, this.hat, this.rightBoot, this.leftBoot);
    }
}
