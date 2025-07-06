package com.dgjalic.gyrosmedievalarmory.item.armor.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class PirateArmorModel extends ArmorModel{

	public PirateArmorModel(ModelPart pRoot) {
		super(pRoot);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = templateLayerDefinition(1f);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.65F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition visor_r1 = head.addOrReplaceChild("visor_r1", CubeListBuilder.create().texOffs(79, 23).mirror().addBox(-4.0F, -4.0F, -4.0F, 11.0F, 7.0F, 11.0F, new CubeDeformation(1.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.0F, -2.0F, 0.3465F, -0.7703F, -0.2444F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 28).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.69F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(42, 59).mirror().addBox(-1.0F, -1.5F, -0.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(2.1244F, 5.3193F, -2.8812F, 0.211F, 0.7332F, 0.2227F));

		PartDefinition body_r2 = body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(40, 59).mirror().addBox(-5.0F, -1.5F, -0.5F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(3.0F, 0.5F, -2.5F, -0.2051F, 0.9924F, 0.0561F));

		PartDefinition body_r3 = body.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(57, 16).addBox(-0.8866F, 0.7304F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.7F)), PartPose.offsetAndRotation(-3.5F, 9.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition body_r4 = body.addOrReplaceChild("body_r4", CubeListBuilder.create().texOffs(57, 16).mirror().addBox(-2.1134F, 0.7304F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.7F)).mirror(false), PartPose.offsetAndRotation(3.5F, 9.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition body_r5 = body.addOrReplaceChild("body_r5", CubeListBuilder.create().texOffs(42, 59).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-2.1244F, 5.3193F, -2.8812F, 0.211F, -0.7332F, -0.2227F));

		PartDefinition body_r6 = body.addOrReplaceChild("body_r6", CubeListBuilder.create().texOffs(40, 59).addBox(-1.0F, -1.5F, -0.5F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-3.0F, 0.5F, -2.5F, -0.2051F, -0.9924F, -0.0561F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(72, 0).addBox(-0.4434F, -0.8447F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.76F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(72, 0).mirror().addBox(-3.5566F, -0.8447F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.76F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition left_boot = partdefinition.addOrReplaceChild("left_boot", CubeListBuilder.create().texOffs(16, 56).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition right_boot = partdefinition.addOrReplaceChild("right_boot", CubeListBuilder.create().texOffs(16, 56).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		//temporary fix for the waist, because its not mapped to the correct bone in EF
		PartDefinition waist = body.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(55, 36).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.51F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
}