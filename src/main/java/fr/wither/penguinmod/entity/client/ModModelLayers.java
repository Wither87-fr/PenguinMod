package fr.wither.penguinmod.entity.client;

import fr.wither.penguinmod.utils.Commons;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation PENGUIN_LAYER = new ModelLayerLocation(
            new ResourceLocation(Commons.MOD_ID, "penguin_layer"), "main");
}
