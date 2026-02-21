package whirlpool.gods_of_olympus.Events;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import whirlpool.gods_of_olympus.Gods_of_olympus;
import whirlpool.gods_of_olympus.Items.HadesHelmOfDarkness;
import whirlpool.gods_of_olympus.Items.HermesWingedSandals;
import whirlpool.gods_of_olympus.Registry.ModEffects;

@EventBusSubscriber(modid = Gods_of_olympus.MODID)
public class EventHandler {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if(!(player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof HermesWingedSandals)) {
            player.removeEffect(ModEffects.FLIGHT);
        }

        if (!(player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof HadesHelmOfDarkness)) {
            player.removeEffect(ModEffects.HADES_INVIS);
        }

        if(!player.hasEffect(ModEffects.FLIGHT) && !player.isCreative() && !player.isSpectator()) {
            player.getAbilities().mayfly = false;
            player.getAbilities().flying = false;
            player.onUpdateAbilities();
        }
    }
}
