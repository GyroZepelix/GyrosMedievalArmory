package com.dgjalic.gyrosmedievalarmory.item.armor.client.model;

import com.dgjalic.gyrosmedievalarmory.item.armor.LegacyOpenableHelmet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class LeatherHoodArmorModel extends ArmorModel{
	private final ModelPart closedHood;
	private final ModelPart openedHood;

	public LeatherHoodArmorModel(ModelPart pRoot) {
		super(pRoot);
		this.closedHood = this.head.getChild("closed_hood");
		this.openedHood = this.head.getChild("opened_hood");
	}

	@Override
	protected void setupArmorPartAnim(@NotNull LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		ItemStack helmet = entity.getItemBySlot(EquipmentSlot.HEAD);
		if (helmet.getItem() instanceof LegacyOpenableHelmet openableHelmet) {
			boolean isOpened = openableHelmet.isOpened(helmet);

			if (isOpened) {
				openedHood.xScale = 1f;
				openedHood.yScale = 1f;
				openedHood.zScale = 1f;
				closedHood.xScale = 0f;
				closedHood.yScale = 0f;
				closedHood.zScale = 0f;
			} else {
				openedHood.xScale = 0f;
				openedHood.yScale = 0f;
				openedHood.zScale = 0f;
				closedHood.xScale = 1f;
				closedHood.yScale = 1f;
				closedHood.zScale = 1f;
			}
		}
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = templateLayerDefinition(1f);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition closed_hood = head.addOrReplaceChild("closed_hood", CubeListBuilder.create().texOffs(64, 112).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.75F))
				.texOffs(96, 112).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.2F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition opened_hood = head.addOrReplaceChild("opened_hood", CubeListBuilder.create().texOffs(96, 96).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.2F))
				.texOffs(64, 96).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.75F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(26, 50).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(25, 28).addBox(-3.1034F, -1.0F, -3.0F, 7.0F, 10.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(25, 28).mirror().addBox(-3.8966F, -1.0F, -3.0F, 7.0F, 10.0F, 6.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}}