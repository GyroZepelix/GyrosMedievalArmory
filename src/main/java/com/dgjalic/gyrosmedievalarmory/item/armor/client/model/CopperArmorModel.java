package com.dgjalic.gyrosmedievalarmory.item.armor.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class CopperArmorModel extends ArmorModel{

	public CopperArmorModel(ModelPart pRoot) {
		super(pRoot);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = templateLayerDefinition(1f);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.75F))
				.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(82, 18).addBox(0.0F, -9.0F, -10.0F, 0.0F, 14.0F, 23.0F, new CubeDeformation(0.0F))
				.texOffs(79, 20).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(59, 19).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 28).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.69F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 64).addBox(-3.0F, -6.0F, -0.5F, 6.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.7183F, -4.0977F, -0.3491F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(92, 0).addBox(0.4656F, 0.2386F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.2F))
				.texOffs(56, 0).addBox(0.4656F, 0.2386F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.offsetAndRotation(-1.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition left_arm_r2 = left_arm.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(72, 0).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.76F)), PartPose.offsetAndRotation(2.0F, 4.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(112, 0).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition left_leg_r1 = left_leg.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(44, 56).addBox(-2.1F, 1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.9F)), PartPose.offsetAndRotation(0.1F, -2.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition right_leg_r1 = right_leg.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(44, 56).mirror().addBox(-1.9F, 1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.9F)).mirror(false), PartPose.offsetAndRotation(-0.1F, -2.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition right_leg_r2 = right_leg.addOrReplaceChild("right_leg_r2", CubeListBuilder.create().texOffs(0, 48).addBox(-1.9F, 1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.offsetAndRotation(-0.1F, -2.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition left_boot = partdefinition.addOrReplaceChild("left_boot", CubeListBuilder.create().texOffs(16, 56).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition right_boot = partdefinition.addOrReplaceChild("right_boot", CubeListBuilder.create().texOffs(16, 56).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		//temporary fix for the waist, because its not mapped to the correct bone in EF
		PartDefinition waist = body.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(55, 36).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
}