package whirlpool.gods_of_olympus.ExtendedEnums;

import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import java.awt.*;
import java.util.function.UnaryOperator;

/**
 * Handles the registration of custom Item Rarities using NeoForge's Enum
 * Extension system.
 * 
 * This class defines the specific RGB colors associated with each Olympian God and
 * creates the {@link EnumProxy} instances that are used to inject these new values into
 * the vanilla {@link Rarity} enum.
 */
public class ExtendedRarities {
    /**
     * Color for Poseidon items (Ocean Blue).
     */
    public static final Color POSEIDONS_COLOR = new Color(10, 151, 252);

    /**
     * Color for Zeus items (Golden/Electric Yellow-Orange).
     */
    public static final Color ZEUS_COLOR = new Color(184, 133, 48);

    /**
     * Color for Hades items (Dark Grey/Black).
     */
    public static final Color HADES_COLOR = new Color(37, 44, 49);

    /**
     * Color for Athena items (Silver/Grey).
     */
    public static final Color ATHENA_COLOR = new Color(187, 187, 187);

    /**
     * Color for Apollo items (Bright Sun Yellow).
     */
    public static final Color APOLLO_COLOR = new Color(255, 216, 98);

    /**
     * Color for Artemis items (Nature/Moon Purple).
     */
    public static final Color ARTEMIS_COLOR = new Color(143, 84, 198);

    /**
     * Color for Ares items (Blood Red).
     */
    public static final Color ARES_COLOR = new Color(118, 16, 16);

    /**
     * Color for Hermes items (Winged Silver/Blueish Grey).
     */
    public static final Color HERMES_COLOR = new Color(154, 167, 178);

    /**
     * Color for Hephaestus items (Fiery Red).
     */
    public static final Color HEPHAESTUS_COLOR = new Color(216, 0, 0);

    /**
     * EnumProxy for Poseidon Rarity.
     * Applies {@link #POSEIDONS_COLOR} to the item name.
     */
    public static final EnumProxy<Rarity> POSEIDON = new EnumProxy<>(
                    Rarity.class, -5, "gods_of_olympus:poseidon",
                    (UnaryOperator<Style>) style -> style.withColor(POSEIDONS_COLOR.getRGB()));

    /**
     * EnumProxy for Zeus Rarity.
     * Applies {@link #ZEUS_COLOR} to the item name.
     */
    public static final EnumProxy<Rarity> ZEUS = new EnumProxy<>(
                    Rarity.class, -6, "gods_of_olympus:zeus",
                    (UnaryOperator<Style>) style -> style.withColor(ZEUS_COLOR.getRGB()));

    /**
     * EnumProxy for Hades Rarity.
     * Applies {@link #HADES_COLOR} to the item name.
     */
    public static final EnumProxy<Rarity> HADES = new EnumProxy<>(
                    Rarity.class, -7, "gods_of_olympus:hades",
                    (UnaryOperator<Style>) style -> style.withColor(HADES_COLOR.getRGB()));

    /**
     * EnumProxy for Athena Rarity.
     * Applies {@link #ATHENA_COLOR} to the item name.
     */
    public static final EnumProxy<Rarity> ATHENA = new EnumProxy<>(
                    Rarity.class, -8, "gods_of_olympus:athena",
                    (UnaryOperator<Style>) style -> style.withColor(ATHENA_COLOR.getRGB()));

    /**
     * EnumProxy for Apollo Rarity.
     * Applies {@link #APOLLO_COLOR} to the item name.
     */
    public static final EnumProxy<Rarity> APOLLO = new EnumProxy<>(
                    Rarity.class, -9, "gods_of_olympus:apollo",
                    (UnaryOperator<Style>) style -> style.withColor(APOLLO_COLOR.getRGB()));

    /**
     * EnumProxy for Artemis Rarity.
     * Applies {@link #ARTEMIS_COLOR} to the item name.
     */
    public static final EnumProxy<Rarity> ARTEMIS = new EnumProxy<>(
                    Rarity.class, -10, "gods_of_olympus:artemis",
                    (UnaryOperator<Style>) style -> style.withColor(ARTEMIS_COLOR.getRGB()));

    /**
     * EnumProxy for Ares Rarity.
     * Applies {@link #ARES_COLOR} to the item name.
     */
    public static final EnumProxy<Rarity> ARES = new EnumProxy<>(
                    Rarity.class, -11, "gods_of_olympus:ares",
                    (UnaryOperator<Style>) style -> style.withColor(ARES_COLOR.getRGB()));

    /**
     * EnumProxy for Hermes Rarity.
     * Applies {@link #HERMES_COLOR} to the item name.
     */
    public static final EnumProxy<Rarity> HERMES = new EnumProxy<>(
                    Rarity.class, -12, "gods_of_olympus:hermes",
                    (UnaryOperator<Style>) style -> style.withColor(HERMES_COLOR.getRGB()));

    /**
     * EnumProxy for Hephaestus Rarity.
     * Applies {@link #HEPHAESTUS_COLOR} to the item name.
     */
    public static final EnumProxy<Rarity> HEPHAESTUS = new EnumProxy<>(
                    Rarity.class, -13, "gods_of_olympus:hephaestus",
                    (UnaryOperator<Style>) style -> style.withColor(HEPHAESTUS_COLOR.getRGB()));
}
