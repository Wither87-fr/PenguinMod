package fr.wither.penguinmod.items;

import fr.wither.penguinmod.utils.Commons;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Commons.MOD_ID);


    public static final RegistryObject<Item> PINDER_KINGUI = ITEMS.register("pinder_kingui",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(15).saturationMod(2.0f).build())));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
