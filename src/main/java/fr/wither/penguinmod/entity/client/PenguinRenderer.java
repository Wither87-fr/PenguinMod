package fr.wither.penguinmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.wither.penguinmod.entity.custom.PenguinEntity;
import fr.wither.penguinmod.utils.Commons;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel<PenguinEntity>> {
    public PenguinRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PenguinModel<>(pContext.bakeLayer(ModModelLayers.PENGUIN_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(PenguinEntity penguinEntity) {
        return new ResourceLocation(Commons.MOD_ID, "textures/entity/penguin.png");
    }

    @Override
    public void render(PenguinEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
