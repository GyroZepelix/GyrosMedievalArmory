package com.dgjalic.gyrosmedievalarmory.mixin;

import com.dgjalic.gyrosmedievalarmory.item.armor.AbstractArmorItem;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.model.ArmorModel;
import com.dgjalic.gyrosmedievalarmory.item.armor.client.provider.ArmorModelProvider;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HumanoidArmorLayer.class)
public abstract class MixinHumanoidArmorLayer<T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> extends RenderLayer<T, M> {
    public MixinHumanoidArmorLayer(RenderLayerParent<T, M> pRenderer) {
        super(pRenderer);
    }

    @Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/LivingEntity;FFFFFF)V", at = @At("HEAD"))
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch, CallbackInfo ci) {
        this.gyrosMedievalArmory$renderCustomArmor(pPoseStack, pBuffer, pLivingEntity, EquipmentSlot.HEAD, pPackedLight, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
        this.gyrosMedievalArmory$renderCustomArmor(pPoseStack, pBuffer, pLivingEntity, EquipmentSlot.CHEST, pPackedLight, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
        this.gyrosMedievalArmory$renderCustomArmor(pPoseStack, pBuffer, pLivingEntity, EquipmentSlot.LEGS, pPackedLight, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
        this.gyrosMedievalArmory$renderCustomArmor(pPoseStack, pBuffer, pLivingEntity, EquipmentSlot.FEET, pPackedLight, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
    }

    @SuppressWarnings("unchecked")
    @Unique
    private void gyrosMedievalArmory$renderCustomArmor(PoseStack stack, MultiBufferSource buffer, T entity, EquipmentSlot slot, int packedLight, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemStack = entity.getItemBySlot(slot);
        if (itemStack.getItem() instanceof AbstractArmorItem armorItem) {
            if (armorItem.getEquipmentSlot() == slot) {
                ArmorModelProvider provider = armorItem.createModelProvider();
                if(provider != null){
                    ArmorModel armorModel = provider.getModel();
                    armorModel.copyModelProperties(this.getParentModel());
                    armorModel.partVisible(slot);
                    Model model = getArmorModelHook(entity, itemStack, slot, (A) armorModel);

                    VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(provider.getTexture()));
                    model.renderToBuffer(stack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

                    if (itemStack.hasFoil()) {
                        model.renderToBuffer(stack, buffer.getBuffer(RenderType.armorEntityGlint()), packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
                    }
                }
            }
        }

    }

    @Shadow
    protected net.minecraft.client.model.Model getArmorModelHook(T entity, ItemStack itemStack, EquipmentSlot slot, A model) {
        throw new IllegalStateException("Mixin failed to shadow getArmorModelHook()");
    }

    /**
     * Since I already renderer my armor in my custom renderer, I will cancel the rendering if the item is a AotA armor item.
     */
    @Inject(method = "renderArmorPiece", at = @At("HEAD"), cancellable = true)
    private void onRenderArmorPiece(PoseStack stack, MultiBufferSource buffer, T entity, EquipmentSlot slot, int packedLight, A defaultModel, CallbackInfo ci) {
        ItemStack itemStack = entity.getItemBySlot(slot);
        if (itemStack.getItem() instanceof AbstractArmorItem) {
            ci.cancel();
        }
    }
}
