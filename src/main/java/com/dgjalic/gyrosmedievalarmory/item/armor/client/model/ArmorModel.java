package com.dgjalic.gyrosmedievalarmory.item.armor.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class ArmorModel extends HumanoidModel<LivingEntity> {
    public final ModelPart leftBoot;
    public final ModelPart rightBoot;
    public final ModelPart waist;

    public ArmorModel(ModelPart pRoot) {
        super(pRoot);
        this.leftBoot = pRoot.getChild("left_boot");
        this.rightBoot = pRoot.getChild("right_boot");
        this.waist = pRoot.getChild("waist");
    }

    public ArmorModel(ModelPart pRoot, Function<ResourceLocation, RenderType> pRenderType) {
        super(pRoot, pRenderType);
        this.leftBoot = pRoot.getChild("left_boot");
        this.rightBoot = pRoot.getChild("right_boot");
        this.waist = pRoot.getChild("waist");
    }

    @Override
    public void setAllVisible(boolean pVisible) {
        super.setAllVisible(pVisible);
        this.leftBoot.visible = pVisible;
        this.rightBoot.visible = pVisible;
        this.waist.visible = pVisible;
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
                this.waist.visible = true;
                break;
            case FEET:
                this.leftBoot.visible = true;
                this.rightBoot.visible = true;
        }
    }

    public static MeshDefinition templateLayerDefinition(float scale) {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F + scale, 0.0F));
        root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F + scale, 0.0F));
        root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F + scale, 0.0F));
        root.addOrReplaceChild("waist", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F + scale, 0.0F));
        root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F + scale, 0.0F));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F + scale, 0.0F));
        root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F + scale, 0.0F));
        root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F + scale, 0.0F));
        root.addOrReplaceChild("right_boot", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F + scale, 0.0F));
        root.addOrReplaceChild("left_boot", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F + scale, 0.0F));
        return mesh;
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack stack, @NotNull VertexConsumer consumer, int packedLight, int packedOverlay, float r, float g, float b, float a) {
        super.renderToBuffer(stack, consumer, packedLight, packedOverlay, r, g, b, a);
        this.leftBoot.render(stack, consumer, packedLight, packedOverlay, r, g, b, a);
        this.rightBoot.render(stack, consumer, packedLight, packedOverlay, r, g, b, a);
    }

    /**
     * Override this function to animate the model, instead of overriding {@link ArmorModel#setupAnim}.
     */
    protected void setupArmorPartAnim(@NotNull LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {};

    @Override
    public void setupAnim(@NotNull LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setupArmorPartAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }

    @SuppressWarnings("unchecked")
    public <M extends HumanoidModel<? extends LivingEntity>> void copyModelProperties(M original) {
        original.copyPropertiesTo((HumanoidModel) this);
        this.rightBoot.copyFrom(original.rightLeg);
        this.leftBoot.copyFrom(original.leftLeg);
    }

    @Override
    protected @NotNull Iterable<ModelPart> bodyParts() {
        return Iterables.concat(super.bodyParts(), ImmutableList.of(leftBoot, rightBoot));
    }
}
