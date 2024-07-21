package fr.wither.penguinmod.items;

import fr.wither.penguinmod.entity.ModEntities;
import fr.wither.penguinmod.utils.Commons;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Commons.MOD_ID);

    public static final RegistryObject<Item> PINDER_KINGUI = ITEMS.register("pinder_kingui",
            () -> new Item(new Item.Properties().food(ModFoods.PINDER_KINGUI)));

    public static final RegistryObject<Item> PENGUIN_SPAWN_EGG = ITEMS.register("penguin_spawn_egg",() -> new ForgeSpawnEggItem(ModEntities.PENGUIN, 0xffffff, 0x000000, new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
