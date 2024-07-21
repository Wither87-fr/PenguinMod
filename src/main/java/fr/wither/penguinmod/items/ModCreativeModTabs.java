package fr.wither.penguinmod.items;

import fr.wither.penguinmod.utils.Commons;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Commons.MOD_ID);


    public static final RegistryObject<CreativeModeTab> PENGUIN_TAB = CREATIVE_MODE_TABS.register("penguin_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.PINDER_KINGUI.get()))
            .title(Component.translatable("creativetab.penguin_tab"))
            .displayItems((params, output) -> {
                output.accept(ModItems.PINDER_KINGUI.get());
                output.accept(ModItems.PENGUIN_SPAWN_EGG.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
