package whirlpool.gods_of_olympus.Events;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.entity.npc.villager.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import whirlpool.gods_of_olympus.Gods_of_olympus;
import whirlpool.gods_of_olympus.Items.ApollosBowOfLight;
import whirlpool.gods_of_olympus.Items.HadesHelmOfDarkness;
import whirlpool.gods_of_olympus.Items.HermesWingedSandals;
import whirlpool.gods_of_olympus.Registry.ModEffects;
import whirlpool.gods_of_olympus.Registry.ModItems;

import java.util.List;
import java.util.Optional;

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

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        rareTrades.add((level,entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 64),
                Optional.of(new ItemCost(Items.PHANTOM_MEMBRANE, 1)),
                new ItemStack(ModItems.BLESSING_OF_HERMES.get(), 1), 1, 10, 0.2f));
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.CLERIC) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(5).add((level,entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    Optional.of(new ItemCost(Items.DIAMOND_BLOCK, 1)),
                    new ItemStack(ModItems.BLESSING_OF_OLYMPUS.get(), 1), 10, 10, 0.2f));
        }
    }

    @SubscribeEvent
    public static void onMobTarget(LivingChangeTargetEvent event) {
        // Check if the entity being targeted is a player
        if (event.getNewAboutToBeSetTarget() instanceof Player player) {

            // Check if the player has your specific effect
            if (player.hasEffect(ModEffects.HADES_INVIS)) {
                // If the player hasn't hit this mob yet, stop the mob from targeting them
                // We check the mob's 'LastHurtByMob' to see if the player is the aggressor
                if (event.getEntity().getLastHurtByMob() != player) {
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onBowTick(LivingEntityUseItemEvent.Tick event) {
        ItemStack stack = event.getItem();
        // Check if it's a bow (or your specific custom bow)
        if (stack.getItem() instanceof ApollosBowOfLight) {
            // Subtract an extra tick every frame to double the speed
            event.setDuration(event.getDuration() - 2);
        }
    }
}
