package whirlpool.gods_of_olympus.Renderer;

import net.minecraft.world.item.Rarity;
import whirlpool.gods_of_olympus.ExtendedEnums.ExtendedRarities;
import whirlpool.gods_of_olympus.Gods_of_olympus;

/**
 * A central collection of all custom Item Rarities added by the Gods of Olympus
 * mod.
 * 
 * This class exposes the actual {@link Rarity} enum values that are generated/proxied
 * by {@link ExtendedRarities}. Use these constants when defining Item properties.
 */
public class ModRarities {
    /**
     * Rareness/Rarity for items associated with Poseidon.
     */
    public static final Rarity POSEIDON = Rarity.valueOf(Gods_of_olympus.MODID + ":" + "poseidon");

    /**
     * Rareness/Rarity for items associated with Zeus.
     */
    public static final Rarity ZEUS = Rarity.valueOf(Gods_of_olympus.MODID + ":" + "zeus");

    /**
     * Rareness/Rarity for items associated with Hades.
     */
    public static final Rarity HADES = Rarity.valueOf(Gods_of_olympus.MODID + ":" + "hades");

    /**
     * Rareness/Rarity for items associated with Athena.
     */
    public static final Rarity ATHENA = Rarity.valueOf(Gods_of_olympus.MODID + ":" + "athena");

    /**
     * Rareness/Rarity for items associated with Apollo.
     */
    public static final Rarity APOLLO = Rarity.valueOf(Gods_of_olympus.MODID + ":" + "apollo");

    /**
     * Rareness/Rarity for items associated with Artemis.
     */
    public static final Rarity ARTEMIS = Rarity.valueOf(Gods_of_olympus.MODID + ":" + "artemis");

    /**
     * Rareness/Rarity for items associated with Ares.
     */
    public static final Rarity ARES = Rarity.valueOf(Gods_of_olympus.MODID + ":" + "ares");

    /**
     * Rareness/Rarity for items associated with Hermes.
     */
    public static final Rarity HERMES = Rarity.valueOf(Gods_of_olympus.MODID + ":" + "hermes");

    /**
     * Rareness/Rarity for items associated with Hephaestus.
     */
    public static final Rarity HEPHAESTUS = Rarity.valueOf(Gods_of_olympus.MODID + ":" + "hephaestus");
}
