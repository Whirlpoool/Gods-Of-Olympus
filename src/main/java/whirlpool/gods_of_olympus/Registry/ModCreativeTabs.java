package whirlpool.gods_of_olympus.Registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import whirlpool.gods_of_olympus.Gods_of_olympus;

import java.awt.*;
import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Gods_of_olympus.MODID);

    public static final Color GODS_OF_OLYMPUS_TAB_COLOR = new Color(255, 196, 0); // Gold color for the tab

    public static final Supplier<CreativeModeTab> GODS_OF_OLYMPUS_TAB = CREATIVE_MODE_TABS.register("gods_of_olympus_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.POSEIDONS_TRIDENT.get()))
            .title(Component.translatable("creativetab.gods_of_olympus.gods_of_olympus_tab").withStyle(style -> style.withColor(GODS_OF_OLYMPUS_TAB_COLOR.getRGB())))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.POSEIDONS_TRIDENT);
                output.accept(ModItems.HADES_HELM_OF_DARKNESS);
                output.accept(ModItems.HERMES_WINGED_SANDALS);
                output.accept(ModItems.APOLLOS_BOW_OF_LIGHT);
                output.accept(ModItems.ZEUS_MASTER_BOLT);
                output.accept(ModItems.AEGIS_SHEILD_OF_ATHENA);
                output.accept(ModItems.ARES_SPEAR_OF_WAR);
                output.accept(ModItems.ARTEMIS_BOW_OF_THE_HUNT);
                output.accept(ModItems.HEPHAESTUS_HAMMER_OF_FIRE);
                output.accept(ModItems.BLESSING_OF_OLYMPUS);
                output.accept(ModItems.BLESSING_OF_POSEIDON);
                output.accept(ModItems.BLESSING_OF_HADES);
                output.accept(ModItems.BLESSING_OF_HERMES);
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
