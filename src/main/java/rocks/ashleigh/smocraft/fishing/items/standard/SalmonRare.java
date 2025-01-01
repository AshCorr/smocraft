package rocks.ashleigh.smocraft.fishing.items.standard;

import org.bukkit.Material;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.plugin.java.JavaPlugin;

import rocks.ashleigh.smocraft.fishing.FishItem;

public class SalmonRare extends FishItem {
    public SalmonRare() {
        super("Salmon", 1, Material.SALMON, ItemRarity.RARE);
    }
    
}
