package rocks.ashleigh.smocraft.fishing.items.unique;

import org.bukkit.Material;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.plugin.java.JavaPlugin;

import rocks.ashleigh.smocraft.fishing.FishItem;

public class Shark extends FishItem {
    public Shark() {
        super("Shark", 6, Material.PUFFERFISH, ItemRarity.EPIC);
    }
    
}
