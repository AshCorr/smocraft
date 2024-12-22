package rocks.ashleigh.smocraft.fishing.reward;

import org.bukkit.entity.FishHook;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import rocks.ashleigh.smocraft.lib.Lootable;

public class FishingItemReward implements Lootable {

    private int[] weights;
    private ItemStack reward;
    private boolean announce;

    public FishingItemReward(int[] weights, ItemStack reward, boolean announce) {
        this.weights = weights;
        this.reward = reward;
        this.announce = announce;
    }

    
    public FishingItemReward(int[] weights, ItemStack reward) {
        this(weights, reward, false);
        this.weights = weights;
        this.reward = reward;
    }
    
    @Override
    public int getWeight(int luck) {
        if (luck > weights.length) {
            return weights[weights.length - 1];
        } else {
            return weights[luck];
        }
    }

    @Override
    public void pick(LootContext context) {
        FishHook hook = (FishHook) context.getLootedEntity();
        Item droppedItem = context.getLocation().getWorld().dropItemNaturally(context.getLocation(), reward);

        hook.setHookedEntity(droppedItem);
        hook.pullHookedEntity();

        if (announce) {
            hook.getWorld().sendMessage(
                Component.text()
                    .append(Component.text(context.getKiller().getName())
                    .append(Component.text(" caught a ", NamedTextColor.GRAY))
                    .append(droppedItem.getItemStack().displayName())
            ).build());
        }
    }
    
}
