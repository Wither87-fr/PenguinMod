package fr.wither.penguinmod.event;


import fr.wither.penguinmod.entity.ModEntities;
import fr.wither.penguinmod.entity.client.ModModelLayers;
import fr.wither.penguinmod.entity.client.PenguinModel;
import fr.wither.penguinmod.entity.client.PenguinRenderer;
import fr.wither.penguinmod.utils.Commons;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Commons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.PENGUIN_LAYER, PenguinModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        EntityRenderers.register(ModEntities.PENGUIN.get(), PenguinRenderer::new);
    }
}
