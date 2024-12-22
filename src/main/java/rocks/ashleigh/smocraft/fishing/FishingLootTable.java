package rocks.ashleigh.smocraft.fishing;

import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;

import rocks.ashleigh.smocraft.lib.Lootable;

public class FishingLootTable implements Lootable {
    private List<Lootable> pool;
    private int[] weights;

    public FishingLootTable(int[] weights, List<Lootable> loot) {
        this.weights = weights;
        this.pool = loot;
    }

    public static FishingLootTable of(int[] weights, Lootable... loot) {
        return new FishingLootTable(weights, List.of(loot));
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
        if (pool.isEmpty()) {
            throw new Error("No loot in table");
        }

        int luck = context.getKiller().getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LUCK_OF_THE_SEA);
        int totalWeight = pool.stream().mapToInt((lootable) -> lootable.getWeight(luck)).sum();

        int target = (int) (Math.random() * totalWeight);
        for (Lootable lootable : pool) {
            target -= lootable.getWeight(luck);
            if (target <= 0) {
                lootable.pick(context);
                return;
            }
        }
    }
}