package fr.wither.penguinmod.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.block.Blocks;

public class ModFoods {


    // For comparison, golden carrot (THE best vanilla food source, no question asked) is nutrition 6 and saturation 1.2f

    public static FoodProperties PINDER_KINGUI = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(1.5f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, getTicks(10)), 0.3f)
            .build();


    public static int getTicks(int seconds) {
        return 20 * seconds;
    }
}
