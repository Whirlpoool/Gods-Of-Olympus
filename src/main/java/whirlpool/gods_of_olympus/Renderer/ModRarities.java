package whirlpool.gods_of_olympus.Renderer;

import net.minecraft.world.item.Rarity;
import whirlpool.gods_of_olympus.ExtendedEnums.ExtendedRarities;

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
    public static final Rarity POSEIDON = ExtendedRarities.POSEIDON.getValue();

    /**
     * Rareness/Rarity for items associated with Zeus.
     */
    public static final Rarity ZEUS = ExtendedRarities.ZEUS.getValue();

    /**
     * Rareness/Rarity for items associated with Hades.
     */
    public static final Rarity HADES = ExtendedRarities.HADES.getValue();

    /**
     * Rareness/Rarity for items associated with Athena.
     */
    public static final Rarity ATHENA = ExtendedRarities.ATHENA.getValue();

    /**
     * Rareness/Rarity for items associated with Apollo.
     */
    public static final Rarity APOLLO = ExtendedRarities.APOLLO.getValue();

    /**
     * Rareness/Rarity for items associated with Artemis.
     */
    public static final Rarity ARTEMIS = ExtendedRarities.ARTEMIS.getValue();

    /**
     * Rareness/Rarity for items associated with Ares.
     */
    public static final Rarity ARES = ExtendedRarities.ARES.getValue();

    /**
     * Rareness/Rarity for items associated with Hermes.
     */
    public static final Rarity HERMES = ExtendedRarities.HERMES.getValue();

    /**
     * Rareness/Rarity for items associated with Hephaestus.
     */
    public static final Rarity HEPHAESTUS = ExtendedRarities.HEPHAESTUS.getValue();
}
