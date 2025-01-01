package rocks.ashleigh.smocraft.fishing.items.standard;

import org.bukkit.Material;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.plugin.java.JavaPlugin;

import rocks.ashleigh.smocraft.fishing.FishItem;

public class Salmon extends FishItem {
    public Salmon() {
        super("Salmon", 1, Material.SALMON, ItemRarity.COMMON);
    }
    
}
