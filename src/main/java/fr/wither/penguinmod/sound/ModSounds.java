package fr.wither.penguinmod.sound;

import fr.wither.penguinmod.utils.Commons;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Commons.MOD_ID);

    public static final RegistryObject<SoundEvent> QUACK = registerSoundEvent("quack");
    public static final RegistryObject<SoundEvent> WADDLE = registerSoundEvent("waddle");
    public static final RegistryObject<SoundEvent> HURT = registerSoundEvent("hurt");
    public static final RegistryObject<SoundEvent> DEATH = registerSoundEvent("death");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Commons.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
