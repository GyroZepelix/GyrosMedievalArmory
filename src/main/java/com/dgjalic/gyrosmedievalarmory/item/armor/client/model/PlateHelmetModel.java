package com.dgjalic.gyrosmedievalarmory.item.armor.client.model;

import com.dgjalic.gyrosmedievalarmory.animation.AnimationState;
import com.dgjalic.gyrosmedievalarmory.animation.AnimationUtil;
import com.dgjalic.gyrosmedievalarmory.item.armor.LegacyOpenableHelmet;
import com.dgjalic.gyrosmedievalarmory.item.armor.OpenableHelmet;
import com.dgjalic.gyrosmedievalarmory.networking.ModPackets;
import com.dgjalic.gyrosmedievalarmory.networking.packet.SetHelmetAnimationStateC2SPacket;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PlateHelmetModel extends ArmorModel{

	public PlateHelmetModel(ModelPart pRoot) {
		super(pRoot);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = templateLayerDefinition(1f);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.75F))
				.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}
}