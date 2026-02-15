package whirlpool.gods_of_olympus.Items;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.jspecify.annotations.Nullable;

public class HermesWingedSandals extends Item implements IItemExtension {
    public int FLIGHT_TIME = 1200; // 60 seconds in ticks (20 ticks per second)

    public HermesWingedSandals(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        if(entity instanceof Player player && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof HermesWingedSandals hermesWingedSandals && FLIGHT_TIME > 0) {
            player.getAbilities().mayfly = true;
            player.onUpdateAbilities();
            FLIGHT_TIME--;
        }else {

        }
    }
}
