package whirlpool.gods_of_olympus.ExtendedEnums;

import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import java.awt.*;
import java.util.function.UnaryOperator;

public class ExtendedRarities {
    public static final Color POSEIDONS_COLOR = new Color(10, 151, 252);

    public static final EnumProxy<Rarity> POSEIDON = new EnumProxy<>(
            Rarity.class, -5, "gods_of_olympus:poseidon", (UnaryOperator<Style>) style -> style.withColor(POSEIDONS_COLOR.getRGB())
    );
}
