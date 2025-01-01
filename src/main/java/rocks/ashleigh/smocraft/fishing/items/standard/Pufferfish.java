package rocks.ashleigh.smocraft.fishing.items.standard;

import org.bukkit.Material;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.plugin.java.JavaPlugin;

import rocks.ashleigh.smocraft.fishing.FishItem;

public class Pufferfish extends FishItem {
    public Pufferfish() {
        super("Pufferfish", 1, Material.PUFFERFISH, ItemRarity.COMMON);
    }
    
}
