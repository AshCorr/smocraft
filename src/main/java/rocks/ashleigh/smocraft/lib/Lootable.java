package rocks.ashleigh.smocraft.lib;

import org.bukkit.loot.LootContext;

public interface Lootable {
    int getWeight(int luck);
    void pick(LootContext context);
}
