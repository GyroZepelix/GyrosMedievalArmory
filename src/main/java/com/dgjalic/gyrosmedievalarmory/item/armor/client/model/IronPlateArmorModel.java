package com.dgjalic.gyrosmedievalarmory.item.armor.client.model;

import com.dgjalic.gyrosmedievalarmory.item.armor.LegacyOpenableHelmet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class IronPlateArmorModel extends ArmorModel{
	private static final float HELMET_OPEN_SPEED = 20f;
	private final ModelPart visor;
	private final ModelPart visor_black;

	public IronPlateArmorModel(ModelPart pRoot) {
		super(pRoot);
		this.visor = this.hat.getChild("visor");
		this.visor_black = this.hat.getChild("visor_black");
	}

	@Override
	protected void setupArmorPartAnim(@NotNull LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		ItemStack helmet = entity.getItemBySlot(EquipmentSlot.HEAD);
		if (helmet.getItem() instanceof LegacyOpenableHelmet openableHelmet) {
			boolean isOpened = openableHelmet.isOpened(helmet);

			if (isOpened) {
				this.visor_black.xScale = 0;
				this.visor_black.yScale = 0;
				this.visor_black.zScale = 0;
				visor.xRot = -1.5f;
			} else {
				this.visor_black.xScale = 1;
				this.visor_black.yScale = 1;
				this.visor_black.zScale = 1;
				visor.xRot = 0f;
			}
		}
	}

//	protected void newSetupArmorPartAnim(@NotNull LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//		ItemStack helmet = entity.getItemBySlot(EquipmentSlot.HEAD);
//		if (helmet.getItem() instanceof OpenableHelmet openableHelmet) {
//			float visorXRot = this.visor.xRot;
//
//			boolean isOpened = openableHelmet.isOpened(helmet);
//			AnimationState animationState = openableHelmet.getAnimationStatus(helmet);
//			float animationStartTick = openableHelmet.getTimestamp(helmet);
//
//			switch (animationState) {
//                case IDLE -> {
//					if (isOpened) {
//						visor.xRot = -1.5f;
//					} else {
//						visor.xRot = 0f;
//					}
//                }
//                case QUEUED -> {
//					if (!isOpened) {
//						visor.xRot = -1.5f;
//					} else {
//						visor.xRot = 0f;
//					}
//					ModPackets.sendToServer(new SetHelmetAnimationStateC2SPacket(isOpened, AnimationState.PLAYING, ageInTicks));
//                }
//                case PLAYING -> {
//					if (isOpened) {
//						this.visor.xRot = AnimationUtil.linearLerp(ageInTicks, animationStartTick, HELMET_OPEN_SPEED, 0f, -1.5f);
//					} else {
//						this.visor.xRot = AnimationUtil.linearLerp(ageInTicks, animationStartTick, HELMET_OPEN_SPEED, -1.5f, -0f);
//					}
//                }
//            }
//
//			if (visorXRot != 0.0f) {
//				this.visor_black.xScale = 0;
//				this.visor_black.yScale = 0;
//				this.visor_black.zScale = 0;
//			} else {
//				this.visor_black.xScale = 1;
//				this.visor_black.yScale = 1;
//				this.visor_black.zScale = 1;
//			}
//		}
//	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = templateLayerDefinition(1f);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition visor = hat.addOrReplaceChild("visor", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition visor_r1 = visor.addOrReplaceChild("visor_r1", CubeListBuilder.create().texOffs(33, 85).addBox(1.0671F, -1.1142F, -6.175F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.75F)), PartPose.offsetAndRotation(0.007F, -1.7053F, 0.8649F, -0.0847F, 0.7563F, -0.0637F));

		PartDefinition visor_r2 = visor.addOrReplaceChild("visor_r2", CubeListBuilder.create().texOffs(35, 73).addBox(1.5303F, -0.319F, -6.7004F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(0.007F, -1.7053F, -0.1351F, 0.6656F, 0.6291F, 0.476F));

		PartDefinition visor_black = hat.addOrReplaceChild("visor_black", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition visor_black_r1 = visor_black.addOrReplaceChild("visor_black_r1", CubeListBuilder.create().texOffs(70, 76).addBox(0.942F, -0.5973F, -5.8951F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.48F)), PartPose.offsetAndRotation(0.007F, -5.7053F, 0.8649F, 0.3786F, 0.7365F, 0.2939F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.75F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 28).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.69F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 64).addBox(-3.0F, -6.0F, -0.5F, 6.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.7183F, -4.0977F, -0.3491F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(92, 0).addBox(0.4657F, 0.2386F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.2F))
				.texOffs(56, 0).addBox(0.4657F, 0.2386F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.offsetAndRotation(-1.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition left_arm_r2 = left_arm.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(72, 0).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.76F)), PartPose.offsetAndRotation(2.0F, 4.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(72, 0).mirror().addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.76F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition right_arm_r2 = right_arm.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(92, 0).mirror().addBox(-4.4657F, 0.2386F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.2F)).mirror(false)
				.texOffs(56, 0).mirror().addBox(-4.4657F, 0.2386F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.8F)).mirror(false), PartPose.offsetAndRotation(1.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition left_leg_r1 = left_leg.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(-2.1F, 1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.8F)).mirror(false), PartPose.offsetAndRotation(0.1F, -2.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition left_leg_r2 = left_leg.addOrReplaceChild("left_leg_r2", CubeListBuilder.create().texOffs(44, 56).addBox(-2.1F, 1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.9F)), PartPose.offsetAndRotation(0.1F, -2.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition right_leg_r1 = right_leg.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(44, 56).mirror().addBox(-1.9F, 1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.9F)).mirror(false), PartPose.offsetAndRotation(-0.1F, -2.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition right_leg_r2 = right_leg.addOrReplaceChild("right_leg_r2", CubeListBuilder.create().texOffs(0, 48).addBox(-1.9F, 1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.offsetAndRotation(-0.1F, -2.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition left_boot = partdefinition.addOrReplaceChild("left_boot", CubeListBuilder.create().texOffs(16, 56).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition right_boot = partdefinition.addOrReplaceChild("right_boot", CubeListBuilder.create().texOffs(16, 56).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
}